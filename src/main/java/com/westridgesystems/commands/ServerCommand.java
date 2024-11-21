package com.westridgesystems.commands;

import com.westridgesystems.commands.server.AddCommand;
import com.westridgesystems.commands.server.EditCommand;
import com.westridgesystems.commands.server.RemoveCommand;
import picocli.CommandLine;

@CommandLine.Command(name = "server", mixinStandardHelpOptions = true,
        description = "Manage TAK server connections.",
        subcommands = {AddCommand.class, EditCommand.class, RemoveCommand.class})
public class ServerCommand {
}
