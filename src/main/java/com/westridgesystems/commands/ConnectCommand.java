package com.westridgesystems.commands;

import picocli.CommandLine;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "connect", mixinStandardHelpOptions = true,
        description = "Connect to a TAK server.")
public class ConnectCommand implements Callable<Integer> {

    @Parameters(paramLabel = "<server>",
            description = "Server to connect to.")
    String server;

    @CommandLine.Spec
    CommandLine.Model.CommandSpec spec;

    @Override
    public Integer call() throws Exception {
        spec.commandLine().getOut().println("Connecting to " + server + "...");
        return 0;
    }

}
