package com.elitea.ui.pages;

import com.microsoft.playwright.Page;

public class LoginPage {

    private final Page page;

    // Locators
    private final String emailField = "input[placeholder='Enter your email']";
    private final String passwordField = "input[placeholder='Enter your password']";

    public LoginPage(Page page) {
        this.page = page;
    }

    // Actions
    public boolean isEmailFieldVisible() {
        return page.isVisible(emailField);
    }

    public boolean isPasswordFieldVisible() {
        return page.isVisible(passwordField);
    }

    public String getEmailFieldPlaceholder() {
        return page.getAttribute(emailField, "placeholder");
    }

    public String getPasswordFieldPlaceholder() {
        return page.getAttribute(passwordField, "placeholder");
    }
}