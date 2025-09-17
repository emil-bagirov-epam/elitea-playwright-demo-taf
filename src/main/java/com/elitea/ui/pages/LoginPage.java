package com.elitea.ui.pages;

import com.microsoft.playwright.Page;

public class LoginPage extends BasePage {

    public LoginPage(Page page) {
        super(page);
    }

    public void navigateToLoginPage() {
        page.navigate(config.getBaseUrl() + "/auth/login");
    }

    public boolean isEmailInputFieldPresent() {
        return page.isVisible("input[placeholder='Type your e-mail']");
    }

    public boolean isPasswordInputFieldPresent() {
        return page.isVisible("input[placeholder='Type your password']");
    }
}