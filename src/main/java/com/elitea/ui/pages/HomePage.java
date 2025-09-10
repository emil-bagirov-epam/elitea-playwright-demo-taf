package com.elitea.ui.pages;

import com.microsoft.playwright.Page;

public class HomePage extends BasePage {

    public HomePage(Page page) {
        super(page);
    }

    public HomePage navigate() {
        page.navigate(config.getBaseUrl());
        return this;
    }

    public String getTitle() {
        return page.title();
    }
}


