import helpers.ActionHelper;
import helpers.ExplicitWait;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(reporting.LogManager.class)
public class Base extends pages.Base {
    @BeforeMethod
    public void test() {
        setUp();
    }
    @Test(description = "Go to google ")
    public void test2() {
        ExplicitWait.waitForPageThatHasGivenTitle("Google");

        By e = new By.ByXPath("//textarea[@class='gLFyf']");
        ActionHelper.sendKeysWithClear(e,"farah mango");
        ActionHelper.clickAction(new By.ByXPath("(//input[@class='gNO89b'])[2]"));
    }

//    @Test(description = "Go to google 2 ")
//    public void test3() {
//        ActionHelper.navigateToPage("https://www.google.com");
//        ExplicitWait.waitForPageThatHasGivenTitle("Google");
//
//        By e = new By.ByXPath("//textarea[@class='gLFyf']");
//        ActionHelper.sendKeysWithClear(e,"farah mango");
//        ActionHelper.clickAction(new By.ByXPath("(//input[@class='gNO89b'])[2]"));
//    }
}
