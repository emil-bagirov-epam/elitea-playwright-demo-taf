package com.elitea.ui.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

/**
 * Page Object for the Neonomics Developer Portal Login page.
 * Handles interactions with email and password input fields.
 */
public class LoginPage extends BasePage {

    // Locators
    private static final String EMAIL_INPUT = "#emailInput input";
    private static final String PASSWORD_INPUT = "#passwordInput input";
    private static final String LOGIN_BUTTON = "#submitBtn";
    private static final String EMAIL_LABEL = "label[for='email']";
    private static final String PASSWORD_LABEL = "label[for='password']";
    private static final String PAGE_TITLE = ".title__main";

    public LoginPage(Page page) {
        super(page);
    }

    /**
     * Navigates to the login page.
     * @return LoginPage instance for method chaining
     */
    public LoginPage navigate() {
        page.navigate(config.getBaseUrl() + "/auth/login");
        waitForPageLoad();
        return this;
    }

    /**
     * Waits for the login page to fully load.
     */
    private void waitForPageLoad() {
        page.waitForSelector(PAGE_TITLE, new Page.WaitForSelectorOptions()
                .setState(WaitForSelectorState.VISIBLE));
        page.waitForSelector(EMAIL_INPUT, new Page.WaitForSelectorOptions()
                .setState(WaitForSelectorState.VISIBLE));
        page.waitForSelector(PASSWORD_INPUT, new Page.WaitForSelectorOptions()
                .setState(WaitForSelectorState.VISIBLE));
    }

    /**
     * Enters email into the email input field.
     * @param email Email address to enter
     * @return LoginPage instance for method chaining
     */
    public LoginPage enterEmail(String email) {
        page.waitForSelector(EMAIL_INPUT, new Page.WaitForSelectorOptions()
                .setState(WaitForSelectorState.VISIBLE));
        page.fill(EMAIL_INPUT, email);
        return this;
    }

    /**
     * Enters password into the password input field.
     * @param password Password to enter
     * @return LoginPage instance for method chaining
     */
    public LoginPage enterPassword(String password) {
        page.waitForSelector(PASSWORD_INPUT, new Page.WaitForSelectorOptions()
                .setState(WaitForSelectorState.VISIBLE));
        page.fill(PASSWORD_INPUT, password);
        return this;
    }

    /**
     * Gets the current value of the email input field.
     * @return Current email field value
     */
    public String getEmailValue() {
        return page.inputValue(EMAIL_INPUT);
    }

    /**
     * Gets the current value of the password input field.
     * @return Current password field value
     */
    public String getPasswordValue() {
        return page.inputValue(PASSWORD_INPUT);
    }

    /**
     * Checks if the email input field is visible and enabled.
     * @return true if email field is visible and enabled
     */
    public boolean isEmailFieldVisible() {
        return page.isVisible(EMAIL_INPUT) && page.isEnabled(EMAIL_INPUT);
    }

    /**
     * Checks if the password input field is visible and enabled.
     * @return true if password field is visible and enabled
     */
    public boolean isPasswordFieldVisible() {
        return page.isVisible(PASSWORD_INPUT) && page.isEnabled(PASSWORD_INPUT);
    }

    /**
     * Gets the placeholder text of the email input field.
     * @return Email field placeholder text
     */
    public String getEmailPlaceholder() {
        return page.getAttribute(EMAIL_INPUT, "placeholder");
    }

    /**
     * Gets the placeholder text of the password input field.
     * @return Password field placeholder text
     */
    public String getPasswordPlaceholder() {
        return page.getAttribute(PASSWORD_INPUT, "placeholder");
    }

    /**
     * Checks if the login button is enabled.
     * @return true if login button is enabled
     */
    public boolean isLoginButtonEnabled() {
        return page.isEnabled(LOGIN_BUTTON);
    }

    /**
     * Clears the email input field.
     * @return LoginPage instance for method chaining
     */
    public LoginPage clearEmail() {
        page.fill(EMAIL_INPUT, "");
        return this;
    }

    /**
     * Clears the password input field.
     * @return LoginPage instance for method chaining
     */
    public LoginPage clearPassword() {
        page.fill(PASSWORD_INPUT, "");
        return this;
    }

    /**
     * Gets the page title text.
     * @return Page title text
     */
    public String getPageTitle() {
        return page.textContent(PAGE_TITLE);
    }
}