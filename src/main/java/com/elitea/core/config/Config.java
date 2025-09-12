package com.elitea.core.config;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Config {
    String baseUrl;
    String apiBaseUrl;
    String loginUrl;
    String browser;
    boolean headless;
    int timeoutMs;
    String environment;
}


