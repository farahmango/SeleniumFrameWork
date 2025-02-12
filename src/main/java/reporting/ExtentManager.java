package reporting;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import interfaces.FilesPath;
import utils.DateUtils;


public class ExtentManager {


    private static ExtentReports extent;

    public static ExtentReports createInstance() {
        String dateFormatter = DateUtils.dateFormatter(DateUtils.getTheCurrentDate(), "dd-MMM-YYYY");
        String timeFormatter = DateUtils.timeFormatter(DateUtils.getTheCurrentTime(), "hh-mm-ss-a");
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(FilesPath.reportsFilePath + "ExtentReport-" + dateFormatter + " at " + timeFormatter + ".html");

        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("Selenium Framework");
        htmlReporter.config().setEncoding(" UTF-8");
        htmlReporter.config().setReportName("Selenium Framework");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Operating System", System.getProperty("os.name"));
        extent.setSystemInfo("Operating System Version", System.getProperty("os.version"));
        extent.setSystemInfo("Run User", System.getProperty("user.name"));
        extent.setSystemInfo("Java runtime", System.getProperty("java.runtime.version"));

        extent.setAnalysisStrategy(AnalysisStrategy.TEST);

        return extent;
    }


}
