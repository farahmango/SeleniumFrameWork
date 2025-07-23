import helpers.ActionHelper;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Base;
import pages.HomePage;
import reporting.SLF4J;

import java.util.List;

import static org.openqa.selenium.Keys.ENTER;

@Listeners(reporting.LogManager.class)
public class Home extends Base {
    @BeforeClass
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
//        homePage.checkTheDefaultLangIsEN();
//        System.out.println("tooooest");
        System.out.println(driver.getWindowHandles());
By list =  By.xpath("//img[@src='data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAABDUlEQVR4AWP4////gOLB44D6nTcsGIo33QHi/zTGd0B2YTiAPpYjHIHNAf/piQk6wGPW8f/rLz8HYRCbXg5AWI4GQGJ0cwDY12gAJDbcHUA4CkZAIqQUK7Ts/m/SfxBMs5RupswBaACr+P47b/5zlG/5DyzZ/r/+8hNF7vuvP//nn3r0X6JhJ+0ccPrR+/+H7735jw9cf/n5v0D1Nuo5gBxQve06zR0AjoL7b7/+//zjN4bc+ScfaOeA33///k9Yfg4mDw7u/Xdeo6uhnQP6D93FMNxlxjF0ZbRzgMXEQ9iyI90cALIMJoccDXRzAK6CZog6YNQBow6gIx54Bwx4x2RAu2bAysoEZu9o7xgAQrvkxt3WZi0AAAAASUVORK5CYII=']//ancestor::a[@class='zReHs']//child::h3");
        By searchBox =  By.xpath("//textarea[@class='gLFyf']");
        driver.navigate().to("https://www.google.com");
        ActionHelper.sendKeysWithClear(searchBox,"li");

driver.switchTo().window("jj");
        List<WebElement> list2=  ActionHelper.findListOfElement(list);
        for (int i = 0 ; i<list2.size();i++){
            System.out.println(list2.get(i).getText());

        }
        driver.switchTo().alert();
        Alert a ;
        driver.get("");


    }
    @Test
    public void TestSLF4J() {
        SLF4J.INFO("INFO MSG");
        SLF4J.ERROR("ERROR MSG");
        SLF4J.DEBUG("DEBUG MSG");
        SLF4J.WARNING("WARNING MSG");
    }
}
