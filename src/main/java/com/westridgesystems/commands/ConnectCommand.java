package com.westridgesystems.commands;

import picocli.CommandLine;
import picocli.CommandLine.Parameters;

@CommandLine.Command(name = "connect", mixinStandardHelpOptions = true,
description = "Connect to a TAK server.")
public class ConnectCommand implements Runnable {

    @Parameters(paramLabel = "<server>",
        description = "Server to connect to.")
    String server;

    @Override
    public void run() {
        System.out.printf("Connecting to %s...\n", server);
    }

}
