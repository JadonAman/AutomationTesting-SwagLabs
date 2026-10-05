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

public class CheckoutTest extends BaseTest {

    @Test
    public void verifyCheckoutRequiresShippingInformation() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"),
                "Login Failed");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addProductToCart(Products.BACKPACK);
        inventoryPage.openCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();

        CheckoutInformationPage informationPage = new CheckoutInformationPage(driver);
        informationPage.clickContinue();

        Assert.assertTrue(informationPage.getErrorMessage()
                .contains("First Name is required"),
                "Checkout should require shipping information");
        Assert.assertTrue(informationPage.isCheckoutInformationPageDisplayed(),
                "Page should remain on checkout information");
    }

    @Test
    public void enterShippingInformationAndReviewOrder() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"),
                "Login Failed");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addProductToCart(Products.BACKPACK);
        inventoryPage.openCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();

        CheckoutInformationPage informationPage = new CheckoutInformationPage(driver);
        informationPage.continueCheckout("Alex", "Tester", "12345");

        CheckoutOverviewPage overviewPage = new CheckoutOverviewPage(driver);
        Assert.assertTrue(overviewPage.isCheckoutOverviewPageDisplayed(),
                "Order overview should be displayed");
        Assert.assertTrue(overviewPage.isProductPresent("Sauce Labs Backpack"),
                "Selected product should be in the order review");
        Assert.assertTrue(overviewPage.getShippingInformation().length() > 0,
                "Shipping method should be displayed");
    }
}