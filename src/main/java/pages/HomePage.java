package pages;

import helpers.ActionHelper;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class HomePage extends Base {
    private By arabicButton =  By.xpath("//a[@class='sc-gkFcWv jJNggu']");
    private By continueOnENButton =  By.xpath("//button[@class='sc-jTzLTM hQpNle cta__button cta__continue btn btn-primary']");

    SoftAssert myAssert = new SoftAssert();
    public void checkTheDefaultLangIsEN(){
        ActionHelper.clickAction(continueOnENButton);
        ActionHelper.implicitWait(5000);
        String url = ActionHelper.getTheCurrentUrl();
            myAssert.assertTrue(url.contains("en"));
            myAssert.assertAll();
    }
    public  void checkTheTitleForAR(){
        ActionHelper.clickAction(continueOnENButton);
        ActionHelper.implicitWait(5000);
        ActionHelper.clickAction(arabicButton);
        ActionHelper.implicitWait(4000);
        String title = ActionHelper.getTheTitleOfThePage();
        myAssert.assertTrue(title.contains("المسافر: رحلات، فنادق، أنشطة ممتعة و تذاكر طيران"));
        myAssert.assertAll();
    }

}
