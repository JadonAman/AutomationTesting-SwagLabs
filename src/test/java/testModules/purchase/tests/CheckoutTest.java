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

public class CheckoutTest extends BaseTest {

    @Test
    public void verifyCheckoutRequiresShippingInformation() {

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

        ReportLogger.step("Attempt checkout without shipping information");

        CheckoutInformationPage informationPage =
                new CheckoutInformationPage(driver);

        informationPage.clickContinue();

        ReportLogger.pass("Continue button clicked");

        ReportLogger.step("Verify shipping information validation");

        Assert.assertTrue(
                informationPage.getErrorMessage()
                        .contains("First Name is required"),
                "Checkout should require shipping information");

        Assert.assertTrue(
                informationPage.isCheckoutInformationPageDisplayed(),
                "Page should remain on checkout information");

        ReportLogger.pass(
                "Shipping information validation verified successfully");
    }

    @Test
    public void enterShippingInformationAndReviewOrder() {

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

        ReportLogger.step("Verify order overview page");

        CheckoutOverviewPage overviewPage =
                new CheckoutOverviewPage(driver);

        Assert.assertTrue(
                overviewPage.isCheckoutOverviewPageDisplayed(),
                "Order overview should be displayed");

        ReportLogger.pass("Order overview page displayed");

        ReportLogger.step("Verify selected product in order review");

        Assert.assertTrue(
                overviewPage.isProductPresent(
                        "Sauce Labs Backpack"),
                "Selected product should be in the order review");

        ReportLogger.pass("Selected product verified successfully");

        ReportLogger.step("Verify shipping information");

        Assert.assertTrue(
                overviewPage.getShippingInformation().length() > 0,
                "Shipping method should be displayed");

        ReportLogger.pass(
                "Shipping information displayed successfully");
    }
}