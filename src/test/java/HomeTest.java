import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Base;
import pages.HomePage;

@Listeners(reporting.LogManager.class)
public class HomeTest extends Base {
    @BeforeMethod
    public void setUpDriver() {
        setUp();
    }
    HomePage homePage = new HomePage();
    @Test(description = "Check that the default language is english",priority = 1)
    public void checkTheDefaultLangIsEN() {
        homePage.checkTheDefaultLangIsEN();
    }

    @Test(description = "Check the title for arabic website",priority = 2)
    public void checkTheTitleForAR() {
        homePage.checkTheTitleForAR();
    }
    @Test(description = "Check that the default language is english",priority = 3)
    public void checkTheDefaultLangIsEN2() {
        homePage.checkTheDefaultLangIsEN();
    }
}
