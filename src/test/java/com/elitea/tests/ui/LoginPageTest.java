package com.elitea.tests.ui;

import com.elitea.ui.pages.LoginPage;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import io.qameta.allure.Description;

public class LoginPageTest extends BaseUiTest {

    @Test
    @Description("SCRUM-160: Verify login page displays email and password input fields")
    public void testLoginPageDisplaysInputFields() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.navigateToLoginPage();
        assertTrue(loginPage.isEmailInputFieldPresent(), "Email input field should be present");
        assertTrue(loginPage.isPasswordInputFieldPresent(), "Password input field should be present");
    }
}