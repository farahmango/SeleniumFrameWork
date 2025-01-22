package helpers;

import interfaces.FilesPath;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.Base;
import reporting.LogManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import utils.DateUtils;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class ActionHelper extends Base {

    static Actions action = new Actions(driver);
    static JavascriptExecutor js = (JavascriptExecutor) driver;
    static LogManager logManager = new LogManager();

    public static void navigateToPage(String url) {
        driver.navigate().to(url);
        logManager.INFO("The user navigate to " + url);
    }

    public static void navigateToPreviousPage() {
        driver.navigate().back();
        logManager.INFO("The user navigate back to Previous Page");

    }

    public static void selectByValue(By webElement, String value) {
        WebElement WE = findElement(webElement);
        Select selectBy = new Select(WE);
        selectBy.selectByValue(value);
        logManager.INFO("The user select " + webElement + "by value " + value);

    }

    public static void selectByIndex(By webElement, int index) {
        WebElement WE = findElement(webElement);
        Select selectBy = new Select(WE);
        selectBy.selectByIndex(index);
        logManager.INFO("The user select " + webElement + "by index " + index);

    }

    public static void moveToElement(By webElement) {
        WebElement WE = findElement(webElement);
        action.moveToElement(WE).perform();
        logManager.INFO("The user move to element " + webElement);


    }

    public static void scrollToPageBottom() {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        logManager.INFO("The user scroll To Page Bottom");


    }

    public static void scrollToPageTop() {
        js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
        logManager.INFO("The user scroll To Page Top");
    }

    public static String getTheCurrentUrl() {
        logManager.INFO("get the current URL: " +driver.getCurrentUrl());
        return  driver.getCurrentUrl();
    }

    public static String getTheTitleOfThePage() {
        logManager.INFO("get the page title: " +driver.getTitle());
       return driver.getTitle();
    }

    public static void clickAction(By webElement) {
        WebElement WE = findElement(webElement);
        WE.click();
        logManager.INFO("The user click on [" + webElement + "]");

    }

    public static void sendKeysWithClear(By webElement, String text) {
        WebElement WE = findElement(webElement);
        WE.clear();
        WE.sendKeys(text);
        logManager.INFO("The user Send keys with Clear [" + text + "] inside element [" + webElement + "]");

    }

    public static WebElement findElement(By webElement) {
        WebElement WE = driver.findElement(webElement);
        return WE;
    }

    public static List<WebElement> findListOfElement(By webElement) {
        List<WebElement> WE = driver.findElements(webElement);
        return WE;
    }

    public static void takeScreenShot() {
        String dateFormatter = DateUtils.dateFormatter(DateUtils.getTheCurrentDate(), "dd-MMM-YY");
        String timeFormatter = DateUtils.timeFormatter(DateUtils.getTheCurrentTime(), "hh-mm-ss-a");
        Screenshot s = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        try {
            ImageIO.write(s.getImage(), "PNG", new File(FilesPath.screenShotPath + dateFormatter + " at " + timeFormatter + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void driverWait(long millSecond) {
        try {
            Thread.sleep(millSecond);
        } catch (InterruptedException e) {
            logManager.ERROR("an issue has been initiated with following error : " + e.getMessage());
        }
    }

    public static void implicitWait(long millSecond) {
        driver.manage().timeouts().implicitlyWait(millSecond, TimeUnit.SECONDS);
    }
    public static void pageLoadTimeout(long millSecond) {
        driver.manage().timeouts().pageLoadTimeout(millSecond, TimeUnit.SECONDS);
    }
    public static void setScriptTimeout(long millSecond) {
        driver.manage().timeouts().setScriptTimeout(millSecond, TimeUnit.SECONDS);
    }

    public static void makeBorder(By webElement) {
        WebElement wb = findElement(webElement);
        js.executeScript("arguments[0].style.border = '3px solid red'", wb);
        logManager.INFO("Make a red border on this element " + webElement);

    }
}
