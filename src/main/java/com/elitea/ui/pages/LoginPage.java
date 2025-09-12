package com.elitea.ui.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

/**
 * Page Object for the Login page functionality
 */
public class LoginPage extends BasePage {
    
    // Locators
    private final Locator emailInputField;
    private final Locator passwordInputField;
    private final Locator loginButton;
    private final Locator welcomeBackText;
    private final Locator loginFormContainer;
    
    public LoginPage(Page page) {
        super(page);
        this.emailInputField = page.getByPlaceholder("Type your e-mail");
        this.passwordInputField = page.getByPlaceholder("Type your password");
        this.loginButton = page.getByRole("button", new Page.GetByRoleOptions().setName("Log in"));
        this.welcomeBackText = page.getByText("Welcome Back");
        this.loginFormContainer = page.locator("form, [role='form'], div").filter(new Locator.FilterOptions()
                .setHas(emailInputField).setHas(passwordInputField)).first();
    }
    
    /**
     * Navigate to the login page
     */
    public LoginPage navigateToLoginPage() {
        page.navigate(config.getLoginUrl());
        return this;
    }
    
    /**
     * Check if the email input field is visible
     * @return true if email input field is visible
     */
    public boolean isEmailInputFieldVisible() {
        return emailInputField.isVisible();
    }
    
    /**
     * Check if the password input field is visible
     * @return true if password input field is visible
     */
    public boolean isPasswordInputFieldVisible() {
        return passwordInputField.isVisible();
    }
    
    /**
     * Check if the login form container is visible
     * @return true if login form is visible
     */
    public boolean isLoginFormVisible() {
        return loginFormContainer.isVisible();
    }
    
    /**
     * Get the email input field label text
     * @return label text for email field
     */
    public String getEmailFieldLabel() {
        return page.getByText("E-mail").textContent();
    }
    
    /**
     * Get the password input field label text
     * @return label text for password field
     */
    public String getPasswordFieldLabel() {
        return page.getByText("Password").textContent();
    }
    
    /**
     * Check if email input field is part of the login form
     * @return true if email field is within the form
     */
    public boolean isEmailFieldInForm() {
        return loginFormContainer.locator(emailInputField).isVisible();
    }
    
    /**
     * Check if password input field is part of the login form
     * @return true if password field is within the form
     */
    public boolean isPasswordFieldInForm() {
        return loginFormContainer.locator(passwordInputField).isVisible();
    }
    
    /**
     * Wait for the login page to be fully loaded
     */
    public LoginPage waitForPageLoad() {
        welcomeBackText.waitFor();
        emailInputField.waitFor();
        passwordInputField.waitFor();
        return this;
    }
}
