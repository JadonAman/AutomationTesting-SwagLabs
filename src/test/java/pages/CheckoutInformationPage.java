package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInformationPage {

    private WebDriver driver;

    // Page Title
    private By pageTitle =
            By.cssSelector("[data-test='title']");

    // Customer Information Fields
    private By firstNameField =
            By.id("first-name");

    private By lastNameField =
            By.id("last-name");

    private By postalCodeField =
            By.id("postal-code");

    // Buttons
    private By continueButton =
            By.id("continue");

    private By cancelButton =
            By.id("cancel");

    // Error Message
    private By errorMessage =
            By.cssSelector("[data-test='error']");

    // Header
    private By cartBadge =
            By.className("shopping_cart_badge");

    // Menu
    private By menuButton =
            By.id("react-burger-menu-btn");

    private By logoutLink =
            By.id("logout_sidebar_link");

    private By resetAppStateLink =
            By.id("reset_sidebar_link");

    public CheckoutInformationPage(WebDriver driver) {
        this.driver = driver;
    }

    // ==================================
    // Page Validation
    // ==================================

    public String getPageTitle() {

        return driver.findElement(pageTitle)
                .getText();
    }

    public boolean isCheckoutInformationPageDisplayed() {

        return getPageTitle()
                .equalsIgnoreCase(
                        "Checkout: Your Information");
    }

    // ==================================
    // Data Entry
    // ==================================

    public void enterFirstName(String firstName) {

        driver.findElement(firstNameField)
                .clear();

        driver.findElement(firstNameField)
                .sendKeys(firstName);
    }

    public void enterLastName(String lastName) {

        driver.findElement(lastNameField)
                .clear();

        driver.findElement(lastNameField)
                .sendKeys(lastName);
    }

    public void enterPostalCode(String postalCode) {

        driver.findElement(postalCodeField)
                .clear();

        driver.findElement(postalCodeField)
                .sendKeys(postalCode);
    }

    // ==================================
    // Business Method
    // ==================================

    public void fillCheckoutInformation(
            String firstName,
            String lastName,
            String postalCode) {

        enterFirstName(firstName);
        enterLastName(lastName);
        enterPostalCode(postalCode);
    }

    public void continueCheckout(
            String firstName,
            String lastName,
            String postalCode) {

        fillCheckoutInformation(
                firstName,
                lastName,
                postalCode);

        clickContinue();
    }

    // ==================================
    // Navigation
    // ==================================

    public void clickContinue() {

        driver.findElement(continueButton)
                .click();
    }

    public void clickCancel() {

        driver.findElement(cancelButton)
                .click();
    }

    // ==================================
    // Field Validation
    // ==================================

    public String getFirstNameValue() {

        return driver.findElement(firstNameField)
                .getAttribute("value");
    }

    public String getLastNameValue() {

        return driver.findElement(lastNameField)
                .getAttribute("value");
    }

    public String getPostalCodeValue() {

        return driver.findElement(postalCodeField)
                .getAttribute("value");
    }

    public void clearFirstName() {

        driver.findElement(firstNameField)
                .clear();
    }

    public void clearLastName() {

        driver.findElement(lastNameField)
                .clear();
    }

    public void clearPostalCode() {

        driver.findElement(postalCodeField)
                .clear();
    }

    // ==================================
    // Error Handling
    // ==================================

    public String getErrorMessage() {

        return driver.findElement(errorMessage)
                .getText();
    }

    // ==================================
    // UI Verification
    // ==================================

    public boolean isFirstNameDisplayed() {

        return driver.findElement(firstNameField)
                .isDisplayed();
    }

    public boolean isLastNameDisplayed() {

        return driver.findElement(lastNameField)
                .isDisplayed();
    }

    public boolean isPostalCodeDisplayed() {

        return driver.findElement(postalCodeField)
                .isDisplayed();
    }

    public boolean isContinueButtonDisplayed() {

        return driver.findElement(continueButton)
                .isDisplayed();
    }

    public boolean isCancelButtonDisplayed() {

        return driver.findElement(cancelButton)
                .isDisplayed();
    }

    // ==================================
    // Cart
    // ==================================

    public String getCartCount() {

        try {

            return driver.findElement(cartBadge)
                    .getText();

        } catch (Exception e) {

            return "0";
        }
    }

    // ==================================
    // Menu Actions
    // ==================================

    public void openMenu() {

        driver.findElement(menuButton)
                .click();
    }

    public void logout() {

        openMenu();

        driver.findElement(logoutLink)
                .click();
    }

    public void resetAppState() {

        openMenu();

        driver.findElement(resetAppStateLink)
                .click();
    }
}