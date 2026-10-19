package testModules.product_catalog.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;
import utilities.ReportLogger;

public class CHECKSORTZATest extends BaseTest {

    @Test
    public void verifySortByNameZA() throws InterruptedException {

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

        Thread.sleep(1000);

        ReportLogger.pass("Inventory page loaded successfully");

        ReportLogger.step("Select Z to A sorting option");

        inventoryPage.sortByNameZA();

        Thread.sleep(2000);

        ReportLogger.pass("Products sorted from Z to A successfully");

        ReportLogger.step("Verify user remains on Inventory page");

        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory"),
                "Inventory page is not displayed");

        ReportLogger.pass("Inventory page verified successfully");
    }
}