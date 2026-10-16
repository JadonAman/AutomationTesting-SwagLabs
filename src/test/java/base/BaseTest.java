package base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utilities.ConfigReader;
import utilities.DriverFactory;
import utilities.ExtentManager;
import utilities.ExtentTestManager;
import utilities.ReportLogger;
import utilities.ScreenshotUtils;

public class BaseTest {

    protected WebDriver driver;

    private static ExtentReports extent;

    @BeforeMethod
    public void setup(ITestResult result) {

        extent = ExtentManager.getInstance();

        driver = DriverFactory.getDriver(
                ConfigReader.getProperty("browser"));

        driver.manage().window().maximize();

        driver.get(
                ConfigReader.getProperty("url"));

        ExtentTest test =
                extent.createTest(
                        result.getMethod().getMethodName());

        String className =
                result.getTestClass()
                        .getName()
                        .toLowerCase();

        if (className.contains("user_support")) {

            test.assignAuthor("Aman Jadon");
            test.assignCategory("User Support");
        }
        else if (className.contains("product_catalog")) {

            test.assignAuthor("Priyanshi Gupta");
            test.assignCategory("Product Catalog");
        }
        else if (className.contains("purchase")) {

            test.assignAuthor("Abhishek");
            test.assignCategory("Purchase");
        }
        else if (className.contains("homepage")) {

            test.assignAuthor("Pramod");
            test.assignCategory("Homepage");
        }
        else if (className.contains("signing_in")) {

            test.assignAuthor("Ashutosh");
            test.assignCategory("Signing In");
        }
        else {

            test.assignAuthor("Automation Team");
            test.assignCategory("General");
        }

        ExtentTestManager.setTest(test);

        ReportLogger.resetSteps();

        ReportLogger.step(
                "Launching browser");

        ReportLogger.pass(
                "Browser launched successfully");

        ReportLogger.step(
                "Navigating to application");

        ReportLogger.pass(
                "Application opened successfully");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        if (result.getStatus()
                == ITestResult.SUCCESS) {

            String screenshotPath =
                    ScreenshotUtils.takeScreenshot(
                            driver,
                            result.getMethod().getMethodName(),
                            "Pass");

            ExtentTestManager.getTest()
                    .pass("Test Passed Successfully");

            try {

                ExtentTestManager.getTest()
                        .addScreenCaptureFromPath(
                                screenshotPath);

            } catch (Exception e) {

                e.printStackTrace();
            }
        }

        else if (result.getStatus()
                == ITestResult.FAILURE) {

            String screenshotPath =
                    ScreenshotUtils.takeScreenshot(
                            driver,
                            result.getMethod().getMethodName(),
                            "Fail");

            ExtentTestManager.getTest()
                    .fail(result.getThrowable());

            try {

                ExtentTestManager.getTest()
                        .addScreenCaptureFromPath(
                                screenshotPath);

            } catch (Exception e) {

                e.printStackTrace();
            }
        }

        else if (result.getStatus()
                == ITestResult.SKIP) {

            ExtentTestManager.getTest()
                    .skip("Test Skipped");
        }

        if (driver != null) {

            driver.quit();
        }

        ExtentTestManager.unload();
    }

    @AfterSuite
    public void flushReport() {

        if (extent != null) {

            extent.flush();
        }
    }
}