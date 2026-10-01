package testModules.homepage.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.GoogleHomePage;

public class GoogleSearchTest extends BaseTest {

    @Test
    public void verifyGoogleSearch() {

        GoogleHomePage googleHomePage =
                new GoogleHomePage(driver);

        googleHomePage.search("Selenium WebDriver");

        Assert.assertTrue(
                driver.getTitle()
                        .contains("Selenium WebDriver"),
                "Search result page not displayed");
    }
}