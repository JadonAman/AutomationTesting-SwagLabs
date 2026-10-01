package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DynamicCatalogLazyLoadPage {

    private WebDriver driver;

    // Header
    private By pageTitle =
            By.cssSelector("[data-test='title']");

    // Products
    private By productCards =
            By.cssSelector(".dynamic_catalog_card");

    private By productNames =
            By.cssSelector(".dynamic_catalog_card_name");

    private By productPrices =
            By.cssSelector(".dynamic_catalog_card_price");

    private By productImages =
            By.cssSelector(".dynamic_catalog_card_img");

    // Lazy Load Sentinel
    private By sentinel =
            By.cssSelector(
                    "[data-test='dynamic-catalog-lazy-load-sentinel']");

    // Menu
    private By menuButton =
            By.id("react-burger-menu-btn");

    private By logoutLink =
            By.id("logout_sidebar_link");

    private By resetAppStateLink =
            By.id("reset_sidebar_link");

    public DynamicCatalogLazyLoadPage(WebDriver driver) {
        this.driver = driver;
    }

    // ==========================
    // Page Validation
    // ==========================

    public String getPageTitle() {
        return driver.findElement(pageTitle)
                .getText();
    }

    public boolean isLazyLoadPageDisplayed() {
        return getPageTitle()
                .equalsIgnoreCase(
                        "Dynamic Catalog - Lazy Load");
    }

    // ==========================
    // Product Count
    // ==========================

    public int getProductCount() {
        return driver.findElements(productCards)
                .size();
    }

    // ==========================
    // Product Details
    // ==========================

    public String getProductName(int index) {

        return driver.findElements(productNames)
                .get(index)
                .getText();
    }

    public String getProductPrice(int index) {

        return driver.findElements(productPrices)
                .get(index)
                .getText();
    }

    public boolean isProductImageDisplayed(int index) {

        return driver.findElements(productImages)
                .get(index)
                .isDisplayed();
    }

    // ==========================
    // Scroll
    // ==========================

    public void scrollToBottom() {

        WebElement target =
                driver.findElement(sentinel);

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollIntoView(true);",
                        target);
    }

    public void scrollToCompletePage() {

        ((JavascriptExecutor) driver)
                .executeScript(
                        "window.scrollTo(0, document.body.scrollHeight)");
    }

    // ==========================
    // Product Search
    // ==========================

    public boolean isProductPresent(String productName) {

        List<WebElement> products =
                driver.findElements(productNames);

        for (WebElement product : products) {

            if (product.getText()
                    .equalsIgnoreCase(productName)) {

                return true;
            }
        }

        return false;
    }

    // ==========================
    // Print Products
    // ==========================

    public void printAllProducts() {

        List<WebElement> names =
                driver.findElements(productNames);

        List<WebElement> prices =
                driver.findElements(productPrices);

        for (int i = 0; i < names.size(); i++) {

            System.out.println(
                    names.get(i).getText()
                            + " - "
                            + prices.get(i).getText());
        }
    }

    // ==========================
    // Menu Actions
    // ==========================

    public void openMenu() {
        driver.findElement(menuButton).click();
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