package testModules.homepage.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;

public class HomePageNavigationTest extends BaseTest {

    @Test
    public void verifyHomePageNavigation()
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

        // Navigate to All Items / Homepage
        inventoryPage.clickAllItems();

        Thread.sleep(2000);

        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory"),
                "User could not navigate to All Items/Home page"
        );

        System.out.println(
                "All Items/Home navigation verified successfully"
        );

        // Navigate to Cart
        inventoryPage.openCart();

        Thread.sleep(2000);

        Assert.assertTrue(
                driver.getCurrentUrl().contains("cart"),
                "User could not navigate to Cart page"
        );

        System.out.println(
                "Cart navigation verified successfully"
        );

        // Return to Homepage
        driver.navigate().back();

        Thread.sleep(2000);

        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory"),
                "User could not return to Homepage"
        );

        System.out.println(
                "Return to Homepage verified successfully"
        );
    }
}