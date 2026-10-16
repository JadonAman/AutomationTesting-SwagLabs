package testModules.purchase.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import constants.Products;
import pages.CartPage;
import pages.CheckoutInformationPage;
import pages.CheckoutOverviewPage;
import pages.InventoryPage;
import pages.LoginPage;
import utilities.ReportLogger;

public class PaymentTest extends BaseTest {

    @Test
    public void verifyPaymentMethodOnOrderReview() {

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

        ReportLogger.step("Navigate to order review page");

        CheckoutOverviewPage overviewPage =
                new CheckoutOverviewPage(driver);

        ReportLogger.pass("Order review page opened successfully");

        ReportLogger.step("Verify payment method information");

        Assert.assertTrue(
                overviewPage.getPaymentInformation()
                        .contains("SauceCard"),
                "Payment method should be shown in the order review");

        ReportLogger.pass(
                "Payment method verified successfully: SauceCard");
    }
}