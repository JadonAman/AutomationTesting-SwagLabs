package testModules.user_support.tests;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;

public class ContactSupportTest extends BaseTest {

    @Test
    public void verifyContactSupportPage() throws InterruptedException {

        // Login
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "standard_user",
                "secret_sauce"
        );

        Thread.sleep(1000);

        // Verify Inventory Page
        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory")
        );

        InventoryPage inventoryPage =
                new InventoryPage(driver);

        // Same flow as Selenium IDE
        inventoryPage.openMenu();

        Thread.sleep(1000);

        driver.findElement(
                By.cssSelector(
                        "*[data-test='about-sidebar-link']"))
                .click();

        Thread.sleep(3000);

        // Store parent window
        String parentWindow =
                driver.getWindowHandle();

        driver.findElement(
                By.linkText("Support"))
                .click();

        Thread.sleep(3000);

        // Switch to new tab
        Set<String> windows =
                driver.getWindowHandles();

        for (String window : windows) {

            if (!window.equals(parentWindow)) {

                driver.switchTo().window(window);
                break;
            }
        }

        Thread.sleep(2000);

        // Verify Support page
        Assert.assertTrue(
                driver.getCurrentUrl()
                        .contains("support"),
                "Support page not opened"
        );

        System.out.println(
                "Support URL : "
                + driver.getCurrentUrl());
    }
}