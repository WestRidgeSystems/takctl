package com.westridgesystems.commands;

import com.westridgesystems.commands.creds.EnrollCommand;
import picocli.CommandLine;

@CommandLine.Command(name = "creds", mixinStandardHelpOptions = true,
        description = "Configure user credentials.",
        subcommands = {EnrollCommand.class})
public class CredsCommand {
}
