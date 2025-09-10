package com.elitea.tests.ui;

import com.elitea.core.config.Config;
import com.elitea.core.config.ConfigLoader;
import com.elitea.core.playwright.PlaywrightManager;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseUiTest {
    protected Config config;
    protected Page page;

    @BeforeEach
    void setUp() {
        config = ConfigLoader.load();
        page = PlaywrightManager.getPage();
    }

    @AfterEach
    void tearDown() {
        PlaywrightManager.cleanup();
    }
}


