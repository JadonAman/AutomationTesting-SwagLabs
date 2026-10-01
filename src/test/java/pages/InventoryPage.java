package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage {

    private WebDriver driver;

    // Header
    private By menuButton =
            By.id("react-burger-menu-btn");

    private By closeMenuButton =
            By.id("react-burger-cross-btn");

    private By cartIcon =
            By.cssSelector("[data-test='shopping-cart-link']");

    private By pageTitle =
            By.cssSelector("[data-test='title']");

    private By appLogo =
            By.className("app_logo");

    // Menu Links
    private By allItemsLink =
            By.id("inventory_sidebar_link");

    private By aboutLink =
            By.id("about_sidebar_link");

    private By logoutLink =
            By.id("logout_sidebar_link");

    private By resetAppStateLink =
            By.id("reset_sidebar_link");

    // Sorting
    private By sortDropdown =
            By.cssSelector(
                    "[data-test='product-sort-container']");

    // Cart Badge
    private By cartBadge =
            By.className("shopping_cart_badge");

    // Product Information
    private By inventoryItems =
            By.cssSelector(".inventory_item");

    private By productNames =
            By.cssSelector(".inventory_item_name");

    private By productPrices =
            By.cssSelector(".inventory_item_price");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    // ====================================
    // Header Methods
    // ====================================

    public String getPageTitle() {

        return driver.findElement(pageTitle)
                .getText();
    }

    public String getLogoText() {

        return driver.findElement(appLogo)
                .getText();
    }

    public void openMenu() {

        driver.findElement(menuButton)
                .click();
    }

    public void closeMenu() {

        driver.findElement(closeMenuButton)
                .click();
    }

    public void openCart() {

        driver.findElement(cartIcon)
                .click();
    }

    // ====================================
    // Menu Methods
    // ====================================

    public void clickAllItems() {

        openMenu();

        driver.findElement(allItemsLink)
                .click();
    }

    public void clickAbout() {

        openMenu();

        driver.findElement(aboutLink)
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

    // ====================================
    // Sorting Methods
    // ====================================

    public void sortByNameAZ() {

        Select select =
                new Select(
                        driver.findElement(sortDropdown));

        select.selectByValue("az");
    }

    public void sortByNameZA() {

        Select select =
                new Select(
                        driver.findElement(sortDropdown));

        select.selectByValue("za");
    }

    public void sortByPriceLowToHigh() {

        Select select =
                new Select(
                        driver.findElement(sortDropdown));

        select.selectByValue("lohi");
    }

    public void sortByPriceHighToLow() {

        Select select =
                new Select(
                        driver.findElement(sortDropdown));

        select.selectByValue("hilo");
    }

    // ====================================
    // Dynamic Product Methods
    // ====================================

    public void addProductToCart(String productId) {

        By locator =
                By.id("add-to-cart-" + productId);

        driver.findElement(locator)
                .click();
    }

    public void removeProductFromCart(String productId) {

        By locator =
                By.id("remove-" + productId);

        driver.findElement(locator)
                .click();
    }

    // ====================================
    // Product Navigation
    // ====================================

    public void openProduct(String itemNumber) {

        By locator =
                By.id("item_" + itemNumber + "_title_link");

        driver.findElement(locator)
                .click();
    }

    // ====================================
    // Cart Methods
    // ====================================

    public String getCartCount() {

        try {

            return driver.findElement(cartBadge)
                    .getText();

        } catch (Exception e) {

            return "0";
        }
    }

    // ====================================
    // Verification Methods
    // ====================================

    public boolean isCartDisplayed() {

        return driver.findElement(cartIcon)
                .isDisplayed();
    }

    public boolean isMenuDisplayed() {

        return driver.findElement(menuButton)
                .isDisplayed();
    }

    public boolean isSortDisplayed() {

        return driver.findElement(sortDropdown)
                .isDisplayed();
    }

    public int getProductCount() {

        return driver.findElements(inventoryItems)
                .size();
    }
}