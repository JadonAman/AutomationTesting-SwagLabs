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

public class ManageCartTest extends BaseTest {

    @Test
    public void removeProductAndVerifyCartTotal() {

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

        ReportLogger.pass("Backpack added successfully");

        ReportLogger.step("Add Bike Light product to cart");

        inventoryPage.addProductToCart(Products.BIKE_LIGHT);

        ReportLogger.pass("Bike Light added successfully");

        ReportLogger.step("Open cart page");

        inventoryPage.openCart();

        CartPage cartPage = new CartPage(driver);

        ReportLogger.pass("Cart page opened successfully");

        ReportLogger.step("Verify cart contains two products");

        Assert.assertEquals(
                cartPage.getCartItemCount(),
                2,
                "Cart should contain two products");

        ReportLogger.pass("Cart contains two products");

        ReportLogger.step("Capture Backpack product price");

        String backpackPrice =
                cartPage.getProductPrice("Sauce Labs Backpack");

        ReportLogger.pass("Backpack price captured successfully");

        ReportLogger.step("Remove Bike Light product from cart");

        cartPage.removeProduct(Products.BIKE_LIGHT);

        ReportLogger.pass("Bike Light removed successfully");

        ReportLogger.step("Verify cart updates after product removal");

        Assert.assertEquals(
                cartPage.getCartItemCount(),
                1,
                "Cart should contain one product after removal");

        Assert.assertEquals(
                cartPage.getCartBadgeCount(),
                "1",
                "Cart badge should update after removal");

        Assert.assertTrue(
                cartPage.isProductPresent("Sauce Labs Backpack"),
                "Backpack should remain in the cart");

        ReportLogger.pass("Cart updated correctly after removal");

        ReportLogger.step("Proceed to checkout");

        cartPage.clickCheckout();

        CheckoutInformationPage informationPage =
                new CheckoutInformationPage(driver);

        ReportLogger.pass("Checkout information page opened");

        ReportLogger.step("Enter shipping information");

        informationPage.continueCheckout(
                "Alex",
                "Tester",
                "12345");

        ReportLogger.pass("Shipping information entered successfully");

        ReportLogger.step("Verify remaining product in order overview");

        CheckoutOverviewPage overviewPage =
                new CheckoutOverviewPage(driver);

        Assert.assertEquals(
                overviewPage.getProductCount(),
                1,
                "Order should contain the remaining product");

        ReportLogger.pass("Remaining product verified");

        ReportLogger.step("Verify subtotal amount");

        Assert.assertTrue(
                overviewPage.getItemTotal().contains(backpackPrice),
                "Subtotal should match the remaining product price");

        ReportLogger.pass("Subtotal verified successfully");

        ReportLogger.step("Verify final order total");

        Assert.assertTrue(
                overviewPage.getTotal().contains("$32.39"),
                "Order total should be displayed");

        ReportLogger.pass("Final order total verified successfully");
    }
}