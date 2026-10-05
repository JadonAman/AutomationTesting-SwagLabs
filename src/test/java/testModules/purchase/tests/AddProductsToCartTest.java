package testModules.purchase.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import constants.Products;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;

public class AddProductsToCartTest extends BaseTest {

    @Test
    public void verifySingleProductCanBeAddedToCart() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"),
                "Login Failed");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addProductToCart(Products.BACKPACK);

        Assert.assertEquals(inventoryPage.getCartCount(), "1",
                "Cart should contain one product");

        inventoryPage.openCart();
        CartPage cartPage = new CartPage(driver);

        Assert.assertTrue(cartPage.isCartPageDisplayed(),
                "Cart page should be displayed");
        Assert.assertTrue(cartPage.isProductPresent("Sauce Labs Backpack"),
                "Backpack should be present in the cart");
        Assert.assertEquals(cartPage.getProductQuantity("Sauce Labs Backpack"), "1",
                "Product quantity should be one");
        Assert.assertNotNull(cartPage.getProductPrice("Sauce Labs Backpack"),
                "Product price should be displayed");
    }

    @Test
    public void verifyMultipleProductsCanBeAddedToCart() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"),
                "Login Failed");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addProductToCart(Products.BACKPACK);
        inventoryPage.addProductToCart(Products.BIKE_LIGHT);

        Assert.assertEquals(inventoryPage.getCartCount(), "2",
                "Cart should contain two products");

        inventoryPage.openCart();
        CartPage cartPage = new CartPage(driver);

        Assert.assertEquals(cartPage.getCartItemCount(), 2,
                "Both products should be displayed in the cart");
        Assert.assertTrue(cartPage.isProductPresent("Sauce Labs Backpack"));
        Assert.assertTrue(cartPage.isProductPresent("Sauce Labs Bike Light"));
    }
}