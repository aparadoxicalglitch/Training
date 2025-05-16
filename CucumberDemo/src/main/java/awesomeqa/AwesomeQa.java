package awesomeqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AwesomeQa {
	
	WebDriver wd = new EdgeDriver();
	
	public String launchWeb()
	{
		wd.get("https://www.awesomeqa.com/ui/index.php?route=account/login");
		String text = wd.findElement(By.xpath("//h2[contains(text(),'Returning Customer')]")).getText();
		return text;
		
	}
	
	public void enterUsername(String un)
	{
		wd.findElement(By.xpath("//input[@class='form-control']")).sendKeys(un);
	}
	
	public void enterPassword(String psw)
	{
		wd.findElement(By.name("password")).sendKeys(psw);
	}
	
	public void clickLogin()
	{
		wd.findElement(By.xpath("//input[@value='Login']")).click();
	}
	
	public String accountPage()
	{
		String text = wd.findElement(By.xpath("//h2[contains(text(),'My Account')]")).getText();
		return text;
	}
	
	public String navigateBack()
	{
		wd.navigate().back();
		String text = wd.findElement(By.xpath("//h2[contains(text(),'Returning Customer')]")).getText();
		return text;
	}
	
	public String invalidLogin()
	{
		String text = wd.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		return text;
	}

}