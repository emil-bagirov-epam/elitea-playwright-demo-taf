package com.elitea.ui.pages;

import com.elitea.core.config.Config;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

/**
 * Page Object for the Login page functionality
 */
public class LoginPage extends BasePage {

    // Locators
    private final Locator emailInput;
    private final Locator passwordInput;
    private final Locator emailLabel;
    private final Locator passwordLabel;
    private final Locator loginButton;
    private final Locator pageTitle;
    private final Locator pageSubtitle;

    public LoginPage(Page page) {
        super(page);
        this.emailInput = page.locator("#emailInput input");
        this.passwordInput = page.locator("#passwordInput input");
        this.emailLabel = page.locator("label[for='email']");
        this.passwordLabel = page.locator("label[for='password']");
        this.loginButton = page.locator("#submitBtn");
        this.pageTitle = page.locator(".title__main");
        this.pageSubtitle = page.locator(".title__subtitle");
    }

    /**
     * Navigate to the login page
     */
    public LoginPage navigateToLoginPage() {
        page.navigate(config.getLoginUrl());
        return this;
    }

    /**
     * Check if email input field is visible
     */
    public boolean isEmailInputVisible() {
        return emailInput.isVisible();
    }

    /**
     * Check if password input field is visible
     */
    public boolean isPasswordInputVisible() {
        return passwordInput.isVisible();
    }

    /**
     * Get email input placeholder text
     */
    public String getEmailInputPlaceholder() {
        return emailInput.getAttribute("placeholder");
    }

    /**
     * Get password input placeholder text
     */
    public String getPasswordInputPlaceholder() {
        return passwordInput.getAttribute("placeholder");
    }

    /**
     * Get email label text
     */
    public String getEmailLabelText() {
        return emailLabel.textContent();
    }

    /**
     * Get password label text
     */
    public String getPasswordLabelText() {
        return passwordLabel.textContent();
    }

    /**
     * Check if login button is visible
     */
    public boolean isLoginButtonVisible() {
        return loginButton.isVisible();
    }

    /**
     * Get login button text
     */
    public String getLoginButtonText() {
        return loginButton.textContent().trim();
    }

    /**
     * Wait for login page to load completely
     */
    public LoginPage waitForPageLoad() {
        pageTitle.waitFor();
        emailInput.waitFor();
        passwordInput.waitFor();
        loginButton.waitFor();
        return this;
    }

    /**
     * Enter text into email field
     */
    public LoginPage enterEmail(String email) {
        emailInput.fill(email);
        return this;
    }

    /**
     * Enter text into password field
     */
    public LoginPage enterPassword(String password) {
        passwordInput.fill(password);
        return this;
    }
}