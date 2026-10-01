package utilities;

import org.openqa.selenium.WebElement;

public class CommonMethods {

    public static void click(WebElement element) {

        element.click();
    }

    public static void enterText(
            WebElement element,
            String value) {

        element.clear();
        element.sendKeys(value);
    }

    public static String getText(WebElement element) {

        return element.getText();
    }
}