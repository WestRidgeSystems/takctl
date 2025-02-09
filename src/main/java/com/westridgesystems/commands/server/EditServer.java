package com.westridgesystems.commands.server;

import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "edit", mixinStandardHelpOptions = true,
        description = "Update a TAK server's settings.")
public class EditServer implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return 0;
    }
}
