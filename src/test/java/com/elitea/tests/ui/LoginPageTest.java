package com.elitea.tests.ui;

import com.elitea.ui.pages.LoginPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import io.qameta.allure.Description;

public class LoginPageTest extends BaseUiTest {

    private static LoginPage loginPage;

    @BeforeAll
    public static void initializePageObjects() {
        loginPage = new LoginPage(page);
    }

    @Test
    @Description("SCRUM-155: Verify presence of email and password input fields on login page")
    public void testEmailAndPasswordInputFieldsPresence() {
        assertTrue(loginPage.isEmailInputPresent(), "Email input field should be present");
        assertTrue(loginPage.isPasswordInputPresent(), "Password input field should be present");
    }
}