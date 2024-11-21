package com.westridgesystems.commands.creds;

import picocli.CommandLine;

@CommandLine.Command(name = "enroll", mixinStandardHelpOptions = true,
        description = "Request client certificate for an existing user.")
public class EnrollCommand implements Runnable {
    @Override
    public void run() {
        System.out.println("Enrolling user...");
    }
}
