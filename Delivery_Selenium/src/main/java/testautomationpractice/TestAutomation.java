package testautomationpractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TestAutomation {
	
	WebDriver wd;

	public TestAutomation() {
		wd = new ChromeDriver();
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wd.get("https://testautomationpractice.blogspot.com/");
	}
	
	public void tearDown() {
		if (wd != null) {
			wd.quit();
		}
	}

	public void Testing() throws InterruptedException {
		wd.findElement(By.xpath("//input[@id='name']")).sendKeys("Himanshu");
		wd.findElement(By.xpath("//input[@id='email']")).sendKeys("email.email.com");
		wd.findElement(By.xpath("//input[@id='phone']")).sendKeys("986745231");
		wd.findElement(By.xpath("//textarea[@id='textarea']")).sendKeys("Entering address");
		wd.findElement(By.xpath("//input[@id='male']")).click();
		wd.findElement(By.xpath("//input[@id='sunday']")).click();
		wd.findElement(By.xpath("//input[@id='monday']")).click();

		WebElement we = wd.findElement(By.xpath("//select[@id='country']"));
		Select s = new Select(we);
		s.selectByVisibleText("India");

		WebElement we1 = wd.findElement(By.xpath("//select[@id='colors']"));
		Select se = new Select(we1);
		se.selectByVisibleText("Green");

		// Picking up the date
		wd.findElement(By.id("datepicker")).click();
		while (true) {
		    String currentMonth = wd.findElement(By.className("ui-datepicker-month")).getText();
		    String currentYear = wd.findElement(By.className("ui-datepicker-year")).getText();
		    
		    if (currentMonth.equals("March") && currentYear.equals("2027")) {
		        break;
		    } else {
		    	wd.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		    }
		}
		wd.findElement(By.xpath("//a[text()='15']")).click();
	}
	
	public void Tabs() throws InterruptedException {
		wd.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).sendKeys("451103");
		wd.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);
		String act = wd.findElement(By.xpath("//a[text()='451138 Rizvanov']")).getText();
		String exp = "451138 Rizvanov";
		Assert.assertEquals(act, exp);
	}
	
	public void Button() {
		wd.findElement(By.xpath("//button[@class='start']")).click();
		WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(10));	
		WebElement we3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='stop']")));
		we3.click();
	}
	
	public void simpleAlert() {
		By simpleAlert = By.id("alertBtn");
		wd.findElement(simpleAlert).click();
		Alert a = wd.switchTo().alert();
		a.accept();
	}
	
	public void confirmationAlert() {
		wd.findElement(By.id("confirmBtn")).click();
		Alert a = wd.switchTo().alert();
		a.dismiss();
	}
	
	public void promptBtn() {
	    wd.findElement(By.id("promptBtn")).click();
	    Alert a = wd.switchTo().alert();
	    a.sendKeys(""); // Clear
	    a.sendKeys("Himanshu");
	    a.accept();
	}
	
	public void mouseHover() {
		WebElement we = wd.findElement(By.xpath("//button[@class='dropbtn']"));
		Actions a = new Actions(wd);
		a.moveToElement(we).perform();
	}
	
	public void doubleClick() {
		WebElement we = wd.findElement(By.xpath("//button[@ondblclick=\"myFunction1()\"]"));
		Actions a = new Actions(wd);
		a.doubleClick(we).perform();
	}
	
	public void dragDrop() {
		WebElement source = wd.findElement(By.id("draggable"));
		WebElement target = wd.findElement(By.id("droppable"));
		Actions a = new Actions(wd);
		a.dragAndDrop(source, target).perform();
	}
	
	public void staticTable()
	{
		List <WebElement> list = wd.findElements(By.name("BookTable"));
		for(int i = 0; i<list.size(); i++)
		{
			System.out.println(list.get(i).getText());
		}
	}
	
	public void dynamicTable() {
	    WebElement table = wd.findElement(By.id("taskTable"));

	    // Step 1: Get headers
	    List<WebElement> headers = table.findElements(By.xpath(".//thead/tr/th"));
	    for (WebElement header : headers) {
	        System.out.print(header.getText() + "\t");
	    }
	    System.out.println();

	    // Step 2: Get rows
	    List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));
	    
	    for (WebElement row : rows) {
	        List<WebElement> cols = row.findElements(By.tagName("td"));
	        for (WebElement col : cols) {
	            System.out.print(col.getText() + "\t");
	        }
	        System.out.println();
	    }
	}

}
