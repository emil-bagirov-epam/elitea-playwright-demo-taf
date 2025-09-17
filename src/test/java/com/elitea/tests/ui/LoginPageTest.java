package com.elitea.tests.ui;

import com.elitea.ui.pages.LoginPage;
import io.qameta.allure.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Login page functionality
 */
public class LoginPageTest extends BaseUiTest {

    private LoginPage loginPage;

    @BeforeEach
    void setUp() {
        loginPage = new LoginPage(page, config);
    }

    @Test
    @Description("SCRUM-114: Verify login form includes email and password fields with correct placeholders")
    void verifyLoginFormIncludesEmailAndPasswordFields() {
        // Navigate to login page
        loginPage.navigateToLoginPage()
                .waitForPageLoad();

        // Verify email input field is present and visible
        assertTrue(loginPage.isEmailInputVisible(), 
            "Email input field should be visible on the login page");

        // Verify password input field is present and visible
        assertTrue(loginPage.isPasswordInputVisible(), 
            "Password input field should be visible on the login page");

        // Verify email field has correct placeholder
        String emailPlaceholder = loginPage.getEmailInputPlaceholder();
        assertEquals("Type your e-mail", emailPlaceholder, 
            "Email input field should have placeholder 'Type your e-mail'");

        // Verify password field has correct placeholder
        String passwordPlaceholder = loginPage.getPasswordInputPlaceholder();
        assertEquals("Type your password", passwordPlaceholder, 
            "Password input field should have placeholder 'Type your password'");

        // Verify email field has correct label
        String emailLabel = loginPage.getEmailLabelText();
        assertEquals("E-mail", emailLabel, 
            "Email field should have label 'E-mail'");

        // Verify password field has correct label
        String passwordLabel = loginPage.getPasswordLabelText();
        assertEquals("Password", passwordLabel, 
            "Password field should have label 'Password'");

        // Verify login button is present and visible
        assertTrue(loginPage.isLoginButtonVisible(), 
            "Login button should be visible on the login page");

        // Verify login button has correct text
        String loginButtonText = loginPage.getLoginButtonText();
        assertEquals("Log in", loginButtonText, 
            "Login button should have text 'Log in'");
    }
}