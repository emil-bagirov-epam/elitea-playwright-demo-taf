package com.elitea.ui.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
    private final Page page;

    // Locators
    private final String emailInputLocator = "#emailInput input";
    private final String passwordInputLocator = "#passwordInput input";

    public LoginPage(Page page) {
        this.page = page;
    }

    // Actions
    public boolean isEmailFieldVisible() {
        return page.isVisible(emailInputLocator);
    }

    public boolean isPasswordFieldVisible() {
        return page.isVisible(passwordInputLocator);
    }

    public String getEmailFieldPlaceholder() {
        return page.locator(emailInputLocator).getAttribute("placeholder");
    }

    public String getPasswordFieldPlaceholder() {
        return page.locator(passwordInputLocator).getAttribute("placeholder");
    }
}