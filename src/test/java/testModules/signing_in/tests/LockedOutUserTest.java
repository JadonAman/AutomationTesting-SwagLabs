package testModules.signing_in.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import constants.LoginCredentials;
import pages.LoginPage;
import utilities.ReportLogger;

public class LockedOutUserTest extends BaseTest {

    @Test
    public void verifyLockedOutUser() {

        ReportLogger.step("Login with locked out user");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                LoginCredentials.LOCKED_OUT_USER,
                LoginCredentials.VALID_PASSWORD
        );

        ReportLogger.pass("Login attempted");

        ReportLogger.step("Verify locked out user message");

        Assert.assertTrue(
                loginPage.getErrorMessage()
                        .contains("locked out"),
                "Locked out user error message should be displayed."
        );

        ReportLogger.pass("Locked out user validation verified");
    }
}