package testModules;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import constants.LoginCredentials;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
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


    @Test(priority = 2)
    public void verifyValidLogin() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                LoginCredentials.VALID_USERNAME,
                LoginCredentials.VALID_PASSWORD
        );

        Assert.assertTrue(
                driver.getCurrentUrl().contains("/inventory.html"),
                "User should be redirected to inventory page after successful login."
        );
    }


    @Test(priority = 3)
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


    @Test(priority = 4)
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


    @Test(priority = 5)
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


    @Test(priority = 6)
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


    @Test(priority = 7)
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