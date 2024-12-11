package com.westridgesystems.commands.server;

import picocli.CommandLine;

@CommandLine.Command(name = "edit", mixinStandardHelpOptions = true,
        description = "Update a TAK server's info.")
public class EditServer implements Runnable {
    @Override
    public void run() {
    }
}
