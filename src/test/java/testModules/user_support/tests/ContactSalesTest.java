package testModules.user_support.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;

public class ContactSalesTest extends BaseTest {

    @Test
    public void verifyContactSalesPage() throws InterruptedException {

        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory"),
                "Login Failed");

        // Open Menu
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.openMenu();

        Thread.sleep(1000);

        // Click About
        driver.findElement(
                org.openqa.selenium.By.id("about_sidebar_link"))
                .click();

        Thread.sleep(3000);

        System.out.println("Current URL : "
                + driver.getCurrentUrl());

        // Navigate directly to Contact Us page
        driver.get("https://saucelabs.com/contact-us");

        Thread.sleep(3000);

        Assert.assertTrue(
                driver.getCurrentUrl().contains("contact-us"),
                "Contact Us page not opened");

        System.out.println("Successfully navigated to Contact Us page");

    }
}