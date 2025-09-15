package com.elitea.ui.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

/**
 * Page Object for Login Page
 * Supports test case TC-002: Verify login form input fields are present
 */
public class LoginPage extends BasePage {

    // Locators for login form elements
    private static final String LOGIN_FORM_SELECTOR = "form";
    private static final String EMAIL_INPUT_SELECTOR = "input[type='email'], input[name*='email'], input[id*='email'], input[placeholder*='email']";
    private static final String PASSWORD_INPUT_SELECTOR = "input[type='password'], input[name*='password'], input[id*='password']";
    private static final String EMAIL_LABEL_SELECTOR = "label[for*='email'], label:has-text('Email'), label:has-text('email')";
    private static final String PASSWORD_LABEL_SELECTOR = "label[for*='password'], label:has-text('Password'), label:has-text('password')";

    public LoginPage(Page page) {
        super(page);
    }

    /**
     * Navigate to the login page
     * @param loginUrl the URL of the login page
     * @return LoginPage instance for method chaining
     */
    public LoginPage navigate(String loginUrl) {
        page.navigate(loginUrl);
        return this;
    }

    /**
     * Navigate to the login page using default URL
     * @return LoginPage instance for method chaining
     */
    public LoginPage navigate() {
        // Default login URL - can be configured in properties
        return navigate("https://developer.neonomics.io/auth/login");
    }

    /**
     * Get the login form element
     * @return Locator for the login form
     */
    public Locator getLoginForm() {
        return page.locator(LOGIN_FORM_SELECTOR).first();
    }

    /**
     * Get the email input field
     * @return Locator for the email input field
     */
    public Locator getEmailInput() {
        return page.locator(EMAIL_INPUT_SELECTOR).first();
    }

    /**
     * Get the password input field
     * @return Locator for the password input field
     */
    public Locator getPasswordInput() {
        return page.locator(PASSWORD_INPUT_SELECTOR).first();
    }

    /**
     * Get the email label
     * @return Locator for the email label
     */
    public Locator getEmailLabel() {
        return page.locator(EMAIL_LABEL_SELECTOR).first();
    }

    /**
     * Get the password label
     * @return Locator for the password label
     */
    public Locator getPasswordLabel() {
        return page.locator(PASSWORD_LABEL_SELECTOR).first();
    }

    /**
     * Check if email input field is visible
     * @return true if email input is visible
     */
    public boolean isEmailInputVisible() {
        return getEmailInput().isVisible();
    }

    /**
     * Check if password input field is visible
     * @return true if password input is visible
     */
    public boolean isPasswordInputVisible() {
        return getPasswordInput().isVisible();
    }

    /**
     * Check if email label is visible
     * @return true if email label is visible
     */
    public boolean isEmailLabelVisible() {
        try {
            return getEmailLabel().isVisible();
        } catch (Exception e) {
            return false; // Label might not exist
        }
    }

    /**
     * Check if password label is visible
     * @return true if password label is visible
     */
    public boolean isPasswordLabelVisible() {
        try {
            return getPasswordLabel().isVisible();
        } catch (Exception e) {
            return false; // Label might not exist
        }
    }

    /**
     * Check if both input fields are part of the login form
     * @return true if both fields are within the form
     */
    public boolean areInputFieldsInForm() {
        Locator form = getLoginForm();
        return form.locator(EMAIL_INPUT_SELECTOR).count() > 0 && 
               form.locator(PASSWORD_INPUT_SELECTOR).count() > 0;
    }

    /**
     * Enter email into the email field
     * @param email the email to enter
     * @return LoginPage instance for method chaining
     */
    public LoginPage enterEmail(String email) {
        getEmailInput().fill(email);
        return this;
    }

    /**
     * Enter password into the password field
     * @param password the password to enter
     * @return LoginPage instance for method chaining
     */
    public LoginPage enterPassword(String password) {
        getPasswordInput().fill(password);
        return this;
    }

    /**
     * Enter credentials into both fields
     * @param email the email to enter
     * @param password the password to enter
     * @return LoginPage instance for method chaining
     */
    public LoginPage enterCredentials(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        return this;
    }

    /**
     * Check if email input field is enabled for input
     * @return true if email input is enabled
     */
    public boolean isEmailInputEnabled() {
        return getEmailInput().isEnabled();
    }

    /**
     * Check if password input field is enabled for input
     * @return true if password input is enabled
     */
    public boolean isPasswordInputEnabled() {
        return getPasswordInput().isEnabled();
    }

    /**
     * Get the placeholder text of email input
     * @return placeholder text or empty string if not found
     */
    public String getEmailInputPlaceholder() {
        try {
            return getEmailInput().getAttribute("placeholder");
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * Get the placeholder text of password input
     * @return placeholder text or empty string if not found
     */
    public String getPasswordInputPlaceholder() {
        try {
            return getPasswordInput().getAttribute("placeholder");
        } catch (Exception e) {
            return "";
        }
    }
}
