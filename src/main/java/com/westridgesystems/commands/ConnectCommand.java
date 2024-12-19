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

    @Override
    public Integer call() throws Exception {
        System.out.printf("Connecting to %s...\n", server);
        return 0;
    }

}
