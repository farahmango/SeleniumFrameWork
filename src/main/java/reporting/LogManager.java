package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import interfaces.ConsoleColors;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.FileUtils;

public class LogManager implements ITestListener {
    static Logger logger = Logger.getLogger(LogManager.class.getName());
    private static ExtentReports extent = ExtentManager.createInstance();

    public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<>();

    public static String customHtml() {
        String anchorTag = "<a href='data:image/png;base64," + FileUtils.encodeFileToBase64Binary() + "'" + " data-featherlight='image' >";
        String customHtml = "<td>" +
                anchorTag +
                "<i class='fa fa-camera' style='cursor:pointer; font-size:24px; color:blue;'> </i>" + "</a>" + " </td>";
        return customHtml;
    }

    public static void INFO(String message) {
        logger.info(ConsoleColors.BLUE + message + ConsoleColors.RESET);
        testReport.get().log(Status.INFO, message + customHtml());
    }

    public static void ERROR(String message) {
        logger.error(ConsoleColors.RED + message + ConsoleColors.RESET);
        testReport.get().log(Status.FAIL, message + customHtml());
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("***** Test Case " + result.getMethod().getMethodName() + " Start *****");
        ExtentTest test = extent.createTest("Class: " + result.getTestClass().getName() + " @ TestCase: " + result.getMethod().getMethodName());
        testReport.set(test);
        testReport.set(testReport.get().assignCategory(result.getTestClass().getName() + "  Class"));
        testReport.set(testReport.get().createNode(result.getMethod().getMethodName()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(ConsoleColors.GREEN + "***** Test Case " + result.getMethod().getMethodName() + " Succeed *****" + ConsoleColors.RESET);
        String logText = "Test case " + result.getMethod().getMethodName() + " Passed";
        Markup markup = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
        testReport.get().pass(markup);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(ConsoleColors.RED + "***** Test Case " + result.getMethod().getMethodName() + " Failed *****" + ConsoleColors.RESET);
        String logText = "Test case " + result.getMethod().getMethodName() + " Failed";
        Markup markup = MarkupHelper.createLabel(logText, ExtentColor.RED);
        testReport.get().log(Status.FAIL, markup);

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("***** Test Case " + result.getMethod().getMethodName() + " Skipped *****");
        String logText = result.getMethod().getMethodName();
        Markup markup = MarkupHelper.createLabel(logText, ExtentColor.ORANGE);
        testReport.get().log(Status.SKIP, markup);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("***** Test Case " + result.getMethod().getMethodName() + " Failed ButWithin Success Percentage *****");
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
        System.out.println("***** Test Case " + result.getMethod().getMethodName() + " Failed With Timeout *****");
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("***** Test Suite " + context.getName() + " Start *****");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("***** Test Suite " + context.getName() + " End *****");
        if (extent != null) {
            extent.flush();
        }
    }
}
