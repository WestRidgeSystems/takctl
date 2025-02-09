package com.westridgesystems.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.westridgesystems.util.FileUtil;

import java.io.IOException;
import java.util.Map;

public class TakCtlConfig {
    private final Map<String, TakServer> takServers = new java.util.TreeMap<>();
    private final Map<String, TakUser> takUsers = new java.util.TreeMap<>();

    TakCtlConfig() {
    }

    public void addTakServer(String name, TakServer takServer) {
        takServers.put(name, takServer);
    }

    public boolean removeTakServer(String name) {
        return takServers.remove(name) != null;
    }

    public TakServer getTakServer(String name) {
        return takServers.get(name);
    }

    public Map<String, TakServer> getTakServers() {
        return takServers;
    }

    public void setTakServers(Map<String, TakServer> takServers) {
        this.takServers.clear();
        this.takServers.putAll(takServers);
    }

    public void writeFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(FileUtil.getConfigFile(), this);
    }
}
