package com.westridgesystems.commands.server;

import picocli.CommandLine;

@CommandLine.Command(name = "server", mixinStandardHelpOptions = true,
        description = "Manage TAK server settings.",
        subcommands = {AddServer.class, EditServer.class, ListServers.class, RemoveServer.class})
public class ServerCommand {
}
