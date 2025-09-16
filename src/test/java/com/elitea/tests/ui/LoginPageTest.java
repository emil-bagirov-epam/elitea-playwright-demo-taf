package com.elitea.tests.ui;

import com.elitea.ui.pages.LoginPage;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginPageTest extends BaseUiTest {

    @Test
    public void testLoginFormFields() {
        // Navigate to login page
        Page page = PlaywrightManager.getPage();
        page.navigate(config.getProperty("loginPageUrl"));

        // Initialize LoginPage object
        LoginPage loginPage = new LoginPage(page);

        // Verify email field
        assertTrue(loginPage.isEmailFieldVisible(), "Email field is not visible");
        assertEquals("Enter your email", loginPage.getEmailFieldPlaceholder(), "Email field placeholder is incorrect");

        // Verify password field
        assertTrue(loginPage.isPasswordFieldVisible(), "Password field is not visible");
        assertEquals("Enter your password", loginPage.getPasswordFieldPlaceholder(), "Password field placeholder is incorrect");
    }
}