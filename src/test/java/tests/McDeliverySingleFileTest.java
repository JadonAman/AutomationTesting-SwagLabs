package tests;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class McDeliverySingleFileTest {

    @Test
    public void verifyMcDeliveryCartFlow() {

        WebDriver driver = null;

        try {
            // Setup Chrome Driver binaries
            WebDriverManager.chromedriver().setup();

            // Configure Chrome Options to block browser location popup completely
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-geolocation");

            Map<String, Object> prefs = new HashMap<>();
            prefs.put("profile.default_content_setting_values.geolocation", 2);
            options.setExperimentalOption("prefs", prefs);

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            JavascriptExecutor js = (JavascriptExecutor) driver;

            // Open Website
            driver.get("https://mcdelivery.co.in");
            System.out.println("Website Opened Successfully.");

            // Reduced Initial Load Buffer (First 5 seconds)
            System.out.println("Waiting 5 seconds for initial layout stabilization...");
            Thread.sleep(5000);

            // Additional Load Buffer (Second 5 seconds)
            System.out.println("Waiting an additional 5 seconds for full landing page load...");
            Thread.sleep(5000);

            // =====================================================
            // PAGE SCROLL FOR LAZY-LOADED ITEMS
            // =====================================================
            System.out.println("Executing page scroll view adjustments...");
            js.executeScript("window.scrollBy({top: 400, behavior: 'smooth'});");
            Thread.sleep(2000); // Allow scrolling animations to settle smoothly

            // =====================================================
            // STEP 1 : CLICK ADD BUTTON FOR SPICY PATAKHA CHICKEN MEAL (M)
            // =====================================================
            WebElement addButton = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath(
                                    "//h4[contains(text(),'Spicy Patakha Chicken Meal (M)')]" +
                                    "/ancestor::div[contains(@class,'menu')]" +
                                    "//div[contains(@class,'add-to-cart__cta-btn-full')] | " +
                                    "//h4[contains(text(),'Spicy Patakha Chicken Meal (M)')]" +
                                    "/ancestor::div[contains(@class,'menu')]//div[contains(text(),'Add')]")));

            try {
                addButton.click();
            } catch (Exception e) {
                js.executeScript("arguments[0].click();", addButton); // Fixed JS argument selector index
            }

            System.out.println("Clicked Add button for Spicy Patakha Chicken Meal (M)");
            Thread.sleep(3000);

            // =====================================================
            // STEP 2 : CLICK ADD TO CART
            // =====================================================
            WebElement addToCartButton = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath(
                                    "//button[contains(.,'Add to Cart')] | " +
                                    "//span[contains(.,'Add to Cart')]/ancestor::button | " +
                                    "//div[contains(.,'Add to Cart')]")));

            try {
                addToCartButton.click();
            } catch (Exception e) {
                js.executeScript("arguments[0].click();", addToCartButton); // Fixed JS argument selector index
            }

            System.out.println("Clicked Add To Cart");
            Thread.sleep(3000);

            // =====================================================
            // STEP 3 : OPEN CART
            // =====================================================
            WebElement cartIcon = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath(
                                    "//*[contains(@class,'cart')]//img | " +
                                    "//img[contains(@title,'cart')] | " +
                                    "//a[contains(@href,'cart')]")));

            try {
                cartIcon.click();
            } catch (Exception e) {
                js.executeScript("arguments[0].click();", cartIcon); // Fixed JS argument selector index
            }

            System.out.println("Cart Opened");
            Thread.sleep(3000);

            // =====================================================
            // STEP 4 : VERIFY CART CONTAINER
            // =====================================================
            WebElement orderSummaryCard = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath(
                                    "//div[contains(@class,'cart-page__order-summary-card')] | " +
                                    "//app-order-summary")));

            Assert.assertTrue(
                    orderSummaryCard.isDisplayed(),
                    "Order Summary Card Not Displayed");

            System.out.println("Cart Container Verified");

            // =====================================================
            // STEP 5 : PRODUCT NAME
            // =====================================================
            WebElement productNameElement = orderSummaryCard.findElement(
                    By.xpath(
                            ".//h4[contains(@class,'menu__title')]"));

            String productName = productNameElement.getText().trim();

            // =====================================================
            // STEP 6 : QUANTITY
            // =====================================================
            WebElement quantityElement = orderSummaryCard.findElement(
                    By.xpath(
                            ".//*[contains(@class,'add-to-cart__count')]"));

            String quantity = quantityElement.getText().trim();

            // =====================================================
            // STEP 7 : TOTAL AMOUNT
            // =====================================================
            WebElement totalAmountElement = orderSummaryCard.findElement(
                    By.xpath(
                            ".//span[contains(@class,'menu__price')]"));

            String totalAmount = totalAmountElement.getText().trim();

            // =====================================================
            // VALIDATIONS
            // =====================================================
            Assert.assertTrue(
                    productName.length() > 0,
                    "Product Name Not Found");

            Assert.assertTrue(
                    quantity.length() > 0,
                    "Quantity Not Found");

            Assert.assertTrue(
                    totalAmount.contains("₹"),
                    "Amount Not Found");

            // =====================================================
            // FINAL REPORT
            // =====================================================
            System.out.println("\n=======================================================");
            System.out.println("             MCDELIVERY TEST ORDER MATRIX             ");
            System.out.println("=======================================================");
            System.out.println(" VALIDATED ITEM ID       : " + productName);
            System.out.println(" QUANTITY IN BASKET      : " + quantity);
            System.out.println(" FINAL PAYABLE AGGREGATE : " + totalAmount);
            System.out.println("=======================================================\n");

            System.out.println("TEST EXECUTION COMPLETED: ALL FLOW CRITERIA PASSED.");

        } catch (Exception e) {

            System.err.println("CRITICAL FAILURE INTERCEPTED DURING EXECUTION TIMELINE:");
            e.printStackTrace();

            Assert.fail(
                    "Automation Engine Execution Failure Context Exception: "
                            + e.getMessage());

        } finally { // Fixed spelling error

            if (driver != null) {
                driver.quit();
                System.out.println("Browser context safely destroyed, execution cycle closed.");
            }
        }
    }
}
