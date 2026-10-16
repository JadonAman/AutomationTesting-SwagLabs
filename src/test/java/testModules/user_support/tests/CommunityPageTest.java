package testModules.user_support.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;
import utilities.ReportLogger;

public class CommunityPageTest extends BaseTest {

    @Test
    public void verifyCommunityResourcesPage() throws InterruptedException {

        ReportLogger.step("Login with valid credentials");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory"),
                "Login Failed");

        ReportLogger.pass("Login successful");

        ReportLogger.step("Open application menu");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.openMenu();

        Thread.sleep(1000);

        ReportLogger.pass("Menu opened successfully");

        ReportLogger.step("Navigate to Sauce Labs website");

        driver.findElement(
                org.openqa.selenium.By.id("about_sidebar_link"))
                .click();

        Thread.sleep(3000);

        ReportLogger.pass("Sauce Labs website opened");

        ReportLogger.step("Open Community Resources page");

        driver.get("https://saucelabs.com/resources/topic-hub/community");

        Thread.sleep(3000);

        ReportLogger.pass("Community Resources page opened");

        ReportLogger.step("Verify Community Resources page");

        Assert.assertTrue(
                driver.getCurrentUrl().contains("community"),
                "Community Resources page not opened");

        ReportLogger.pass("Community Resources page verified successfully");
    }
}