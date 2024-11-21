package com.westridgesystems.commands;

import com.westridgesystems.commands.creds.EnrollCommand;
import com.westridgesystems.commands.creds.TruststoreCommand;
import picocli.CommandLine;

@CommandLine.Command(name = "creds", mixinStandardHelpOptions = true,
        description = "Configure user credentials.",
        subcommands = { EnrollCommand.class, TruststoreCommand.class})
public class CredsCommand {
}
