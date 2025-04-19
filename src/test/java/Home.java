import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Base;
import pages.HomePage;
import reporting.SLF4J;

@Listeners(reporting.LogManager.class)
public class Home extends Base {
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
        System.out.println("test");
    }
    @Test
    public void TestSLF4J() {
        SLF4J.INFO("INFO MSG");
        SLF4J.ERROR("ERROR MSG");
        SLF4J.DEBUG("DEBUG MSG");
        SLF4J.WARNING("WARNING MSG");
    }
}
