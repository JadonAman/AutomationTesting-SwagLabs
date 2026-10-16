package testModules.signing_in.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import constants.LoginCredentials;
import pages.LoginPage;
import utilities.ReportLogger;

public class EmptyUsernameTest extends BaseTest {

    @Test
    public void verifyEmptyUsername() {

        ReportLogger.step("Leave username empty");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterPassword(
                LoginCredentials.VALID_PASSWORD
        );

        loginPage.clickLogin();

        ReportLogger.pass("Login button clicked");

        ReportLogger.step("Verify username required error message");

        Assert.assertTrue(
                loginPage.getErrorMessage()
                        .contains("Username is required"),
                "Username required error message should be displayed."
        );

        ReportLogger.pass("Username required validation verified");
    }
}