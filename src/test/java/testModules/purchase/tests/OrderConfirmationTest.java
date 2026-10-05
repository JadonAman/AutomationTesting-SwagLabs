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

public class OrderConfirmationTest extends BaseTest {

    @Test
    public void completeOrderAndVerifyConfirmation() {
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
        overviewPage.clickFinish();

        CheckoutCompletePage completePage = new CheckoutCompletePage(driver);
        Assert.assertTrue(completePage.isCheckoutCompletePageDisplayed(),
                "Order completion page should be displayed");
        Assert.assertTrue(completePage.isOrderCompleted(),
                "Order confirmation should be displayed");
        Assert.assertTrue(completePage.getCompleteText().length() > 0,
                "Confirmation details should be displayed");
    }
}