package com.westridgesystems.config;

public class TakServer {
    private String hostname;
    private int port;

    public TakServer() {
    }

    public TakServer(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
