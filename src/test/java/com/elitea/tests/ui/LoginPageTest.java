package com.elitea.tests.ui;

import com.elitea.ui.pages.LoginPage;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test class for Login Page functionality
 */
public class LoginPageTest extends BaseUiTest {
    
    @Test
    @DisplayName("TC-002: Verify login form input fields are present")
    @Description("SCRUM-87: Verify that login form contains Email and Password input fields")
    void verifyLoginFormInputFieldsArePresent() {
        // Arrange
        LoginPage loginPage = new LoginPage(page);
        
        // Act
        loginPage.navigateToLoginPage()
                .waitForPageLoad();
        
        // Assert - Verify Email input field is visible and labeled
        assertThat(loginPage.isEmailFieldVisible())
                .as("Email input field should be visible")
                .isTrue();
        
        assertThat(loginPage.isEmailLabelVisible())
                .as("Email label should be visible")
                .isTrue();
        
        assertThat(loginPage.getEmailFieldPlaceholder())
                .as("Email field should have proper placeholder")
                .isEqualTo("Type your e-mail");
        
        // Assert - Verify Password input field is visible and labeled
        assertThat(loginPage.isPasswordFieldVisible())
                .as("Password input field should be visible")
                .isTrue();
        
        assertThat(loginPage.isPasswordLabelVisible())
                .as("Password label should be visible")
                .isTrue();
        
        assertThat(loginPage.getPasswordFieldPlaceholder())
                .as("Password field should have proper placeholder")
                .isEqualTo("Type your password");
        
        // Assert - Verify both fields are part of the login form
        assertThat(loginPage.isLoginFormVisible())
                .as("Login form should be visible")
                .isTrue();
        
        assertThat(loginPage.isEmailFieldInForm())
                .as("Email field should be part of the login form")
                .isTrue();
        
        assertThat(loginPage.isPasswordFieldInForm())
                .as("Password field should be part of the login form")
                .isTrue();
    }
}
