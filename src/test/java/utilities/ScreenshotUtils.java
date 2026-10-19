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
            String testName,
            String status) {

        File src = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        String folderPath =
                System.getProperty("user.dir")
                + File.separator
                + "Screenshots"
                + File.separator
                + status;

        File folder = new File(folderPath);

        if (!folder.exists()) {

            folder.mkdirs();
        }

        String fileName =
                testName
                + "_"
                + System.currentTimeMillis()
                + ".png";

        String path =
                folderPath
                + File.separator
                + fileName;

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