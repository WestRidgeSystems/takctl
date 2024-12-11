package com.westridgesystems.commands;

import picocli.CommandLine;

@CommandLine.Command(name = "status", mixinStandardHelpOptions = true,
        description = "Display status information.")
public class StatusCommand implements Runnable {
    @Override
    public void run() {

    }
}
