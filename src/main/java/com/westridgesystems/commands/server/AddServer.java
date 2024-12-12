package com.westridgesystems.commands.server;

import com.westridgesystems.config.TakCtlConfig;
import com.westridgesystems.config.TakServer;
import com.westridgesystems.util.FileUtil;
import jakarta.inject.Inject;
import picocli.CommandLine;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.security.KeyStore;
import java.security.cert.X509Certificate;

@CommandLine.Command(name = "add", mixinStandardHelpOptions = true,
        description = "Add a new TAK server.")
public class AddServer implements Runnable {

    @CommandLine.Option(names = {"-n", "--name"}, required = true, description = "Server name.")
    private String name;

    @CommandLine.Option(names = {"-h", "--hostname"}, required = true, description = "Host name or IP.")
    private String hostname;

    @CommandLine.Option(names = {"-p", "--port"}, defaultValue = "8089", description = "Port of API server.")
    private int port;

    @CommandLine.Option(names = {"-c", "--cacert"}, description = "Server CA certificate.")
    private String caCert;

    @Inject
    TakCtlConfig config;

    @CommandLine.Spec
    CommandLine.Model.CommandSpec spec;

    @Override
    public void run() {
        config.addTakServer(name, new TakServer(hostname, port));
        try {
            config.writeFile();
            spec.commandLine().getOut().println("Added TAK server " + name + " @ " + hostname + ":" + port);
        } catch (IOException e) {
            spec.commandLine().getErr().println(e.getMessage());
        }
        if (caCert != null) {
            importCaCert();
        }
    }

    private void importCaCert() {
        Path configPath = FileUtil.getConfigDir();
        String truststoreFilename = "truststore.jks";
        Path truststorePath = configPath.resolve(truststoreFilename);
        String truststorePassword = "changeit";

        // Create the truststore if it doesn't exist
        if (!truststorePath.toFile().exists()) {
            try (FileOutputStream fos = new FileOutputStream(truststorePath.toFile())) {
                KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                keyStore.load(null, null);  // Initialize an empty keystore
                keyStore.store(fos, truststorePassword.toCharArray());
                spec.commandLine().getOut().println("Truststore created at: " + truststorePath);
            } catch (Exception e) {
                spec.commandLine().getErr().println("Error creating truststore: " + e.getMessage());
            }
        }

        // Read the truststore
        try (FileInputStream fis = new FileInputStream(truststorePath.toFile())) {
            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            trustStore.load(fis, truststorePassword.toCharArray());

            // Open the cert
            Path caCertPath = Path.of(caCert);
            try (FileInputStream caInputStream = new FileInputStream(caCertPath.toFile())) {
                java.security.cert.Certificate caCertificate = java.security.cert.CertificateFactory.getInstance("X" +
                                ".509")
                        .generateCertificate(caInputStream);

                if (caCertificate instanceof X509Certificate x509Certificate) {
                    String alias = x509Certificate.getSubjectX500Principal().getName();

                    // Check if the truststore already has an entry under the alias
                    if (trustStore.containsAlias(alias)) {
                        spec.commandLine().getOut().println("Truststore has an existing entry for " + alias +
                                ". Use keytool to remove it manually before importing.");
                        return;
                    }
                    trustStore.setCertificateEntry(alias, x509Certificate);

                    // Save the file
                    try (FileOutputStream out = new FileOutputStream(truststorePath.toFile())) {
                        trustStore.store(out, truststorePassword.toCharArray());
                        spec.commandLine().getOut().println("CA certificate imported into truststore: " + alias);
                    }
                }
            }
        } catch (Exception e) {
            spec.commandLine().getErr().println("Error importing CA cert: " + e.getMessage());
        }
    }
}
