package pages;

import enums.DriverType;
import interfaces.FilesPath;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import reporting.LogManager;
import utils.FileUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Base {
       public static WebDriver driver ;

    public void setUp() {
        DriverType browser = getTheDriverType();
        boolean isHeadLess = isHeadLess();
        driver = initiateWebDriver(browser, isHeadLess);
        String url = FileUtils.readPropertiesFile(FilesPath.resourcesFilePath + "config.properties", "BaseURL");
        driver.get(url);
    }


    public static WebDriver initiateWebDriver(DriverType browser, boolean isHeadLess) {
        Map<String, Object> prefs = new HashMap<String, Object>();
        //Put this into prefs map to switch off browser notification
        // 0- Default, 1- Allow, 2- Block
        prefs.put("profile.default_content_setting_values.notifications", 2);
        DesiredCapabilities capabilities = new DesiredCapabilities();

        switch (browser) {
            case CHROME:
                //Create chrome options to set this prefs
                ChromeOptions chromeOptions = new ChromeOptions();
                //to disable notification
                chromeOptions.setExperimentalOption("prefs", prefs);
                chromeOptions.addArguments("--disable-extensions");
                chromeOptions.addArguments("--disable-web-security");
                chromeOptions.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
                chromeOptions.addArguments("--incognito");
                chromeOptions.addArguments("--allow-running-insecure-content");
                chromeOptions.addArguments("--ignore-ssl-errors=yes");
                chromeOptions.addArguments("--ignore-certificate-errors");
                chromeOptions.addArguments("--page-load-strategy=none");
                chromeOptions.addArguments("start-maximized");
                if (isHeadLess) {
                    chromeOptions.addArguments("--disable-gpu");
                    chromeOptions.addArguments("--headless");
                    chromeOptions.addArguments("window-size=1920x1080");
                }
                capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                 driver = new ChromeDriver(chromeOptions);
                break;

            case EDGE:
                //Create edge options to set this prefs
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setExperimentalOption("prefs", prefs);
                edgeOptions.addArguments("--disable-web-security");
                edgeOptions.addArguments("--disable-extensions");
                edgeOptions.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
                edgeOptions.addArguments("--allow-running-insecure-content");
                edgeOptions.addArguments("--ignore-ssl-errors=yes");
                edgeOptions.addArguments("--ignore-certificate-errors");
                edgeOptions.addArguments("--page-load-strategy=none");
                edgeOptions.addArguments("start-maximized");
                if (isHeadLess) {
                    edgeOptions.addArguments("--disable-gpu");
                    edgeOptions.addArguments("--headless");
                    edgeOptions.addArguments("window-size=1920x1080");
                }
                capabilities.setCapability(EdgeOptions.CAPABILITY, edgeOptions);
                driver = new EdgeDriver(edgeOptions);
                break;

            case FIREFOX:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--disable-extensions");
                if (isHeadLess) {
                    firefoxOptions.addArguments("--disable-gpu");
                    firefoxOptions.addArguments("--headless");
                    firefoxOptions.addArguments("window-size=1920x1080");
                }
                driver = new FirefoxDriver(firefoxOptions);
                driver.manage().window().maximize();
                break;
        }

        return driver;

    }

    public Boolean isHeadLess() {
        String browserName = FileUtils.readPropertiesFile(FilesPath.resourcesFilePath + "config.properties", "headless");
        return Boolean.valueOf(browserName);
    }

    public DriverType getTheDriverType() {
        String browserName = FileUtils.readPropertiesFile(FilesPath.resourcesFilePath + "config.properties", "browser");
        System.out.println(browserName);
        if (browserName.equalsIgnoreCase("chrome"))
            return DriverType.CHROME;
        else if (browserName.equalsIgnoreCase("firefox"))
            return DriverType.FIREFOX;
        else if (browserName.equalsIgnoreCase("edge"))
            return DriverType.EDGE;
        else
            throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
    }
}



