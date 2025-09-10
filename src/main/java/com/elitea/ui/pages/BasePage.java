package com.elitea.ui.pages;

import com.elitea.core.config.Config;
import com.elitea.core.config.ConfigLoader;
import com.microsoft.playwright.Page;

public abstract class BasePage {
    protected final Page page;
    protected final Config config;

    protected BasePage(Page page) {
        this.page = page;
        this.config = ConfigLoader.load();
    }
}


