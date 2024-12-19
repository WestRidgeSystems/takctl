package com.westridgesystems.commands;

import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "user", mixinStandardHelpOptions = true,
        description = "Perform TAK server user management.")
public class UserCommand implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return 0;
    }
}
