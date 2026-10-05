package testModules.user_support.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;

public class GeneralEnquiriesTest extends BaseTest {

    @Test
    public void verifyGeneralEnquiriesEmail() throws InterruptedException {

        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory"),
                "Login Failed");

        // Open menu
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.openMenu();

        Thread.sleep(1000);

        // Click About
        driver.findElement(By.id("about_sidebar_link")).click();

        Thread.sleep(3000);

        // Navigate directly to Contact Us page
        driver.get("https://saucelabs.com/contact-us");

        Thread.sleep(3000);

        // Verify page opened
        Assert.assertTrue(
                driver.getCurrentUrl().contains("contact-us"),
                "Contact Us page not opened");

        // Verify General Enquiries email
        WebElement enquiriesEmail = driver.findElement(
                By.xpath("//*[contains(text(),'inquiries@saucelabs.com')]"));

        Assert.assertTrue(
                enquiriesEmail.isDisplayed(),
                "inquiries@saucelabs.com is not displayed");

        System.out.println(
                "Verified General Enquiries Email : inquiries@saucelabs.com");
    }
}