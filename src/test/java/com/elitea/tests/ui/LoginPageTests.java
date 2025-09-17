package com.elitea.tests.ui;

import com.elitea.ui.pages.LoginPage;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginPageTests extends BaseUiTest {

    @Test
    public void test_verify_login_page_input_fields_visibility() {
        // Navigate to the login page
        Page page = getPage();
        page.navigate("https://developer.neonomics.io/auth/login");

        // Initialize LoginPage object
        LoginPage loginPage = new LoginPage(page);

        // Verify email field visibility
        assertTrue(loginPage.isEmailFieldVisible(), "Email input field is not visible.");

        // Verify password field visibility
        assertTrue(loginPage.isPasswordFieldVisible(), "Password input field is not visible.");

        // Verify email field placeholder
        assertEquals("Type your e-mail", loginPage.getEmailFieldPlaceholder(), "Email placeholder is incorrect.");

        // Verify password field placeholder
        assertEquals("Type your password", loginPage.getPasswordFieldPlaceholder(), "Password placeholder is incorrect.");
    }
}