package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            String timeStamp =
                    new SimpleDateFormat("yyyyMMdd_HHmmss")
                            .format(new Date());

            String reportPath =
                    System.getProperty("user.dir")
                    + "/reports/AutomationReport_"
                    + timeStamp
                    + ".html";

            ExtentSparkReporter spark =
                    new ExtentSparkReporter(reportPath);

            spark.config().setDocumentTitle(
                    "Swag Labs Automation Report");

            spark.config().setReportName(
                    "Automation Testing Execution Report");

            extent = new ExtentReports();

            extent.attachReporter(spark);

            extent.setSystemInfo(
                    "Project",
                    "Swag Labs Automation");

            extent.setSystemInfo(
                    "Framework",
                    "Selenium + TestNG");

            extent.setSystemInfo(
                    "Author",
                    "Aman Jadon");

            extent.setSystemInfo(
                    "Browser",
                    ConfigReader.getProperty("browser"));

            extent.setSystemInfo(
                    "Application",
                    "https://www.saucedemo.com");
        }

        return extent;
    }
}