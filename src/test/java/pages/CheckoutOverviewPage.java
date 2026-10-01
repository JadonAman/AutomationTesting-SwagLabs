package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutOverviewPage {

    private WebDriver driver;

    // Page Title
    private By pageTitle =
            By.cssSelector("[data-test='title']");

    // Products
    private By cartItems =
            By.cssSelector(".cart_item");

    private By productNames =
            By.cssSelector(".inventory_item_name");

    private By productPrices =
            By.cssSelector(".inventory_item_price");

    private By productQuantities =
            By.cssSelector(".cart_quantity");

    // Summary Information
    private By paymentInfo =
            By.cssSelector("[data-test='payment-info-value']");

    private By shippingInfo =
            By.cssSelector("[data-test='shipping-info-value']");

    private By itemTotal =
            By.cssSelector("[data-test='subtotal-label']");

    private By tax =
            By.cssSelector("[data-test='tax-label']");

    private By total =
            By.cssSelector("[data-test='total-label']");

    // Buttons
    private By finishButton =
            By.id("finish");

    private By cancelButton =
            By.id("cancel");

    // Cart Badge
    private By cartBadge =
            By.className("shopping_cart_badge");

    // Menu
    private By menuButton =
            By.id("react-burger-menu-btn");

    private By logoutLink =
            By.id("logout_sidebar_link");

    private By resetAppStateLink =
            By.id("reset_sidebar_link");

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    // ==================================
    // Page Validation
    // ==================================

    public String getPageTitle() {

        return driver.findElement(pageTitle)
                .getText();
    }

    public boolean isCheckoutOverviewPageDisplayed() {

        return getPageTitle()
                .equalsIgnoreCase("Checkout: Overview");
    }

    // ==================================
    // Product Information
    // ==================================

    public int getProductCount() {

        return driver.findElements(cartItems).size();
    }

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

    public String getProductPrice(String productName) {

        List<WebElement> products =
                driver.findElements(cartItems);

        for (WebElement product : products) {

            String name =
                    product.findElement(
                            By.className("inventory_item_name"))
                            .getText();

            if (name.equalsIgnoreCase(productName)) {

                return product.findElement(
                        By.className("inventory_item_price"))
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
                            By.className("inventory_item_name"))
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
    // Payment Information
    // ==================================

    public String getPaymentInformation() {

        return driver.findElement(paymentInfo)
                .getText();
    }

    public String getShippingInformation() {

        return driver.findElement(shippingInfo)
                .getText();
    }

    public String getItemTotal() {

        return driver.findElement(itemTotal)
                .getText();
    }

    public String getTax() {

        return driver.findElement(tax)
                .getText();
    }

    public String getTotal() {

        return driver.findElement(total)
                .getText();
    }

    // ==================================
    // Buttons
    // ==================================

    public void clickFinish() {

        driver.findElement(finishButton)
                .click();
    }

    public void clickCancel() {

        driver.findElement(cancelButton)
                .click();
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