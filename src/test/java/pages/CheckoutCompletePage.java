package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {

    private WebDriver driver;

    // Page Title
    private By pageTitle =
            By.cssSelector("[data-test='title']");

    // Order Confirmation
    private By completeHeader =
            By.cssSelector("[data-test='complete-header']");

    private By completeText =
            By.cssSelector("[data-test='complete-text']");

    private By ponyExpressImage =
            By.cssSelector("[data-test='pony-express']");

    // Buttons
    private By backHomeButton =
            By.id("back-to-products");

    private By generatePdfButton =
            By.id("generate-pdf-order");

    // Cart
    private By cartLink =
            By.cssSelector(".shopping_cart_link");

    // Menu
    private By menuButton =
            By.id("react-burger-menu-btn");

    private By logoutLink =
            By.id("logout_sidebar_link");

    private By resetAppStateLink =
            By.id("reset_sidebar_link");

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    // ==================================
    // Page Validation
    // ==================================

    public String getPageTitle() {

        return driver.findElement(pageTitle)
                .getText();
    }

    public boolean isCheckoutCompletePageDisplayed() {

        return getPageTitle()
                .equalsIgnoreCase("Checkout: Complete!");
    }

    // ==================================
    // Success Message
    // ==================================

    public String getCompleteHeader() {

        return driver.findElement(completeHeader)
                .getText();
    }

    public String getCompleteText() {

        return driver.findElement(completeText)
                .getText();
    }

    public boolean isOrderCompleted() {

        return getCompleteHeader()
                .equalsIgnoreCase(
                        "Thank you for your order!");
    }

    // ==================================
    // UI Verification
    // ==================================

    public boolean isPonyExpressImageDisplayed() {

        return driver.findElement(ponyExpressImage)
                .isDisplayed();
    }

    public boolean isBackHomeButtonDisplayed() {

        return driver.findElement(backHomeButton)
                .isDisplayed();
    }

    public boolean isGeneratePdfButtonDisplayed() {

        return driver.findElement(generatePdfButton)
                .isDisplayed();
    }

    // ==================================
    // Buttons
    // ==================================

    public void clickBackHome() {

        driver.findElement(backHomeButton)
                .click();
    }

    public void clickGeneratePdfOrder() {

        driver.findElement(generatePdfButton)
                .click();
    }

    // ==================================
    // Cart
    // ==================================

    public boolean isCartDisplayed() {

        return driver.findElement(cartLink)
                .isDisplayed();
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