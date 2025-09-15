package com.elitea.ui.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

/**
 * Page Object for Neonomics Developer Portal Login Page
 * Handles interactions with login form elements
 */
public class LoginPage extends BasePage {

    // Locators
    private final Locator emailInput;
    private final Locator passwordInput;
    private final Locator loginButton;
    private final Locator emailLabel;
    private final Locator passwordLabel;

    public LoginPage(Page page) {
        super(page);
        this.emailInput = page.locator("#emailInput input");
        this.passwordInput = page.locator("#passwordInput input");
        this.loginButton = page.locator("#submitBtn");
        this.emailLabel = page.locator("label[for='email']");
        this.passwordLabel = page.locator("label[for='password']");
    }

    /**
     * Navigate to the login page
     * @return LoginPage instance for method chaining
     */
    public LoginPage navigate() {
        page.navigate(config.getBaseUrl());
        page.waitForLoadState();
        return this;
    }

    /**
     * Check if email input field is visible
     * @return true if email input is visible
     */
    public boolean isEmailInputVisible() {
        return emailInput.isVisible();
    }

    /**
     * Check if password input field is visible
     * @return true if password input is visible
     */
    public boolean isPasswordInputVisible() {
        return passwordInput.isVisible();
    }

    /**
     * Enter email into the email input field
     * @param email email to enter
     * @return LoginPage instance for method chaining
     */
    public LoginPage enterEmail(String email) {
        emailInput.fill(email);
        return this;
    }

    /**
     * Enter password into the password input field
     * @param password password to enter
     * @return LoginPage instance for method chaining
     */
    public LoginPage enterPassword(String password) {
        passwordInput.fill(password);
        return this;
    }

    /**
     * Get the value from email input field
     * @return current value in email field
     */
    public String getEmailValue() {
        return emailInput.inputValue();
    }

    /**
     * Get the value from password input field
     * @return current value in password field
     */
    public String getPasswordValue() {
        return passwordInput.inputValue();
    }

    /**
     * Check if email label is visible
     * @return true if email label is visible
     */
    public boolean isEmailLabelVisible() {
        return emailLabel.isVisible();
    }

    /**
     * Check if password label is visible
     * @return true if password label is visible
     */
    public boolean isPasswordLabelVisible() {
        return passwordLabel.isVisible();
    }

    /**
     * Get email label text
     * @return email label text
     */
    public String getEmailLabelText() {
        return emailLabel.textContent();
    }

    /**
     * Get password label text
     * @return password label text
     */
    public String getPasswordLabelText() {
        return passwordLabel.textContent();
    }
}