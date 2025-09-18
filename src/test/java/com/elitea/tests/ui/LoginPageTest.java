package com.elitea.tests.ui;

import com.elitea.ui.pages.LoginPage;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test class for Login Page functionality.
 * Tests user interactions with email and password input fields.
 */
public class LoginPageTest extends BaseUiTest {

    @Test
    @Description("SCRUM-166: Verify user can enter credentials into email and password fields")
    void shouldAllowUserToEnterCredentialsIntoEmailAndPasswordFields() {
        // Test data
        String testEmail = "test.user@example.com";
        String testPassword = "SecurePassword123!";

        // Given: User is on the login page
        LoginPage loginPage = new LoginPage(page);
        loginPage.navigate();

        // Verify page is loaded correctly
        assertThat(loginPage.getPageTitle())
                .isEqualTo("Welcome Back");

        // Verify email and password fields are visible and enabled
        assertThat(loginPage.isEmailFieldVisible())
                .as("Email field should be visible and enabled")
                .isTrue();
        
        assertThat(loginPage.isPasswordFieldVisible())
                .as("Password field should be visible and enabled")
                .isTrue();

        // When: User enters valid email into the email input field
        loginPage.enterEmail(testEmail);

        // Then: Email should be successfully entered
        assertThat(loginPage.getEmailValue())
                .as("Email field should contain the entered email")
                .isEqualTo(testEmail);

        // When: User enters valid password into the password input field
        loginPage.enterPassword(testPassword);

        // Then: Password should be successfully entered
        assertThat(loginPage.getPasswordValue())
                .as("Password field should contain the entered password")
                .isEqualTo(testPassword);

        // Verify both fields retain their values
        assertThat(loginPage.getEmailValue())
                .as("Email field should still contain the email after password entry")
                .isEqualTo(testEmail);

        // Verify placeholders are correct
        loginPage.clearEmail().clearPassword();
        
        assertThat(loginPage.getEmailPlaceholder())
                .as("Email field should have correct placeholder")
                .isEqualTo("Type your e-mail");
        
        assertThat(loginPage.getPasswordPlaceholder())
                .as("Password field should have correct placeholder")
                .isEqualTo("Type your password");
    }

    @Test
    @Description("SCRUM-166: Verify email field accepts various valid email formats")
    void shouldAcceptVariousValidEmailFormats() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.navigate();

        String[] validEmails = {
                "user@example.com",
                "test.email@domain.co.uk",
                "user+tag@example.org",
                "firstname.lastname@company.com"
        };

        for (String email : validEmails) {
            loginPage.clearEmail().enterEmail(email);
            
            assertThat(loginPage.getEmailValue())
                    .as("Email field should accept valid email format: " + email)
                    .isEqualTo(email);
        }
    }

    @Test
    @Description("SCRUM-166: Verify password field accepts various password formats")
    void shouldAcceptVariousPasswordFormats() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.navigate();

        String[] validPasswords = {
                "SimplePassword123",
                "Complex!Password@2024",
                "P@ssw0rd#WithSpecialChars",
                "VeryLongPasswordWithManyCharacters123!"
        };

        for (String password : validPasswords) {
            loginPage.clearPassword().enterPassword(password);
            
            assertThat(loginPage.getPasswordValue())
                    .as("Password field should accept password: " + password)
                    .isEqualTo(password);
        }
    }

    @Test
    @Description("SCRUM-166: Verify fields can be cleared and re-entered")
    void shouldAllowClearingAndReEnteringCredentials() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.navigate();

        String initialEmail = "initial@example.com";
        String initialPassword = "InitialPassword123";
        String newEmail = "new@example.com";
        String newPassword = "NewPassword456";

        // Enter initial credentials
        loginPage.enterEmail(initialEmail).enterPassword(initialPassword);

        // Verify initial values
        assertThat(loginPage.getEmailValue()).isEqualTo(initialEmail);
        assertThat(loginPage.getPasswordValue()).isEqualTo(initialPassword);

        // Clear and enter new credentials
        loginPage.clearEmail().clearPassword()
                .enterEmail(newEmail).enterPassword(newPassword);

        // Verify new values
        assertThat(loginPage.getEmailValue())
                .as("Email field should contain new email after clearing and re-entering")
                .isEqualTo(newEmail);
        
        assertThat(loginPage.getPasswordValue())
                .as("Password field should contain new password after clearing and re-entering")
                .isEqualTo(newPassword);
    }
}