package testModules.signing_in.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import constants.LoginCredentials;
import pages.LoginPage;
import utilities.ReportLogger;

public class ValidLoginTest extends BaseTest {

    @Test
    public void verifyValidLogin() {

        ReportLogger.step("Enter valid username and password");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                LoginCredentials.VALID_USERNAME,
                LoginCredentials.VALID_PASSWORD
        );

        ReportLogger.pass("Credentials entered successfully");

        ReportLogger.step("Verify successful login");

        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory"),
                "Login Failed"
        );

        ReportLogger.pass("User successfully logged in");
    }
}