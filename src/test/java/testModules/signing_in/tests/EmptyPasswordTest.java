package testModules.signing_in.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import constants.LoginCredentials;
import pages.LoginPage;

public class EmptyPasswordTest extends BaseTest {

    @Test
    public void verifyEmptyPassword() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername(
                LoginCredentials.VALID_USERNAME
        );

        loginPage.clickLogin();

        Assert.assertTrue(
                loginPage.getErrorMessage()
                        .contains("Password is required"),
                "Password required error message should be displayed."
        );
    }
}