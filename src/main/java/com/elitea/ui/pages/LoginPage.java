package com.elitea.ui.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage extends BasePage {
    
    // Locators
    private final Locator emailField;
    private final Locator passwordField;
    private final Locator emailLabel;
    private final Locator passwordLabel;
    private final Locator loginForm;
    private final Locator loginButton;
    private final Locator welcomeTitle;
    
    public LoginPage(Page page) {
        super(page);
        this.emailField = page.locator("input[placeholder='Type your e-mail']");
        this.passwordField = page.locator("input[placeholder='Type your password']");
        this.emailLabel = page.locator("text=E-mail");
        this.passwordLabel = page.locator("text=Password");
        this.loginForm = page.locator("form, div").filter(new Locator.FilterOptions().setHas(emailField));
        this.loginButton = page.locator("button:has-text('Log in')");
        this.welcomeTitle = page.locator("text=Welcome Back");
    }
    
    public LoginPage navigate() {
        page.navigate(config.getLoginUrl());
        page.waitForLoadState();
        // Wait for the login form to be visible
        emailField.waitFor();
        return this;
    }
    
    public boolean isEmailFieldVisible() {
        return emailField.isVisible();
    }
    
    public boolean isPasswordFieldVisible() {
        return passwordField.isVisible();
    }
    
    public boolean isEmailLabelVisible() {
        return emailLabel.isVisible();
    }
    
    public boolean isPasswordLabelVisible() {
        return passwordLabel.isVisible();
    }
    
    public boolean isLoginFormVisible() {
        return loginForm.isVisible();
    }
    
    public boolean areInputFieldsPartOfLoginForm() {
        return loginForm.locator("input[placeholder='Type your e-mail']").isVisible() &&
               loginForm.locator("input[placeholder='Type your password']").isVisible();
    }
    
    public String getEmailFieldPlaceholder() {
        return emailField.getAttribute("placeholder");
    }
    
    public String getPasswordFieldPlaceholder() {
        return passwordField.getAttribute("placeholder");
    }
    
    public String getEmailFieldType() {
        return emailField.getAttribute("type");
    }
    
    public String getPasswordFieldType() {
        return passwordField.getAttribute("type");
    }
    
    public boolean isWelcomeTitleVisible() {
        return welcomeTitle.isVisible();
    }
}
