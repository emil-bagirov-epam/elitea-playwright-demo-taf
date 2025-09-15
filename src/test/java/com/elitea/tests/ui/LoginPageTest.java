package com.elitea.tests.ui;

import com.elitea.ui.pages.LoginPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test class for Login Page functionality
 * Covers test cases related to login form validation and interaction
 */
public class LoginPageTest extends BaseUiTest {

    @Test
    @DisplayName("SCRUM-87: Verify login form input fields are present")
    void verifyLoginFormInputFieldsArePresent() {
        // Test data - random credentials for testing input functionality
        String testEmail = "test" + UUID.randomUUID().toString().substring(0, 8) + "@example.com";
        String testPassword = "TestPassword" + UUID.randomUUID().toString().substring(0, 6);

        LoginPage loginPage = new LoginPage(page);
        
        // Step 1: Navigate to the login page
        loginPage.navigate();

        // Step 2: Verify presence of input fields
        // Expected Result: Email input field is visible
        assertThat(loginPage.isEmailInputVisible())
                .as("Email input field should be visible")
                .isTrue();

        // Expected Result: Password input field is visible
        assertThat(loginPage.isPasswordInputVisible())
                .as("Password input field should be visible")
                .isTrue();

        // Additional verification: Check labels are present
        assertThat(loginPage.isEmailLabelVisible())
                .as("Email label should be visible")
                .isTrue();

        assertThat(loginPage.isPasswordLabelVisible())
                .as("Password label should be visible")
                .isTrue();

        // Verify label texts
        assertThat(loginPage.getEmailLabelText())
                .as("Email label should have correct text")
                .isEqualTo("E-mail");

        assertThat(loginPage.getPasswordLabelText())
                .as("Password label should have correct text")
                .isEqualTo("Password");

        // Step 3: Verify enter credentials into email/password fields
        // Expected Result: User is able to enter credentials (random)
        loginPage.enterEmail(testEmail);
        assertThat(loginPage.getEmailValue())
                .as("Email should be entered successfully")
                .isEqualTo(testEmail);

        loginPage.enterPassword(testPassword);
        assertThat(loginPage.getPasswordValue())
                .as("Password should be entered successfully")
                .isEqualTo(testPassword);
    }
}