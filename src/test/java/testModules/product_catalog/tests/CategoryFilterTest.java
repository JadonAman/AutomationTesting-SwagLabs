package testModules.product_catalog.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;
import utilities.ReportLogger;

public class CategoryFilterTest extends BaseTest {

    @Test
    public void verifyCategoryFilter() throws InterruptedException {

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

        ReportLogger.pass("Inventory page loaded successfully");

        ReportLogger.step("Verify Category Filter availability");

        By categoryFilter =
                By.id("category-filter");

        // Intentional Failure for Reporting Demo
        Assert.assertTrue(
                driver.findElements(categoryFilter).size() > 0,
                "Intentional Failure - Category Filter should not be available");

        ReportLogger.pass(
                "Category Filter verified successfully");
    }
}