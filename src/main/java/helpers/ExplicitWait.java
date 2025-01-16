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

    static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    static Wait<WebDriver> fluentWait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(5))
            .pollingEvery(Duration.ofSeconds(5))
            .ignoring(NoSuchElementException.class);

    public static void visibilityOfElementLocated(By webElement) {
        WebElement WB = ActionHelper.findElement(webElement);
        wait.until(ExpectedConditions.visibilityOf(WB));
    }

    public static void alertIsPresent() {
        wait.until(ExpectedConditions.alertIsPresent());
        fluentWait.until(ExpectedConditions.alertIsPresent());
    }

    public static void elementToBeClickable(By webElement) {
        WebElement WB = ActionHelper.findElement(webElement);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static void textToBePresentInElement(By webElement, String text) {
        WebElement WB = ActionHelper.findElement(webElement);
        wait.until(ExpectedConditions.textToBePresentInElement(WB, text));
    }

    public static void textToBePresentInElementValue(By webElement, String text) {
        WebElement WB = ActionHelper.findElement(webElement);
        wait.until(ExpectedConditions.textToBePresentInElementValue(WB, text));
    }

    public static void waitForPageThatHasGivenTitle(String title) {
//        wait.until(ExpectedConditions.titleIs(title));
        fluentWait.until(ExpectedConditions.titleIs(title));
    }

    public static void elementToBeSelected(By webElement) {
        WebElement WB = ActionHelper.findElement(webElement);
        wait.until(ExpectedConditions.elementToBeSelected(WB));
    }

    public static void invisibilityOfElement(By webElement) {
        WebElement WB = ActionHelper.findElement(webElement);
        wait.until(ExpectedConditions.invisibilityOf(WB));
    }

    public static void frameToBeAvailableAndSwitchToIt(By webElement) {
        WebElement WB = ActionHelper.findElement(webElement);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(WB));
    }


}
