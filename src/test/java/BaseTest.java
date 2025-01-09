import helpers.ActionHelper;
import helpers.ExplicitWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Base;

public class BaseTest extends Base {


    @BeforeMethod
    public void test() {
        setUp();
    }
    @Test
    public void test2() {
//        driver.get("https://www.google.com");
        ExplicitWait.waitForPageThatHasGivenTitle("Google");


        WebElement e =  ActionHelper.findElement(new By.ByXPath("//textarea[@class='gLFyf']"));
        e.sendKeys("fffff");

        WebElement ee =  ActionHelper.findElement(new By.ByXPath("(//input[@class='gNO89b'])[2]"));

    }


}
