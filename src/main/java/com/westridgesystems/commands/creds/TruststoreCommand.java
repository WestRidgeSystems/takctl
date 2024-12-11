package com.westridgesystems.commands.creds;

import com.westridgesystems.util.FileUtil;
import picocli.CommandLine;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.security.KeyStore;

@CommandLine.Command(name = "truststore", mixinStandardHelpOptions = true,
        description = "Manually add a server's CA cert to the truststore.")
public class TruststoreCommand implements Runnable {

    @CommandLine.Parameters(paramLabel = "<ca-cert>",
            description = "Server CA cert to import.")
    String caCertFile;

    @CommandLine.Spec
    CommandLine.Model.CommandSpec spec;

    @Override
    public void run() {
        Path configPath = FileUtil.getConfigDir();

        // Create the truststore if it doesn't exist
        String truststoreFilename = "truststore.jks";
        Path truststorePath = configPath.resolve(truststoreFilename);
        String truststorePassword = "changeit";
        if (!truststorePath.toFile().exists()) {
            try (FileOutputStream fos = new FileOutputStream(truststorePath.toFile())) {
                KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                keyStore.load(null, null);  // Initialize an empty keystore
                keyStore.store(fos, truststorePassword.toCharArray());  // Use a default password "changeit"
                spec.commandLine().getOut().println("Truststore created at: " + truststorePath);
            } catch (Exception e) {
                spec.commandLine().getErr().println("Error creating truststore: " + e.getMessage());
            }
        }

        // Read the truststore
        try (FileInputStream fis = new FileInputStream(truststorePath.toFile())) {
            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            trustStore.load(fis, truststorePassword.toCharArray());

            // Import CA certificate into the truststore
            Path caCertPath = Path.of(caCertFile);
            try (FileInputStream caInputStream = new FileInputStream(caCertPath.toFile())) {
                java.security.cert.Certificate caCertificate = java.security.cert.CertificateFactory.getInstance("X" +
                                ".509")
                        .generateCertificate(caInputStream);
                trustStore.setCertificateEntry("server-alias", caCertificate);

                // Save the updated keystore back to the file
                try (FileOutputStream out = new FileOutputStream(truststorePath.toFile())) {
                    trustStore.store(out, truststorePassword.toCharArray());
                    spec.commandLine().getOut().println("CA certificate imported into truststore with alias: " +
                            "server-alias");
                }
            }
        } catch (Exception e) {
            spec.commandLine().getErr().println("Error importing CA cert: " + e.getMessage());
        }
    }
}
