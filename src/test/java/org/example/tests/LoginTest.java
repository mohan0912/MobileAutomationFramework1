package org.example.tests;

import org.example.base.TestBase;
import org.example.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void testLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        assert loginPage.isLoginSuccessful() : "Login failed!";
    }
}