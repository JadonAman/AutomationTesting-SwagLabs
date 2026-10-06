package testModules.signing_in.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import constants.LoginCredentials;

import pages.LoginPage;

public class ValidLoginTest extends BaseTest {

    @Test
    public void verifyValidLogin() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                LoginCredentials.VALID_USERNAME,
                LoginCredentials.VALID_PASSWORD
        );

        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory"),
                "Login Failed"
        );
    }
}