package com.westridgesystems.commands.server;

import com.westridgesystems.config.TakCtlConfig;
import com.westridgesystems.config.TakServer;
import jakarta.inject.Inject;
import picocli.CommandLine;

import java.io.IOException;

@CommandLine.Command(name = "add", mixinStandardHelpOptions = true,
        description = "Add a new TAK server.")
public class AddServer implements Runnable {

    @CommandLine.Option(names = {"-n", "--name"}, required = true, description = "Server name.")
    private String name;

    @CommandLine.Option(names = {"-h", "--hostname"}, required = true, description = "Host name or IP.")
    private String hostname;

    @CommandLine.Option(names = {"-p", "--port"}, defaultValue = "8089", description = "Port of API server.")
    private int port;

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
    }
}
