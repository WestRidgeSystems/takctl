package com.westridgesystems.commands;

import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "status", mixinStandardHelpOptions = true,
        description = "Display status information.")
public class StatusCommand implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return 0;
    }
}
