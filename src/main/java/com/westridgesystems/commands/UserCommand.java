package com.westridgesystems.commands;

import picocli.CommandLine;

@CommandLine.Command(name = "user", mixinStandardHelpOptions = true,
        description = "Perform TAK server user management.")
public class UserCommand implements Runnable {
    @Override
    public void run() {

    }
}
