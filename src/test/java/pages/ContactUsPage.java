package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage {

    private WebDriver driver;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locator
    private By contactSalesLink =
            By.xpath("//a[@href='https://saucelabs.com/contact-us']");

    // Action Method
    public void clickContactSalesLink() {
        driver.findElement(contactSalesLink).click();
    }

    // Validation
    public boolean isContactSalesLinkDisplayed() {
        return driver.findElement(contactSalesLink).isDisplayed();
    }
}