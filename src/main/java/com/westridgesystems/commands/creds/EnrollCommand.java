package com.westridgesystems.commands.creds;

import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "enroll", mixinStandardHelpOptions = true,
        description = "Request client certificate for an existing user.")
public class EnrollCommand implements Callable<Integer> {

    @CommandLine.Spec
    CommandLine.Model.CommandSpec spec;

    @Override
    public Integer call() throws Exception {
        spec.commandLine().getOut().println("Enrolling user...");
        return 0;
    }
}
