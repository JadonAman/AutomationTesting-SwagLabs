package testModules.user_support.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;

public class CommunityPageTest extends BaseTest {

    @Test
    public void verifyCommunityResourcesPage() throws InterruptedException {

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

        // Open Community Resources Page
        driver.get("https://saucelabs.com/resources/topic-hub/community");

        Thread.sleep(3000);

        // Validation
        Assert.assertTrue(
                driver.getCurrentUrl().contains("community"),
                "Community Resources page not opened");

        System.out.println("Community Resources page verified successfully");
        System.out.println("Current URL : " + driver.getCurrentUrl());
    }
}