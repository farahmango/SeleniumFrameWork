package pages;

import helpers.ActionHelper;
import helpers.ExplicitWait;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class HomePage extends Base {
    private By arabicButton = By.xpath("//a[@class='sc-imABML jBAuIA']");
    private By continueOnENButton = By.xpath("//button[@class='sc-jTzLTM hQpNle cta__button cta__continue btn btn-primary']");

    SoftAssert myAssert = new SoftAssert();

    public void checkTheDefaultLangIsEN() {
        ActionHelper.clickAction(continueOnENButton);
        ActionHelper.implicitWait(5000);
        String url = ActionHelper.getTheCurrentUrl();
        System.out.println(url.contains("/en"));
        myAssert.assertTrue(url.contains("/en"));
        myAssert.assertAll();
    }

    public void checkTheTitleForAR() {
        ActionHelper.clickAction(continueOnENButton);
        ActionHelper.implicitWait(5000);
        ActionHelper.clickAction(arabicButton);
        ActionHelper.implicitWait(4000);
        String title = ActionHelper.getTheTitleOfThePage();
        ExplicitWait.waitForPageThatHasGivenTitle(title);
        System.out.println(title.equalsIgnoreCase("المسافر: رحلات، فنادق، أنشطة ممتعة و تذاكر طيرا"));
        myAssert.assertTrue(title.equalsIgnoreCase("المسافر: رحلات، فنادق، أنشطة ممتعة و تذاكر طيرا"));
        myAssert.assertAll();
    }
}
