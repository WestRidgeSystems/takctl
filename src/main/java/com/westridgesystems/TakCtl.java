package com.westridgesystems;

import com.westridgesystems.commands.*;
import io.quarkus.picocli.runtime.annotations.TopCommand;
import picocli.CommandLine.Command;

@TopCommand
@Command(name = "takctl", mixinStandardHelpOptions = true,
        subcommands = {ConnectCommand.class, CredsCommand.class, ServerCommand.class, StatusCommand.class, UserCommand.class})
public class TakCtl {
}
