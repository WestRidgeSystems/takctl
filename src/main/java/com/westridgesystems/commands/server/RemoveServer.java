package com.westridgesystems.commands.server;

import com.westridgesystems.config.TakCtlConfig;
import jakarta.inject.Inject;
import picocli.CommandLine;

import java.io.IOException;

@CommandLine.Command(name = "remove", mixinStandardHelpOptions = true,
        description = "Remove a TAK server.")
public class RemoveServer implements Runnable {

    @CommandLine.Option(names = {"-n", "--name"}, required = true, description = "Server name.")
    private String name;

    @Inject
    TakCtlConfig config;

    @CommandLine.Spec
    CommandLine.Model.CommandSpec spec;

    @Override
    public void run() {
        if (config.removeTakServer(name)) {
            try {
                config.writeFile();
                spec.commandLine().getOut().println("Removed server: " + name);
            } catch (IOException e) {
                spec.commandLine().getErr().println(e.getMessage());
            }
        } else {
            spec.commandLine().getOut().println("No such server: " + name);
        }
    }
}
