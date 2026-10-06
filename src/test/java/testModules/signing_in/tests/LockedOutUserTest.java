package testModules.signing_in.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import constants.LoginCredentials;
import pages.LoginPage;

public class LockedOutUserTest extends BaseTest {

    @Test
    public void verifyLockedOutUser() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                LoginCredentials.LOCKED_OUT_USER,
                LoginCredentials.VALID_PASSWORD
        );

        Assert.assertTrue(
                loginPage.getErrorMessage()
                        .contains("locked out"),
                "Locked out user error message should be displayed."
        );
    }
}