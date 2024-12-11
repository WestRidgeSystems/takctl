package com.westridgesystems.commands.server;

import com.westridgesystems.config.TakCtlConfig;
import com.westridgesystems.config.TakServer;
import jakarta.inject.Inject;
import picocli.CommandLine;

import java.util.Map;

@CommandLine.Command(name = "list", mixinStandardHelpOptions = true,
        description = "List TAK servers.")
public class ListServers implements Runnable {

    @Inject
    TakCtlConfig config;

    @CommandLine.Spec
    CommandLine.Model.CommandSpec spec;

    @Override
    public void run() {
        for (Map.Entry<String, TakServer> entry : config.getTakServers().entrySet()) {
            spec.commandLine().getOut().println("Server Name: " + entry.getKey() + ", Hostname: " + entry.getValue().getHostname() +
                    ", " +
                    "Port: " + entry.getValue().getPort());
        }
    }
}
