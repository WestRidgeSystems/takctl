package com.westridgesystems.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.westridgesystems.util.FileUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

import java.io.IOException;

@ApplicationScoped
public class TakCtlConfigProducer {
    @Produces
    @ApplicationScoped
    public TakCtlConfig createTakeCtlConfig() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            TakCtlConfig config;
            config = objectMapper.readValue(FileUtil.getConfigFile(), TakCtlConfig.class);
            return config;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
