package testModules.product_catalog.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;
import utilities.ReportLogger;

public class ProductNameSearchTest extends BaseTest {

    @Test
    public void verifyProductNameSearch()
            throws InterruptedException {

        ReportLogger.step("Login with valid credentials");

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                "standard_user",
                "secret_sauce");

        Assert.assertTrue(
                driver.getCurrentUrl()
                        .contains("inventory"),
                "Login Failed");

        ReportLogger.pass("Login successful");

        ReportLogger.step("Open Inventory page");

        InventoryPage inventoryPage =
                new InventoryPage(driver);

        Thread.sleep(2000);

        ReportLogger.pass(
                "Inventory page loaded successfully");

        ReportLogger.step("Verify Product Name Search availability");

        By productSearch =
                By.id("search");

        Assert.assertTrue(
                driver.findElements(productSearch)
                        .size() > 0,
                "Intentional Failure - Product Name Search should not be available");

        ReportLogger.pass(
                "Product Name Search verified successfully");
    }
}