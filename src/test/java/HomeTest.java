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
    @Test(description = "Check that the default language is english")
    public void checkTheDefaultLangIsEN() {
        homePage.checkTheDefaultLangIsEN();
    }

    @Test(description = "Check the title for arabic website")
    public void checkTheTitleForAR() {
        homePage.checkTheTitleForAR();
    }
}
