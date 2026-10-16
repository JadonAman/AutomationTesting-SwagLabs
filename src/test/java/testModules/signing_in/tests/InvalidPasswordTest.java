package testModules.signing_in.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import constants.LoginCredentials;
import pages.LoginPage;
import utilities.ReportLogger;

public class InvalidPasswordTest extends BaseTest {

    @Test
    public void verifyInvalidPassword() {

        ReportLogger.step("Enter invalid password");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                LoginCredentials.VALID_USERNAME,
                LoginCredentials.INVALID_PASSWORD
        );

        ReportLogger.pass("Login attempted");

        ReportLogger.step("Verify invalid password error message");

        Assert.assertTrue(
                loginPage.getErrorMessage()
                        .contains("Username and password do not match"),
                "Invalid password error message should be displayed."
        );

        ReportLogger.pass("Correct error message displayed");
    }
}