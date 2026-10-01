package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage {

    private WebDriver driver;

    // Product Information
    private By productName =
            By.cssSelector("[data-test='inventory-item-name']");

    private By productDescription =
            By.cssSelector("[data-test='inventory-item-desc']");

    private By productPrice =
            By.cssSelector("[data-test='inventory-item-price']");

    private By productImage =
            By.cssSelector(".inventory_details_img");

    // Buttons
    private By addToCartButton =
            By.id("add-to-cart");

    private By backToProductsButton =
            By.id("back-to-products");

    // Cart
    private By shoppingCart =
            By.cssSelector(".shopping_cart_link");

    private By cartBadge =
            By.cssSelector(".shopping_cart_badge");

    // Menu
    private By menuButton =
            By.id("react-burger-menu-btn");

    private By logoutLink =
            By.id("logout_sidebar_link");

    private By resetAppStateLink =
            By.id("reset_sidebar_link");

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    // ==================================
    // Product Information
    // ==================================

    public String getProductName() {

        return driver.findElement(productName)
                .getText();
    }

    public String getProductDescription() {

        return driver.findElement(productDescription)
                .getText();
    }

    public String getProductPrice() {

        return driver.findElement(productPrice)
                .getText();
    }

    public boolean isProductImageDisplayed() {

        return driver.findElement(productImage)
                .isDisplayed();
    }

    // ==================================
    // Actions
    // ==================================

    public void clickAddToCart() {

        driver.findElement(addToCartButton)
                .click();
    }

    public void clickBackToProducts() {

        driver.findElement(backToProductsButton)
                .click();
    }

    public void clickCart() {

        driver.findElement(shoppingCart)
                .click();
    }

    // ==================================
    // Verification
    // ==================================

    public boolean verifyProductName(String expectedName) {

        return getProductName()
                .equalsIgnoreCase(expectedName);
    }

    public boolean verifyProductPrice(String expectedPrice) {

        return getProductPrice()
                .equals(expectedPrice);
    }

    // ==================================
    // Cart Badge
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