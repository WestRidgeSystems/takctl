package com.westridgesystems.commands.creds;

import picocli.CommandLine;

@CommandLine.Command(name = "enroll", mixinStandardHelpOptions = true,
        description = "Request client certificate for an existing user.")
public class EnrollCommand implements Runnable {

    @CommandLine.Spec
    CommandLine.Model.CommandSpec spec;

    @Override
    public void run() {
        spec.commandLine().getOut().println("Enrolling user...");
    }
}
