package reporting;

import interfaces.ConsoleColors;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class LogManager implements ITestListener {
    Logger logger = Logger.getLogger(LogManager.class.getName());
    public void INFO(String message) {
        logger.info(ConsoleColors.BLUE + message + ConsoleColors.RESET);
    }
    public void ERROR(String message) {
        logger.error(ConsoleColors.RED + message + ConsoleColors.RESET);
    }
    public void onTestStart(ITestResult result) {
        System.out.println("***** Test Case " + result.getMethod().getMethodName() + " Start *****");
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println(ConsoleColors.GREEN + "***** Test Case " + result.getMethod().getMethodName() + " Succeed *****" +ConsoleColors.RESET );
    }

    public void onTestFailure(ITestResult result) {
        System.out.println(ConsoleColors.RED +"***** Test Case " + result.getMethod().getMethodName() + " Failed *****"+ConsoleColors.RESET);
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("***** Test Case " + result.getMethod().getMethodName() + " Skipped *****");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("***** Test Case " + result.getMethod().getMethodName() + " Failed ButWithin Success Percentage *****");
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
        System.out.println("***** Test Case " + result.getMethod().getMethodName() + " Failed With Timeout *****");
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("***** Test Suite "+ context.getName() + " Start *****");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("***** Test Suite "+ context.getName() + " End *****" );
    }
}
