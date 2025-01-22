package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages.Base;

import java.time.Duration;
import java.util.NoSuchElementException;


public class ExplicitWait extends Base {

    static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    static Wait<WebDriver> fluentWait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(10))
            .pollingEvery(Duration.ofSeconds(2))
            .ignoring(NoSuchElementException.class);

    public static void visibilityOfElementLocated(By webElement) {
        WebElement WE = ActionHelper.findElement(webElement);
        wait.until(ExpectedConditions.visibilityOf(WE));
    }

    public static void alertIsPresent() {
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public static void elementToBeClickable(By webElement) {
        WebElement WE = ActionHelper.findElement(webElement);
        wait.until(ExpectedConditions.elementToBeClickable(WE));
    }

    public static void textToBePresentInElement(By webElement, String text) {
        WebElement WE = ActionHelper.findElement(webElement);
        wait.until(ExpectedConditions.textToBePresentInElement(WE, text));
    }

    public static void textToBePresentInElementValue(By webElement, String text) {
        WebElement WE = ActionHelper.findElement(webElement);
        wait.until(ExpectedConditions.textToBePresentInElementValue(WE, text));
    }

    public static void waitForPageThatHasGivenTitle(String title) {
        wait.until(ExpectedConditions.titleIs(title));
    }

    public static void elementToBeSelected(By webElement) {
        WebElement WE = ActionHelper.findElement(webElement);
        wait.until(ExpectedConditions.elementToBeSelected(WE));
    }

    public static void invisibilityOfElement(By webElement) {
        WebElement WE = ActionHelper.findElement(webElement);
        wait.until(ExpectedConditions.invisibilityOf(WE));
    }

    public static void frameToBeAvailableAndSwitchToIt(By webElement) {
        WebElement WE = ActionHelper.findElement(webElement);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(WE));
    }

    public static void waitUrlToBe(String url) {
        wait.until(ExpectedConditions.urlToBe(url));
    }

}
