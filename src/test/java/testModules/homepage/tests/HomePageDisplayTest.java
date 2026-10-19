package testModules.homepage.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;
import utilities.ReportLogger;

public class HomePageDisplayTest extends BaseTest {

    @Test
    public void verifyHomePageDisplayedAfterLogin()
            throws InterruptedException {

        ReportLogger.step("Login with valid credentials");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "standard_user",
                "secret_sauce"
        );

        Thread.sleep(2000);

        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory"),
                "Homepage was not displayed after successful login"
        );

        ReportLogger.pass("Login successful and homepage loaded");

        ReportLogger.step("Verify Products page title");

        InventoryPage inventoryPage =
                new InventoryPage(driver);

        Assert.assertEquals(
                inventoryPage.getPageTitle(),
                "Products",
                "Products title is not displayed"
        );

        ReportLogger.pass("Products page title verified successfully");

        ReportLogger.step("Verify homepage URL");

        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory"),
                "Inventory URL is not displayed"
        );

        ReportLogger.pass(
                "Homepage URL verified successfully : "
                        + driver.getCurrentUrl());
    }
}