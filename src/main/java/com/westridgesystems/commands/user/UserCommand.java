package com.westridgesystems.commands.user;

import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "user", mixinStandardHelpOptions = true,
        description = "Manage TAK user settings.",
        subcommands = {AddUser.class, EditUser.class, ListUsers.class, RemoveUser.class})
public class UserCommand implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return 0;
    }
}
