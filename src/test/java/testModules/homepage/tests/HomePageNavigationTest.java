package testModules.homepage.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;
import utilities.ReportLogger;

public class HomePageNavigationTest extends BaseTest {

    @Test
    public void verifyHomePageNavigation()
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

        Thread.sleep(2000);

        ReportLogger.step("Navigate to All Items page");

        inventoryPage.clickAllItems();

        Thread.sleep(2000);

        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory"),
                "User could not navigate to All Items/Home page"
        );

        ReportLogger.pass(
                "All Items/Home page navigation verified successfully");

        ReportLogger.step("Navigate to Cart page");

        inventoryPage.openCart();

        Thread.sleep(2000);

        Assert.assertTrue(
                driver.getCurrentUrl().contains("cart"),
                "User could not navigate to Cart page"
        );

        ReportLogger.pass(
                "Cart page navigation verified successfully");

        ReportLogger.step("Return to Homepage");

        driver.navigate().back();

        Thread.sleep(2000);

        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory"),
                "User could not return to Homepage"
        );

        ReportLogger.pass(
                "Return to Homepage verified successfully");
    }
}