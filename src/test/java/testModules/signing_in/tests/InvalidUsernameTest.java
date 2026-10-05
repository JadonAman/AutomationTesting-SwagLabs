package testModules.signing_in.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import constants.LoginCredentials;
import pages.LoginPage;

public class InvalidUsernameTest extends BaseTest {

    @Test
    public void verifyInvalidUsername() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                LoginCredentials.INVALID_USERNAME,
                LoginCredentials.VALID_PASSWORD
        );

        Assert.assertTrue(
                loginPage.getErrorMessage()
                        .contains("Username and password do not match"),
                "Invalid username error message should be displayed."
        );
    }
}