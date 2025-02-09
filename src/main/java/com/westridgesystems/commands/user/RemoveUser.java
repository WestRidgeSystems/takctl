package com.westridgesystems.commands.user;

import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "remove", mixinStandardHelpOptions = true,
        description = "Remove a TAK user.")
public class RemoveUser implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return 0;
    }
}
