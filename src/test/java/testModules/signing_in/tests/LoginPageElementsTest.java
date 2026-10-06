package testModules.signing_in.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginPageElementsTest extends BaseTest {

    @Test
    public void verifyLoginPageElements() {

        LoginPage loginPage = new LoginPage(driver);

        Assert.assertTrue(
                loginPage.isUsernameDisplayed(),
                "Username field should be displayed."
        );

        Assert.assertTrue(
                loginPage.isPasswordDisplayed(),
                "Password field should be displayed."
        );

        Assert.assertTrue(
                loginPage.isLoginButtonDisplayed(),
                "Login button should be displayed."
        );

        Assert.assertTrue(
                loginPage.isLoginButtonEnabled(),
                "Login button should be enabled."
        );
    }
}