package testModules.purchase.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import constants.Products;
import pages.CartPage;
import pages.CheckoutCompletePage;
import pages.CheckoutInformationPage;
import pages.CheckoutOverviewPage;
import pages.InventoryPage;
import pages.LoginPage;
import utilities.ReportLogger;

public class OrderConfirmationTest extends BaseTest {

    @Test
    public void completeOrderAndVerifyConfirmation() {

        ReportLogger.step("Login with valid credentials");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory"),
                "Login Failed");

        ReportLogger.pass("Login successful");

        ReportLogger.step("Add Backpack product to cart");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addProductToCart(Products.BACKPACK);

        ReportLogger.pass("Product added successfully");

        ReportLogger.step("Open cart page");

        inventoryPage.openCart();

        CartPage cartPage = new CartPage(driver);

        ReportLogger.pass("Cart page opened successfully");

        ReportLogger.step("Proceed to checkout");

        cartPage.clickCheckout();

        ReportLogger.pass("Checkout information page opened");

        ReportLogger.step("Enter shipping information");

        CheckoutInformationPage informationPage =
                new CheckoutInformationPage(driver);

        informationPage.continueCheckout(
                "Alex",
                "Tester",
                "12345");

        ReportLogger.pass("Shipping information entered successfully");

        ReportLogger.step("Verify checkout overview page");

        CheckoutOverviewPage overviewPage =
                new CheckoutOverviewPage(driver);

        Assert.assertTrue(
                overviewPage.isCheckoutOverviewPageDisplayed(),
                "Order overview should be displayed");

        ReportLogger.pass("Order overview page verified");

        ReportLogger.step("Complete order");

        overviewPage.clickFinish();

        ReportLogger.pass("Finish button clicked successfully");

        ReportLogger.step("Verify order completion page");

        CheckoutCompletePage completePage =
                new CheckoutCompletePage(driver);

        Assert.assertTrue(
                completePage.isCheckoutCompletePageDisplayed(),
                "Order completion page should be displayed");

        ReportLogger.pass("Order completion page displayed");

        ReportLogger.step("Verify order confirmation");

        Assert.assertTrue(
                completePage.isOrderCompleted(),
                "Order confirmation should be displayed");

        Assert.assertTrue(
                completePage.getCompleteText().length() > 0,
                "Confirmation details should be displayed");

        ReportLogger.pass("Order confirmed successfully");
    }
}