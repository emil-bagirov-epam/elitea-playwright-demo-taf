package com.elitea.tests.ui;

import com.elitea.ui.pages.LoginPage;
import com.microsoft.playwright.Page;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginPageTest extends BaseUiTest {

    @Test
    @Description("SCRUM-87: Verify login form contains Email and Password input fields")
    @DisplayName("SCRUM-87: Verify login form input fields are present")
    void verifyLoginFormInputFieldsArePresent() {
        // Given: User is on the login page
        LoginPage loginPage = new LoginPage(page).navigate();
        
        // When: User locates the login form
        // Then: Email input field is visible and labeled
        assertThat(loginPage.isEmailFieldVisible())
                .as("Email input field should be visible")
                .isTrue();
        
        assertThat(loginPage.isEmailLabelVisible())
                .as("Email field should have a label")
                .isTrue();
        
        // And: Password input field is visible and labeled
        assertThat(loginPage.isPasswordFieldVisible())
                .as("Password input field should be visible")
                .isTrue();
        
        assertThat(loginPage.isPasswordLabelVisible())
                .as("Password field should have a label")
                .isTrue();
        
        // And: Both fields are part of the login form
        assertThat(loginPage.isLoginFormVisible())
                .as("Login form should be visible")
                .isTrue();
        
        assertThat(loginPage.areInputFieldsPartOfLoginForm())
                .as("Both email and password fields should be part of the login form")
                .isTrue();
        
        // Additional validations for field properties
        assertThat(loginPage.getEmailFieldPlaceholder())
                .as("Email field should have appropriate placeholder")
                .isEqualTo("Type your e-mail");
        
        assertThat(loginPage.getPasswordFieldPlaceholder())
                .as("Password field should have appropriate placeholder")
                .isEqualTo("Type your password");
        
        assertThat(loginPage.getPasswordFieldType())
                .as("Password field should be of type password")
                .isEqualTo("password");
    }
}
