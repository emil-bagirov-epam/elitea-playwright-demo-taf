package com.elitea.tests.ui;

import com.elitea.ui.pages.LoginPage;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test class for Login page functionality
 */
public class LoginPageTest extends BaseUiTest {
    
    @Test
    @DisplayName("SCRUM-87: Verify login form input fields are present")
    @Description("SCRUM-87: Verify that login form contains Email and Password input fields")
    void verifyLoginFormInputFieldsArePresent() {
        // Given: User is on the login page
        LoginPage loginPage = new LoginPage(page)
                .navigateToLoginPage()
                .waitForPageLoad();
        
        // When: User examines the login form
        // Then: Email input field should be visible and labeled
        assertThat(loginPage.isEmailInputFieldVisible())
                .as("Email input field should be visible")
                .isTrue();
        
        assertThat(loginPage.getEmailFieldLabel())
                .as("Email field should have proper label")
                .isEqualTo("E-mail");
        
        // And: Password input field should be visible and labeled
        assertThat(loginPage.isPasswordInputFieldVisible())
                .as("Password input field should be visible")
                .isTrue();
        
        assertThat(loginPage.getPasswordFieldLabel())
                .as("Password field should have proper label")
                .isEqualTo("Password");
        
        // And: Both fields should be part of the login form
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
