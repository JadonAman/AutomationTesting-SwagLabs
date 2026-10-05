package testModules.signing_in.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import constants.LoginCredentials;
import pages.LoginPage;

public class InvalidPasswordTest extends BaseTest {

    @Test
    public void verifyInvalidPassword() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                LoginCredentials.VALID_USERNAME,
                LoginCredentials.INVALID_PASSWORD
        );

        Assert.assertTrue(
                loginPage.getErrorMessage()
                        .contains("Username and password do not match"),
                "Invalid password error message should be displayed."
        );
    }
}
