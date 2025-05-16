package loginDemo;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginDemo {
	
	WebDriver wd; 
	
	public void initWeb(WebDriver wd)
	{
		this.wd = wd;
	}
	
	public void launchWeb()
	{
		wd.get("https://practicetestautomation.com/practice-test-login/");
	}
	
	public void enterUsernameAndPassword(String username, String password)
	{
		wd.findElement(By.id("username")).sendKeys(username);
		wd.findElement(By.id("password")).sendKeys(password);
	}
	
	public void clickLogin()
	{
		wd.findElement(By.className("btn")).click();
	}
	
	public void verify()
	{
		String act = wd.findElement(By.xpath("//*[text()='Logged In Successfully']")).getText();
		String exp = "Logged In Successfully";
		assertEquals(act,exp);
	}
	
	public void invaild()
	{
		String act = wd.findElement(By.xpath("//div[text()='Your username is invalid!']")).getText();
		String exp = "Your username is invalid!";
		assertEquals(act,exp);
	}
	
}