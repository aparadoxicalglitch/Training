package loginDemo;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePage {
	
	WebDriver wd;
	
	By actu = By.xpath("//*[text()='Logged In Successfully']");
	
	public homePage(WebDriver wd) {
		this.wd = wd;
	}
	
	public void verify()
	{
		String act = wd.findElement(actu).getText();
		String exp = "Logged In Successfully";
		assertEquals(act,exp);
	}

}
