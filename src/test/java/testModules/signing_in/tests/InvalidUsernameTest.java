package testModules.signing_in.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import constants.LoginCredentials;
import pages.LoginPage;
import utilities.ReportLogger;

public class InvalidUsernameTest extends BaseTest {

    @Test
    public void verifyInvalidUsername() {

        ReportLogger.step("Enter invalid username");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                LoginCredentials.INVALID_USERNAME,
                LoginCredentials.VALID_PASSWORD
        );

        ReportLogger.pass("Login attempted");

        ReportLogger.step("Verify invalid username error message");

        Assert.assertTrue(
                loginPage.getErrorMessage()
                        .contains("Username and password do not match"),
                "Invalid username error message should be displayed."
        );

        ReportLogger.pass("Correct error message displayed");
    }
}