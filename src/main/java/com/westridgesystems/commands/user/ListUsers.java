package com.westridgesystems.commands.user;

import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "list", mixinStandardHelpOptions = true,
        description = "List TAK users.")
public class ListUsers implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return 0;
    }
}
