package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

    private WebDriver driver;

    // Header
    private By cartTitle =
            By.cssSelector("[data-test='title']");

    private By cartBadge =
            By.className("shopping_cart_badge");

    // Cart Items
    private By cartItems =
            By.cssSelector(".cart_item");

    private By itemNames =
            By.cssSelector(".inventory_item_name");

    private By itemPrices =
            By.cssSelector(".inventory_item_price");

    private By itemQuantities =
            By.cssSelector(".cart_quantity");

    // Buttons
    private By continueShoppingButton =
            By.id("continue-shopping");

    private By checkoutButton =
            By.id("checkout");

    // Menu
    private By menuButton =
            By.id("react-burger-menu-btn");

    private By logoutLink =
            By.id("logout_sidebar_link");

    private By resetAppStateLink =
            By.id("reset_sidebar_link");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // ==================================
    // Page Verification
    // ==================================

    public String getPageTitle() {

        return driver.findElement(cartTitle)
                .getText();
    }

    public boolean isCartPageDisplayed() {

        return getPageTitle()
                .equalsIgnoreCase("Your Cart");
    }

    // ==================================
    // Cart Information
    // ==================================

    public int getCartItemCount() {

        return driver.findElements(cartItems)
                .size();
    }

    public String getCartBadgeCount() {

        try {

            return driver.findElement(cartBadge)
                    .getText();

        } catch (Exception e) {

            return "0";
        }
    }

    public List<WebElement> getAllItems() {

        return driver.findElements(cartItems);
    }

    // ==================================
    // Product Verification
    // ==================================

    public boolean isProductPresent(String productName) {

        List<WebElement> products =
                driver.findElements(itemNames);

        for (WebElement product : products) {

            if (product.getText()
                    .equalsIgnoreCase(productName)) {

                return true;
            }
        }

        return false;
    }

    public String getProductPrice(String productName) {

        List<WebElement> products =
                driver.findElements(cartItems);

        for (WebElement product : products) {

            String name =
                    product.findElement(
                            By.className(
                                    "inventory_item_name"))
                           .getText();

            if (name.equalsIgnoreCase(productName)) {

                return product.findElement(
                        By.className(
                                "inventory_item_price"))
                        .getText();
            }
        }

        return null;
    }

    public String getProductQuantity(String productName) {

        List<WebElement> products =
                driver.findElements(cartItems);

        for (WebElement product : products) {

            String name =
                    product.findElement(
                            By.className(
                                    "inventory_item_name"))
                           .getText();

            if (name.equalsIgnoreCase(productName)) {

                return product.findElement(
                        By.className("cart_quantity"))
                        .getText();
            }
        }

        return null;
    }

    // ==================================
    // Remove Product
    // ==================================

    public void removeProduct(String productId) {

        By removeButton =
                By.id("remove-" + productId);

        driver.findElement(removeButton)
                .click();
    }

    /*
        Example:

        removeProduct(
          "sauce-labs-backpack");

        removeProduct(
          "sauce-labs-bike-light");
    */

    // ==================================
    // Navigation
    // ==================================

    public void clickContinueShopping() {

        driver.findElement(
                continueShoppingButton)
                .click();
    }

    public void clickCheckout() {

        driver.findElement(
                checkoutButton)
                .click();
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