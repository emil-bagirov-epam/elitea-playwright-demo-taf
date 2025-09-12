package com.elitea.ui.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

/**
 * Page Object for the Neonomics Developer Portal Login page
 */
public class LoginPage extends BasePage {
    
    // Locators
    private final Locator emailField;
    private final Locator passwordField;
    private final Locator loginButton;
    private final Locator emailLabel;
    private final Locator passwordLabel;
    private final Locator loginForm;
    private final Locator welcomeTitle;
    private final Locator registerLink;
    private final Locator forgotPasswordLink;
    
    public LoginPage(Page page) {
        super(page);
        this.emailField = page.locator("input[placeholder='Type your e-mail']");
        this.passwordField = page.locator("input[placeholder='Type your password']");
        this.loginButton = page.locator("button:has-text('Log in')");
        // Use specific locators to avoid strict mode violations
        this.emailLabel = page.locator("div:has(input[placeholder='Type your e-mail']) >> text=E-mail").first();
        this.passwordLabel = page.locator("div:has(input[placeholder='Type your password']) >> text=Password").first();
        this.loginForm = page.locator("div").filter(new Locator.FilterOptions().setHas(emailField)).first();
        this.welcomeTitle = page.locator("text=Welcome Back");
        this.registerLink = page.locator("a:has-text('Register')");
        this.forgotPasswordLink = page.locator("text=Forgot password");
    }
    
    /**
     * Navigate to the login page
     */
    public LoginPage navigateToLoginPage() {
        page.navigate("https://developer.neonomics.io/auth/login");
        return this;
    }
    
    /**
     * Check if the email input field is visible
     */
    public boolean isEmailFieldVisible() {
        return emailField.isVisible();
    }
    
    /**
     * Check if the password input field is visible
     */
    public boolean isPasswordFieldVisible() {
        return passwordField.isVisible();
    }
    
    /**
     * Check if the email label is visible
     */
    public boolean isEmailLabelVisible() {
        return emailLabel.isVisible();
    }
    
    /**
     * Check if the password label is visible
     */
    public boolean isPasswordLabelVisible() {
        return passwordLabel.isVisible();
    }
    
    /**
     * Check if the login form is visible
     */
    public boolean isLoginFormVisible() {
        return loginForm.isVisible();
    }
    
    /**
     * Check if the login button is visible
     */
    public boolean isLoginButtonVisible() {
        return loginButton.isVisible();
    }
    
    /**
     * Get the email field placeholder text
     */
    public String getEmailFieldPlaceholder() {
        return emailField.getAttribute("placeholder");
    }
    
    /**
     * Get the password field placeholder text
     */
    public String getPasswordFieldPlaceholder() {
        return passwordField.getAttribute("placeholder");
    }
    
    /**
     * Check if the email field is part of the login form
     */
    public boolean isEmailFieldInForm() {
        return loginForm.locator("input[placeholder='Type your e-mail']").isVisible();
    }
    
    /**
     * Check if the password field is part of the login form
     */
    public boolean isPasswordFieldInForm() {
        return loginForm.locator("input[placeholder='Type your password']").isVisible();
    }
    
    /**
     * Wait for the login page to load completely
     */
    public LoginPage waitForPageLoad() {
        welcomeTitle.waitFor();
        emailField.waitFor();
        passwordField.waitFor();
        return this;
    }
}
