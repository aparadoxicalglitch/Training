package fristcryTest;

import org.testng.annotations.Test;
import com.fristcry.pages.HomePage;
import com.fristcry.pages.LoginPage;
import com.fristcry.pages.StoreLocatorPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTest {
    @Test
//    public void testing() throws Exception {
//        WebDriver wd = new ChromeDriver();
//        wd.get("https://www.firstcry.com/m/login?srsltid=AfmBOor87FJeWXwdxMqUFzLfEdK8tqjGgP1xnaoCCI83Ndp4VUi0pMn2");
//        wd.manage().window().maximize();
//
//        LoginPage lp = new LoginPage(wd);
//        lp.enterMobileNo("7004481495");
//        Thread.sleep(3000);
//        lp.clickContinue();
//
//        // --- Manual OTP Entry ---
//        System.out.println("Please manually enter the OTP in the browser. Waiting for 30 seconds...");
//        Thread.sleep(30000); // Wait for manual OTP entry
//
//        // Wait for homepage to fully load after login (tune as needed)
//        Thread.sleep(5000);
//
//        HomePage hp = new HomePage(wd);
//        hp.hoverOverStoreAndPreschool();
//
//        // Optionally, close driver at the end
//        // wd.quit();
//    }
    
    	public void test()
    	{

    	WebDriver wd = new ChromeDriver();
    	wd.get("https://www.firstcry.com/store-locator?ref2=topstrip");
    	wd.manage().window().maximize();
    	
    	StoreLocatorPage slp = new StoreLocatorPage(wd);
    	slp.selectStoreType("FirstCry");
    	slp.selectState("Maharashtra");
    	slp.selectCity("Mumbai");
    	slp.clickSearch();
    	
    	
    	}
}