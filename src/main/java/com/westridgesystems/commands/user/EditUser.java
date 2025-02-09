package com.westridgesystems.commands.user;

import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "edit", mixinStandardHelpOptions = true,
        description = "Update a TAK user's settings.")
public class EditUser implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return 0;
    }
}
