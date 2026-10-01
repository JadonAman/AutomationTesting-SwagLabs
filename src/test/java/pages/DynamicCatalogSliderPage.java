package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DynamicCatalogSliderPage {

    private WebDriver driver;

    // Page Title
    private By pageTitle =
            By.cssSelector("[data-test='title']");

    // Product Details
    private By productImage =
            By.cssSelector("[data-test='dynamic-catalog-slider-item-img']");

    private By productName =
            By.cssSelector("[data-test='dynamic-catalog-slider-item-name']");

    private By productPrice =
            By.cssSelector("[data-test='dynamic-catalog-slider-item-price']");

    // Slider Dots
    private By sliderDots =
            By.cssSelector("[data-test^='dynamic-catalog-slider-dot-']");

    // Menu
    private By menuButton =
            By.id("react-burger-menu-btn");

    private By logoutLink =
            By.id("logout_sidebar_link");

    private By resetAppStateLink =
            By.id("reset_sidebar_link");

    public DynamicCatalogSliderPage(WebDriver driver) {
        this.driver = driver;
    }

    // ==========================
    // Page Validation
    // ==========================

    public String getPageTitle() {

        return driver.findElement(pageTitle)
                .getText();
    }

    public boolean isSliderPageDisplayed() {

        return getPageTitle()
                .equalsIgnoreCase("Dynamic Catalog - Slider");
    }

    // ==========================
    // Product Information
    // ==========================

    public String getProductName() {

        return driver.findElement(productName)
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

    // ==========================
    // Slider Operations
    // ==========================

    public int getSliderCount() {

        return driver.findElements(sliderDots)
                .size();
    }

    public void selectSlider(int index) {

        List<WebElement> dots =
                driver.findElements(sliderDots);

        dots.get(index).click();
    }

    public void selectFirstProduct() {

        selectSlider(0);
    }

    public void selectSecondProduct() {

        selectSlider(1);
    }

    public void selectThirdProduct() {

        selectSlider(2);
    }

    // ==========================
    // Verification
    // ==========================

    public boolean verifyProductName(
            String expectedProduct) {

        return getProductName()
                .equalsIgnoreCase(expectedProduct);
    }

    public boolean verifyProductPrice(
            String expectedPrice) {

        return getProductPrice()
                .equals(expectedPrice);
    }

    // ==========================
    // Menu Operations
    // ==========================

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