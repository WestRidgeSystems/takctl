package com.westridgesystems.commands.server;

import picocli.CommandLine;

@CommandLine.Command(name = "remove", mixinStandardHelpOptions = true,
        description = "Remove a TAK server.")
public class RemoveCommand implements Runnable {
    @Override
    public void run() {

    }
}
