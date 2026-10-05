package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutUsPage {

    private WebDriver driver;

    public AboutUsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Contact Us / Contact Sales link
    private By contactUsBtn =
            By.xpath("//a[contains(@href,'contact-us')]");

    public void clickContactUs() {
        driver.findElement(contactUsBtn).click();
    }

    public boolean isContactUsLinkDisplayed() {
        return driver.findElement(contactUsBtn).isDisplayed();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}