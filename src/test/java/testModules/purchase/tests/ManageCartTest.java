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

public class ManageCartTest extends BaseTest {

    @Test
    public void removeProductAndVerifyCartTotal() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"),
                "Login Failed");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addProductToCart(Products.BACKPACK);
        inventoryPage.addProductToCart(Products.BIKE_LIGHT);
        inventoryPage.openCart();

        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.getCartItemCount(), 2,
                "Cart should contain two products");

        String backpackPrice = cartPage.getProductPrice("Sauce Labs Backpack");
        cartPage.removeProduct(Products.BIKE_LIGHT);

        Assert.assertEquals(cartPage.getCartItemCount(), 1,
                "Cart should contain one product after removal");
        Assert.assertEquals(cartPage.getCartBadgeCount(), "1",
                "Cart badge should update after removal");
        Assert.assertTrue(cartPage.isProductPresent("Sauce Labs Backpack"));

        cartPage.clickCheckout();
        CheckoutInformationPage informationPage = new CheckoutInformationPage(driver);
        informationPage.continueCheckout("Alex", "Tester", "12345");

        CheckoutOverviewPage overviewPage = new CheckoutOverviewPage(driver);
        Assert.assertEquals(overviewPage.getProductCount(), 1,
                "Order should contain the remaining product");
        Assert.assertTrue(overviewPage.getItemTotal().contains(backpackPrice),
                "Subtotal should match the remaining product price");
        Assert.assertTrue(overviewPage.getTotal().contains("$32.39"),
                "Order total should be displayed");
    }
}