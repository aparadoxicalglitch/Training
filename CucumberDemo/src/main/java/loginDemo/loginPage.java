package loginDemo;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
	
	WebDriver wd;
	
	By username = By.id("username");
	By password = By.id("password");
	By login = By.className("btn");
	By actu = By.xpath("//div[text()='Your username is invalid!']");
	
	public loginPage(WebDriver wd)
	{
		this.wd = wd;
	}
	
	public void enterUsername(String un)
	{
		wd.findElement(username).sendKeys(un);
	}
	
	public void enterPassword(String ps)
	{
		wd.findElement(password).sendKeys(ps);
	}
	
	public void clickLogin()
	{
		wd.findElement(login).click();
	}
	
	public void invalid()
	{
		String act = wd.findElement(actu).getText();
		String exp = "Your username is invalid!";
		assertEquals(act,exp);
	}

}
