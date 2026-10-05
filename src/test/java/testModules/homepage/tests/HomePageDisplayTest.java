package testModules.homepage.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;

public class HomePageDisplayTest extends BaseTest {

    @Test
    public void verifyHomePageDisplayedAfterLogin()
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
                "Products title is not displayed"
        );

        System.out.println(
                "Homepage displayed successfully"
        );

        System.out.println(
                "Current URL : "
                        + driver.getCurrentUrl()
        );
    }
}