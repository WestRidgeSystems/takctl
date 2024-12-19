package com.westridgesystems.commands.server;

import com.westridgesystems.config.TakCtlConfig;
import jakarta.inject.Inject;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "remove", mixinStandardHelpOptions = true,
        description = "Remove a TAK server.")
public class RemoveServer implements Callable<Integer> {

    @CommandLine.Option(names = {"-n", "--name"}, required = true, description = "Server name.")
    private String name;

    @Inject
    TakCtlConfig config;

    @CommandLine.Spec
    CommandLine.Model.CommandSpec spec;

    @Override
    public Integer call() throws Exception {
        if (config.removeTakServer(name)) {
            config.writeFile();
            spec.commandLine().getOut().println("Removed server: " + name);
        } else {
            throw new IllegalArgumentException("No such server: " + name);
        }
        return 0;
    }
}
