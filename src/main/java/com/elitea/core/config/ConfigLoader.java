package com.elitea.core.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConfigLoader {
    private static final String DEFAULT_ENV = "local";
    private static volatile Config cachedConfig;

    private ConfigLoader() { }

    public static Config load() {
        if (cachedConfig == null) {
            synchronized (ConfigLoader.class) {
                if (cachedConfig == null) {
                    cachedConfig = loadInternal();
                }
            }
        }
        return cachedConfig;
    }

    private static Config loadInternal() {
        String env = System.getProperty("env", System.getenv().getOrDefault("ENV", DEFAULT_ENV));
        Properties defaults = readProps("config/common.properties");
        Properties envProps = readProps("config/" + env + ".properties");

        Properties merged = new Properties();
        if (defaults != null) {
            merged.putAll(defaults);
        }
        if (envProps != null) {
            merged.putAll(envProps);
        }

        String baseUrl = merged.getProperty("baseUrl", "http://localhost:3000");
        String apiBaseUrl = merged.getProperty("apiBaseUrl", baseUrl);
        String loginUrl = merged.getProperty("loginUrl", baseUrl + "/login");
        String browser = merged.getProperty("browser", "chromium");
        boolean headless = Boolean.parseBoolean(merged.getProperty("headless", "true"));
        int timeoutMs = Integer.parseInt(merged.getProperty("timeoutMs", "30000"));

        return Config.builder()
                .baseUrl(baseUrl)
                .apiBaseUrl(apiBaseUrl)
                .loginUrl(loginUrl)
                .browser(browser)
                .headless(headless)
                .timeoutMs(timeoutMs)
                .environment(env)
                .build();
    }

    private static Properties readProps(String path) {
        try (InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(path)) {
            if (in == null) {
                return null;
            }
            Properties p = new Properties();
            p.load(in);
            return p;
        } catch (IOException e) {
            throw new RuntimeException("Failed to read properties: " + path, e);
        }
    }
}


