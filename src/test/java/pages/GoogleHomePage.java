package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleHomePage {

    private WebDriver driver;

    private By searchBox = By.name("q");

    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterSearchText(String text) {
        driver.findElement(searchBox).sendKeys(text);
    }

    public void search(String text) {

        driver.findElement(searchBox).sendKeys(text);
        driver.findElement(searchBox).submit();
    }
}