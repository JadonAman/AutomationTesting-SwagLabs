package utilities;

public class ReportLogger {

    private static int stepNumber = 1;

    public static void resetSteps() {
        stepNumber = 1;
    }

    public static void step(String message) {

        ExtentTestManager.getTest()
                .info("STEP " + stepNumber++ + " : " + message);
    }

    public static void pass(String message) {

        ExtentTestManager.getTest()
                .pass(message);
    }

    public static void fail(String message) {

        ExtentTestManager.getTest()
                .fail(message);
    }
}