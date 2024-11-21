package com.westridgesystems.commands.creds;

import picocli.CommandLine;

@CommandLine.Command(name = "truststore", mixinStandardHelpOptions = true,
        description = "Manually add a server's CA cert to the truststore.")
public class TruststoreCommand implements Runnable {
    @Override
    public void run() {

    }
}
