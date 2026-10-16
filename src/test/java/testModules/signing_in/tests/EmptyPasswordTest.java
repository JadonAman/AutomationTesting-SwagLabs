package testModules.signing_in.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import constants.LoginCredentials;
import pages.LoginPage;
import utilities.ReportLogger;

public class EmptyPasswordTest extends BaseTest {

    @Test
    public void verifyEmptyPassword() {

        ReportLogger.step("Leave password empty");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername(
                LoginCredentials.VALID_USERNAME
        );

        loginPage.clickLogin();

        ReportLogger.pass("Login button clicked");

        ReportLogger.step("Verify password required error message");

        Assert.assertTrue(
                loginPage.getErrorMessage()
                        .contains("Password is required"),
                "Password required error message should be displayed."
        );

        ReportLogger.pass("Password required validation verified");
    }
}