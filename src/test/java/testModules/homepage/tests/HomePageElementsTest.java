package testModules.homepage.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;

public class HomePageElementsTest extends BaseTest {

    @Test
    public void verifyHomePageMainElements()
            throws InterruptedException {

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

        InventoryPage inventoryPage =
                new InventoryPage(driver);

        Assert.assertEquals(
                inventoryPage.getPageTitle(),
                "Products",
                "Homepage title is incorrect"
        );

        Assert.assertEquals(
                inventoryPage.getLogoText(),
                "Swag Labs",
                "Swag Labs logo is not displayed correctly"
        );

        Assert.assertTrue(
                inventoryPage.isMenuDisplayed(),
                "Menu button is not displayed"
        );

        Assert.assertTrue(
                inventoryPage.isCartDisplayed(),
                "Shopping cart is not displayed"
        );

        Assert.assertTrue(
                inventoryPage.isSortDisplayed(),
                "Product sorting dropdown is not displayed"
        );

        Assert.assertTrue(
                inventoryPage.getProductCount() > 0,
                "No products are displayed on Homepage"
        );

        System.out.println(
                "Homepage main elements verified successfully"
        );

        System.out.println(
                "Product count : "
                        + inventoryPage.getProductCount()
        );
    }
}