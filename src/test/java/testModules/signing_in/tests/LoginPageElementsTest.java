package testModules.signing_in.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utilities.ReportLogger;

public class LoginPageElementsTest extends BaseTest {

    @Test
    public void verifyLoginPageElements() {

        LoginPage loginPage = new LoginPage(driver);

        ReportLogger.step("Verify username field");

        Assert.assertTrue(
                loginPage.isUsernameDisplayed(),
                "Username field should be displayed."
        );

        ReportLogger.pass("Username field verified");

        ReportLogger.step("Verify password field");

        Assert.assertTrue(
                loginPage.isPasswordDisplayed(),
                "Password field should be displayed."
        );

        ReportLogger.pass("Password field verified");

        ReportLogger.step("Verify login button visibility");

        Assert.assertTrue(
                loginPage.isLoginButtonDisplayed(),
                "Login button should be displayed."
        );

        ReportLogger.pass("Login button displayed");

        ReportLogger.step("Verify login button enabled");

        Assert.assertTrue(
                loginPage.isLoginButtonEnabled(),
                "Login button should be enabled."
        );

        ReportLogger.pass("Login button enabled");
    }
}