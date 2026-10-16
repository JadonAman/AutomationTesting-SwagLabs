package testModules.user_support.tests;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;
import utilities.ReportLogger;

public class ContactSupportTest extends BaseTest {

    @Test
    public void verifyContactSupportPage() throws InterruptedException {

        ReportLogger.step("Login with valid credentials");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "standard_user",
                "secret_sauce");

        Thread.sleep(1000);

        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory"));

        ReportLogger.pass("Login successful");

        ReportLogger.step("Open application menu");

        InventoryPage inventoryPage =
                new InventoryPage(driver);

        inventoryPage.openMenu();

        Thread.sleep(1000);

        ReportLogger.pass("Menu opened successfully");

        ReportLogger.step("Navigate to Sauce Labs website");

        driver.findElement(
                By.cssSelector(
                        "*[data-test='about-sidebar-link']"))
                .click();

        Thread.sleep(3000);

        ReportLogger.pass("Sauce Labs website opened");

        String parentWindow =
                driver.getWindowHandle();

        ReportLogger.step("Open Support page");

        driver.findElement(
                By.linkText("Support"))
                .click();

        Thread.sleep(3000);

        Set<String> windows =
                driver.getWindowHandles();

        for (String window : windows) {

            if (!window.equals(parentWindow)) {

                driver.switchTo().window(window);
                break;
            }
        }

        Thread.sleep(2000);

        ReportLogger.step("Verify Support page");

        Assert.assertTrue(
                driver.getCurrentUrl()
                        .contains("support"),
                "Support page not opened");

        ReportLogger.pass("Support page verified successfully");
    }
}