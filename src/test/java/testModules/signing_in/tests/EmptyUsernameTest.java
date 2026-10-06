package testModules.signing_in.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import constants.LoginCredentials;
import pages.LoginPage;

public class EmptyUsernameTest extends BaseTest {

    @Test
    public void verifyEmptyUsername() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterPassword(
                LoginCredentials.VALID_PASSWORD
        );

        loginPage.clickLogin();

        Assert.assertTrue(
                loginPage.getErrorMessage()
                        .contains("Username is required"),
                "Username required error message should be displayed."
        );
    }
}