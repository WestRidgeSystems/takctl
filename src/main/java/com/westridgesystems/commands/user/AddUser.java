package com.westridgesystems.commands.user;

import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "add", mixinStandardHelpOptions = true,
        description = "Add a new TAK user.")
public class AddUser implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return 0;
    }
}
