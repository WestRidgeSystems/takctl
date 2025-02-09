package com.westridgesystems;

import com.westridgesystems.commands.ConnectCommand;
import com.westridgesystems.commands.CredsCommand;
import com.westridgesystems.commands.StatusCommand;
import com.westridgesystems.commands.server.ServerCommand;
import com.westridgesystems.commands.user.UserCommand;
import io.quarkus.picocli.runtime.annotations.TopCommand;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import picocli.CommandLine;

@QuarkusMain
@TopCommand
@CommandLine.Command(name = "takctl", mixinStandardHelpOptions = true,
        subcommands = {ConnectCommand.class, CredsCommand.class, ServerCommand.class, StatusCommand.class,
                UserCommand.class})
public class TakCtl implements QuarkusApplication {

    public static String APPLICATION_NAME = "takctl";

    @Inject
    CommandLine.IFactory factory;

    @Override
    public int run(String... args) throws Exception {
        return new CommandLine(this, factory).
                execute(args);
    }
}
