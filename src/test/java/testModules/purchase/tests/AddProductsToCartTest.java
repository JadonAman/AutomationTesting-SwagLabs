package testModules.purchase.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import constants.Products;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;
import utilities.ReportLogger;

public class AddProductsToCartTest extends BaseTest {

    @Test
    public void verifySingleProductCanBeAddedToCart() {

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

        ReportLogger.pass("Backpack product added successfully");

        ReportLogger.step("Verify cart count");

        Assert.assertEquals(
                inventoryPage.getCartCount(),
                "1",
                "Cart should contain one product");

        ReportLogger.pass("Cart count verified");

        ReportLogger.step("Open cart page");

        inventoryPage.openCart();

        CartPage cartPage = new CartPage(driver);

        Assert.assertTrue(
                cartPage.isCartPageDisplayed(),
                "Cart page should be displayed");

        ReportLogger.pass("Cart page opened successfully");

        ReportLogger.step("Verify Backpack product details");

        Assert.assertTrue(
                cartPage.isProductPresent("Sauce Labs Backpack"),
                "Backpack should be present in the cart");

        Assert.assertEquals(
                cartPage.getProductQuantity("Sauce Labs Backpack"),
                "1",
                "Product quantity should be one");

        Assert.assertNotNull(
                cartPage.getProductPrice("Sauce Labs Backpack"),
                "Product price should be displayed");

        ReportLogger.pass("Backpack product details verified successfully");
    }

    @Test
    public void verifyMultipleProductsCanBeAddedToCart() {

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

        ReportLogger.pass("Backpack product added");

        ReportLogger.step("Add Bike Light product to cart");

        inventoryPage.addProductToCart(Products.BIKE_LIGHT);

        ReportLogger.pass("Bike Light product added");

        ReportLogger.step("Verify cart count");

        Assert.assertEquals(
                inventoryPage.getCartCount(),
                "2",
                "Cart should contain two products");

        ReportLogger.pass("Cart count verified");

        ReportLogger.step("Open cart page");

        inventoryPage.openCart();

        CartPage cartPage = new CartPage(driver);

        ReportLogger.pass("Cart page opened successfully");

        ReportLogger.step("Verify both products are present in cart");

        Assert.assertEquals(
                cartPage.getCartItemCount(),
                2,
                "Both products should be displayed in the cart");

        Assert.assertTrue(
                cartPage.isProductPresent("Sauce Labs Backpack"),
                "Backpack should be present in cart");

        Assert.assertTrue(
                cartPage.isProductPresent("Sauce Labs Bike Light"),
                "Bike Light should be present in cart");

        ReportLogger.pass("Both products verified successfully");
    }
}