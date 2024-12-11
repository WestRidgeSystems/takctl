package com.westridgesystems.util;

import com.westridgesystems.TakCtl;

import java.io.File;
import java.nio.file.Path;

public class FileUtil {

    /**
     * Get the config file.
     *
     * @return The config file
     */
    public static File getConfigFile() {
        final String configFilename = "config.json";
        return getConfigDir().resolve(configFilename).toFile();
    }

    /**
     * Get the configuration root directory.
     *
     * @return Configuration root directory
     */
    public static Path getConfigDir() {
        String configHome = System.getenv("XDG_CONFIG_HOME");
        if (configHome == null || configHome.isEmpty()) {
            configHome = System.getProperty("user.home") + "/.config";
        }
        File configDir = new File(configHome, TakCtl.APPLICATION_NAME);

        if (!configDir.exists()) {
            try {
                if (configDir.mkdirs()) {
                    System.out.println("Created config directory: " + configDir.getAbsolutePath());
                }
            } catch (SecurityException e) {
                System.out.println("Unable to create config directory: " + configDir.getAbsolutePath());
            }
        }
        return configDir.toPath();
    }
}
