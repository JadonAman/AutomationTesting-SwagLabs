package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    // Username Field
    private By usernameField =
            By.id("user-name");

    // Password Field
    private By passwordField =
            By.id("password");

    // Login Button
    private By loginButton =
            By.id("login-button");

    // Error Message
    private By errorMessage =
            By.cssSelector("[data-test='error']");

    // Login Credentials Section
    private By acceptedUsers =
            By.id("login_credentials");

    // Password Hint Section
    private By passwordHint =
            By.cssSelector("[data-test='login-password']");

    // Page Logo
    private By pageLogo =
            By.className("login_logo");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // ==========================
    // Action Methods
    // ==========================

    public void enterUsername(String username) {

        driver.findElement(usernameField)
                .clear();

        driver.findElement(usernameField)
                .sendKeys(username);
    }

    public void enterPassword(String password) {

        driver.findElement(passwordField)
                .clear();

        driver.findElement(passwordField)
                .sendKeys(password);
    }

    public void clickLogin() {

        driver.findElement(loginButton)
                .click();
    }

    // ==========================
    // Business Method
    // ==========================

    public void login(String username,
                      String password) {

        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    // ==========================
    // Validation Methods
    // ==========================

    public String getErrorMessage() {

        return driver.findElement(errorMessage)
                .getText();
    }

    public String getLogoText() {

        return driver.findElement(pageLogo)
                .getText();
    }

    public String getAcceptedUsersText() {

        return driver.findElement(acceptedUsers)
                .getText();
    }

    public String getPasswordHintText() {

        return driver.findElement(passwordHint)
                .getText();
    }

    // ==========================
    // Utility Methods
    // ==========================

    public boolean isUsernameDisplayed() {

        return driver.findElement(usernameField)
                .isDisplayed();
    }

    public boolean isPasswordDisplayed() {

        return driver.findElement(passwordField)
                .isDisplayed();
    }

    public boolean isLoginButtonDisplayed() {

        return driver.findElement(loginButton)
                .isDisplayed();
    }

    public boolean isLoginButtonEnabled() {

        return driver.findElement(loginButton)
                .isEnabled();
    }

    public void clearUsername() {

        driver.findElement(usernameField)
                .clear();
    }

    public void clearPassword() {

        driver.findElement(passwordField)
                .clear();
    }

    public String getEnteredUsername() {

        return driver.findElement(usernameField)
                .getAttribute("value");
    }

    public String getEnteredPassword() {

        return driver.findElement(passwordField)
                .getAttribute("value");
    }
}