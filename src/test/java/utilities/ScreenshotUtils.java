package utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

    public static String takeScreenshot(
            WebDriver driver,
            String testName) {

        File src = ((TakesScreenshot)driver)
                .getScreenshotAs(OutputType.FILE);

        String path =
                System.getProperty("user.dir")
                + File.separator
                + "Screenshots"
                + File.separator
                + testName
                + ".png";

        try {

            Files.copy(
                    src.toPath(),
                    new File(path).toPath(),
                    StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {

            e.printStackTrace();
        }

        return path;
    }
}