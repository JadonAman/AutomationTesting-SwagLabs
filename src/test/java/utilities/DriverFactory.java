package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static WebDriver getDriver(String browser) {

        WebDriver driver = null;

        switch(browser.toLowerCase()) {

        case "chrome":
            driver = new ChromeDriver();
            break;

        case "firefox":
            driver = new FirefoxDriver();
            break;

        default:
            driver = new ChromeDriver();
        }

        return driver;
    }
}