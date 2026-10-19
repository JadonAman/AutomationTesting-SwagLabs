package testModules.homepage.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;
import utilities.ReportLogger;

public class HomePageElementsTest extends BaseTest {

    @Test
    public void verifyHomePageMainElements()
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

        InventoryPage inventoryPage =
                new InventoryPage(driver);

        ReportLogger.step("Verify Products page title");

        Assert.assertEquals(
                inventoryPage.getPageTitle(),
                "Products",
                "Homepage title is incorrect"
        );

        ReportLogger.pass("Products page title verified successfully");

        ReportLogger.step("Verify Swag Labs logo");

        Assert.assertEquals(
                inventoryPage.getLogoText(),
                "Swag Labs",
                "Swag Labs logo is not displayed correctly"
        );

        ReportLogger.pass("Swag Labs logo verified successfully");

        ReportLogger.step("Verify menu button");

        Assert.assertTrue(
                inventoryPage.isMenuDisplayed(),
                "Menu button is not displayed"
        );

        ReportLogger.pass("Menu button verified successfully");

        ReportLogger.step("Verify shopping cart icon");

        Assert.assertTrue(
                inventoryPage.isCartDisplayed(),
                "Shopping cart is not displayed"
        );

        ReportLogger.pass("Shopping cart verified successfully");

        ReportLogger.step("Verify product sorting dropdown");

        Assert.assertTrue(
                inventoryPage.isSortDisplayed(),
                "Product sorting dropdown is not displayed"
        );

        ReportLogger.pass("Product sorting dropdown verified successfully");

        ReportLogger.step("Verify products are displayed");

        Assert.assertTrue(
                inventoryPage.getProductCount() > 0,
                "No products are displayed on Homepage"
        );

        ReportLogger.pass(
                "Products displayed successfully. Total products: "
                        + inventoryPage.getProductCount());
    }
}