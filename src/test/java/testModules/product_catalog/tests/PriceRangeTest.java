package testModules.product_catalog.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;
import utilities.ReportLogger;

public class PriceRangeTest extends BaseTest {

    @Test
    public void verifyPriceRangeFilter() throws InterruptedException {

        ReportLogger.step("Login with valid credentials");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "standard_user",
                "secret_sauce");

        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory"),
                "Login Failed");

        ReportLogger.pass("Login successful");

        ReportLogger.step("Open Inventory page");

        InventoryPage inventoryPage =
                new InventoryPage(driver);

        Thread.sleep(2000);

        ReportLogger.pass(
                "Inventory page loaded successfully");

        ReportLogger.step("Verify Price Range Filter availability");

        By priceRangeFilter =
                By.id("price-range-filter");

        Assert.assertTrue(
                driver.findElements(priceRangeFilter).size() > 0,
                "Price Range Filter is not available on Inventory Page");

        ReportLogger.pass(
                "Price Range Filter verified successfully");
    }
}