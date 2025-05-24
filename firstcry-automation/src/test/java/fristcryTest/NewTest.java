package fristcryTest;

import org.testng.annotations.Test;
import com.fristcry.pages.HomePage;
import com.fristcry.pages.LoginPage;
import com.fristcry.pages.PreschoolLocatorPage;
import com.fristcry.pages.StoreLocatorPage;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class NewTest {
    @Test
    public void testing() throws Exception {
        WebDriver wd = new EdgeDriver();
        wd.get("https://www.firstcry.com/m/login");
        wd.manage().window().maximize();

        LoginPage lp = new LoginPage(wd);
        lp.enterMobileNo("7004481495");
        lp.clickContinue();

        lp.submitOTP();

        // ========== Store Locator ==========

        HomePage hp = new HomePage(wd);
        hp.hoverOverStoreAndPreschool();

        // Switch to new Store Locator tab
        ArrayList<String> tabs1 = new ArrayList<>(wd.getWindowHandles());
        wd.switchTo().window(tabs1.get(1));

        StoreLocatorPage slp = new StoreLocatorPage(wd);
        String act0 = slp.verifyStorePage();
        String exp0 = "Store Locator";
//        slp.selectStoreType("FirstCry");
//        slp.selectState("Maharashtra");
//        slp.selectCity("Pune Kharadi");
        assertEquals(act0, exp0);
        slp.clickSearch();
        String act = slp.verifyError();
        String exp = "Please Select Store Type";
        
        assertEquals(act, exp);

        // ========== Preschool Locator ==========

        slp.hoverOverStoreAndPreschool();

        // Switch to new Preschool Locator tab
        ArrayList<String> tabs2 = new ArrayList<>(wd.getWindowHandles());
        wd.switchTo().window(tabs2.get(tabs2.size() - 1)); // Switch to last opened tab

        String expectedHeading = "Preschool Locator";
        String expectedSubheading = "Preschools Near You";

        PreschoolLocatorPage plp = new PreschoolLocatorPage(wd);
        String actualHeading = plp.verifyPreschoolLocator();
//        plp.enterPincode("411014");
        plp.enterPincode("633456");
        plp.clickSubmit();
//        String actualSubheading = plp.verifyPreschool();
        String act1 = plp.verifyInvalidError();
        String exp1 = "Ooopss…";

        assertEquals(actualHeading, expectedHeading);
        assertEquals(act1, exp1);
//        assertEquals(actualSubheading, expectedSubheading);

        // wd.quit(); // Optional: close browser after test
    }
}