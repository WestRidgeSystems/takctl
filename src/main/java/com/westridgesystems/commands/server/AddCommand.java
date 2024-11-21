package com.westridgesystems.commands.server;

import picocli.CommandLine;

@CommandLine.Command(name = "add", mixinStandardHelpOptions = true,
        description = "Add a new TAK server.")
public class AddCommand implements Runnable {
    @Override
    public void run() {

    }
}
