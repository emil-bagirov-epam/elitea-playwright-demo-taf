package com.elitea.tests.ui;

import com.elitea.ui.pages.LoginPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test class for Login Page functionality
 * Covers SCRUM-87: TC-002 - Verify login form input fields are present
 */
@DisplayName("Login Page Tests")
public class LoginPageTest extends BaseUiTest {

    private static final String LOGIN_URL = "https://developer.neonomics.io/auth/login";
    private static final String TEST_EMAIL = "test.user@example.com";
    private static final String TEST_PASSWORD = "TestPassword123!";

    /**
     * TC-002: Verify login form input fields are present
     * 
     * Test Steps:
     * 1. Navigate to the login page
     * 2. Locate the login form
     * 3. Verify presence of input fields
     * 4. Verify enter credentials into email/password fields
     * 
     * Expected Results:
     * - Email input field is visible and labeled
     * - Password input field is visible and labeled
     * - Both fields are part of the login form
     * - User is able to enter credentials (random)
     */
    @Test
    @DisplayName("TC-002: Verify login form input fields are present")
    void verifyLoginFormInputFieldsArePresent() {
        // Arrange
        LoginPage loginPage = new LoginPage(page);

        // Act - Step 1: Navigate to the login page
        loginPage.navigate(LOGIN_URL);

        // Assert - Step 2: Locate the login form
        assertThat(loginPage.getLoginForm().isVisible())
                .as("Login form should be visible on the page")
                .isTrue();

        // Assert - Step 3: Verify presence of input fields
        assertThat(loginPage.isEmailInputVisible())
                .as("Email input field should be visible")
                .isTrue();

        assertThat(loginPage.isPasswordInputVisible())
                .as("Password input field should be visible")
                .isTrue();

        // Verify fields are part of the login form
        assertThat(loginPage.areInputFieldsInForm())
                .as("Both email and password fields should be part of the login form")
                .isTrue();

        // Verify fields are enabled for input
        assertThat(loginPage.isEmailInputEnabled())
                .as("Email input field should be enabled for user input")
                .isTrue();

        assertThat(loginPage.isPasswordInputEnabled())
                .as("Password input field should be enabled for user input")
                .isTrue();

        // Act & Assert - Step 4: Verify user can enter credentials
        loginPage.enterCredentials(TEST_EMAIL, TEST_PASSWORD);

        // Verify that credentials were entered successfully
        assertThat(loginPage.getEmailInput().inputValue())
                .as("Email should be entered in the email field")
                .isEqualTo(TEST_EMAIL);

        assertThat(loginPage.getPasswordInput().inputValue())
                .as("Password should be entered in the password field")
                .isEqualTo(TEST_PASSWORD);
    }

    /**
     * Additional test: Verify email input field properties
     */
    @Test
    @DisplayName("Verify email input field properties")
    void verifyEmailInputFieldProperties() {
        // Arrange
        LoginPage loginPage = new LoginPage(page);

        // Act
        loginPage.navigate(LOGIN_URL);

        // Assert
        assertThat(loginPage.getEmailInput().getAttribute("type"))
                .as("Email input should have type 'email' or be identifiable as email field")
                .containsIgnoringCase("email");

        // Verify email field can accept email format
        loginPage.enterEmail(TEST_EMAIL);
        assertThat(loginPage.getEmailInput().inputValue())
                .as("Email field should accept email input")
                .isEqualTo(TEST_EMAIL);
    }

    /**
     * Additional test: Verify password input field properties
     */
    @Test
    @DisplayName("Verify password input field properties")
    void verifyPasswordInputFieldProperties() {
        // Arrange
        LoginPage loginPage = new LoginPage(page);

        // Act
        loginPage.navigate(LOGIN_URL);

        // Assert
        assertThat(loginPage.getPasswordInput().getAttribute("type"))
                .as("Password input should have type 'password'")
                .isEqualTo("password");

        // Verify password field can accept password input
        loginPage.enterPassword(TEST_PASSWORD);
        assertThat(loginPage.getPasswordInput().inputValue())
                .as("Password field should accept password input")
                .isEqualTo(TEST_PASSWORD);
    }

    /**
     * Additional test: Verify form structure and accessibility
     */
    @Test
    @DisplayName("Verify login form structure and accessibility")
    void verifyLoginFormStructureAndAccessibility() {
        // Arrange
        LoginPage loginPage = new LoginPage(page);

        // Act
        loginPage.navigate(LOGIN_URL);

        // Assert form structure
        assertThat(loginPage.getLoginForm().count())
                .as("There should be at least one form on the login page")
                .isGreaterThan(0);

        // Verify input fields have proper attributes for accessibility
        assertThat(loginPage.getEmailInput().count())
                .as("Email input field should be present")
                .isGreaterThan(0);

        assertThat(loginPage.getPasswordInput().count())
                .as("Password input field should be present")
                .isGreaterThan(0);

        // Check if labels are present (optional but good for accessibility)
        boolean hasEmailLabel = loginPage.isEmailLabelVisible();
        boolean hasPasswordLabel = loginPage.isPasswordLabelVisible();

        // Log label presence for informational purposes
        System.out.println("Email label present: " + hasEmailLabel);
        System.out.println("Password label present: " + hasPasswordLabel);

        // At minimum, fields should have placeholder text or labels
        String emailPlaceholder = loginPage.getEmailInputPlaceholder();
        String passwordPlaceholder = loginPage.getPasswordInputPlaceholder();

        assertThat(hasEmailLabel || !emailPlaceholder.isEmpty())
                .as("Email field should have either a label or placeholder text for user guidance")
                .isTrue();

        assertThat(hasPasswordLabel || !passwordPlaceholder.isEmpty())
                .as("Password field should have either a label or placeholder text for user guidance")
                .isTrue();
    }

    /**
     * Test with random credentials as specified in AC
     */
    @Test
    @DisplayName("Verify user can enter random credentials")
    void verifyUserCanEnterRandomCredentials() {
        // Arrange
        LoginPage loginPage = new LoginPage(page);
        String randomEmail = "random.user" + System.currentTimeMillis() + "@test.com";
        String randomPassword = "RandomPass" + System.currentTimeMillis() + "!";

        // Act
        loginPage.navigate(LOGIN_URL)
                .enterCredentials(randomEmail, randomPassword);

        // Assert
        assertThat(loginPage.getEmailInput().inputValue())
                .as("Random email should be successfully entered")
                .isEqualTo(randomEmail);

        assertThat(loginPage.getPasswordInput().inputValue())
                .as("Random password should be successfully entered")
                .isEqualTo(randomPassword);
    }
}
