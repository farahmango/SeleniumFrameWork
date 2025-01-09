package helpers;

import interfaces.FilesPath;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.Base;
import utils.DateUtils;
import utils.FileUtils;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ActionHelper extends Base {

    static Actions action = new Actions(driver);
    static JavascriptExecutor js = (JavascriptExecutor) driver;

    public void navigateToPage(String url) {
        driver.navigate().to(url);
    }

    public void navigateToPreviousPage() {
        driver.navigate().back();
    }

    public void selectByValue(By webElement, String value) {
        WebElement WE = findElement(webElement);
        Select selectBy = new Select(WE);
        selectBy.selectByValue(value);
    }

    public void selectByIndex(By webElement, int index) {
        WebElement WE = findElement(webElement);
        Select selectBy = new Select(WE);
        selectBy.selectByIndex(index);
    }

    public void moveToElement(By webElement) {
        WebElement WE = findElement(webElement);
        action.moveToElement(WE).perform();

    }

    public void scrollToPageBottom() {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

    }

    public void scrollToPageTop() {
        js.executeScript("window.scrollTo(document.body.scrollHeight,0)");

    }

    public void getTheCurrentUrl() {
        driver.getCurrentUrl();
    }

    public void getTheTitleOfThePage() {
        driver.getTitle();
    }

    public void clickAction(By webElement) {
        WebElement WE = findElement(webElement);
        WE.click();
    }

    public void sendKeysWithClear(By webElement, String text) {
        WebElement WE = findElement(webElement);
        WE.clear();
        WE.sendKeys(text);
    }

    public static WebElement findElement(By webElement) {
        WebElement WE = driver.findElement(webElement);
        return WE;
    }

    public List<WebElement> findListOfElement(By webElement) {
        List<WebElement> WE = driver.findElements(webElement);
        return WE;
    }

    public static void takeScreenShot() {
//        By headerDiv = By.xpath("//img[@alt='Google']");
//        makeBorder(headerDiv);
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String dateFormatter = DateUtils.dateFormatter(DateUtils.getTheCurrentDate(), "dd-MMM-YY");
        String timeFormatter = DateUtils.timeFormatter(DateUtils.getTheCurrentTime(), "hh-mm-ss-a");
        FileUtils.copyFile(file, FilesPath.screenShotPath + dateFormatter + " at " + timeFormatter + ".jpeg");

    }

    public static void driverWait(long millSecond) {
        try {
            Thread.sleep(millSecond);
        } catch (InterruptedException e) {
//            logManger.ERROR("an issue has been initiated with following error : " + e.getMessage(),false);
        }
    }
    public static void implicitWait(long millSecond) {
        driver.manage().timeouts().implicitlyWait(millSecond, TimeUnit.SECONDS);
    }
    public static void makeBorder(By webElement) {
        WebElement wb = findElement(webElement);
        js.executeScript("arguments[0].style.border = '3px solid red'", wb);
    }
}
