package com.elitea.ui.pages;

import com.microsoft.playwright.Page;

public class LoginPage extends BasePage {

    public LoginPage(Page page) {
        super(page);
    }

    public boolean isEmailInputPresent() {
        return page.isVisible("input[placeholder='Type your e-mail']");
    }

    public boolean isPasswordInputPresent() {
        return page.isVisible("input[placeholder='Type your password']");
    }
}