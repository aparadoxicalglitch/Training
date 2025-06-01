package herokuapp;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.io.Files;

public class HerokuApp {
	
	WebDriver wd;
	
	public HerokuApp()
	{
		wd = new EdgeDriver();
		wd.manage().window().maximize();
	}
	
	public void abTesting()
	{
		wd.get("https://the-internet.herokuapp.com/abtest");
		String act = wd.findElement(By.xpath("//h3[text()='A/B Test Control']")).getText();
		String exp = "A/B Test Control";
		Assert.assertEquals(act, exp);
	}
	
	public void addRemove()
	{
		wd.get("https://the-internet.herokuapp.com/add_remove_elements/");
		for(int i=0;i<5;i++)
		{
			wd.findElement(By.xpath("//button[@onclick='addElement()']")).click();
		}
		
		for(int i=0;i<2;i++)
		{
			
			WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@onclick='deleteElement()']"))).click();
		}
		
		List<WebElement> remainingDeleteButtons = wd.findElements(By.xpath("//button[@onclick='deleteElement()']"));
		System.out.println("Remaining Delete buttons: " + remainingDeleteButtons.size());

		if (remainingDeleteButtons.size() == 3) {
		    System.out.println("Test Passed: 3 Delete buttons remain.");
		} else {
		    System.out.println("Test Failed: Expected 3, but found " + remainingDeleteButtons.size());
		}

	}
	
	public void basicAuth()
	{
		wd.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
	}
	
	public void assertLogin()
	{
		wd.get("https://practicetestautomation.com/practice-test-login/");
		String title = wd.getTitle();
		String act = "Test Login | Practice Test Automation";
		
		if(title.equals(act))
		{
			System.out.println("Same");
		}
		else {
			System.out.println("No");
		}	
	}
	
	public void checkBox() {
	    wd.get("https://the-internet.herokuapp.com/checkboxes");

	    List<WebElement> checkboxes = wd.findElements(By.cssSelector("input[type='checkbox']"));
	    
	    checkboxes.get(0).click();
	    checkboxes.get(1).click();

//	    for (WebElement checkbox : checkboxes) {
//	        if (!checkbox.isSelected()) {
//	            checkbox.click();
//	        }
//	    }
	}
	
	public void disapperingElement()
	{
		wd.get("https://the-internet.herokuapp.com/disappearing_elements");
		
	    int rC = 0;
	    boolean found = false;

	    for (int i = 0; i < 20; i++) {
	        List<WebElement> links = wd.findElements(By.xpath("//a[text()='Gallery']"));

	        if (!links.isEmpty() && links.get(0).isDisplayed()) {
	            found = true;
	            break;
	        }

	        wd.navigate().refresh();
	        rC++;
	    }
		
		System.out.println(rC);
	}
	
	public void dragAndDrop()
	{
		wd.get("https://the-internet.herokuapp.com/drag_and_drop");
		
		WebElement source = wd.findElement(By.xpath("//div[@id='column-a']"));
		WebElement target = wd.findElement(By.xpath("//div[@id='column-b']"));
		Actions a = new Actions(wd);
		a.dragAndDrop(source, target).perform();
	}
	
	public void dropDrown()
	{
		wd.get("https://the-internet.herokuapp.com/dropdown");
		
		WebElement we = wd.findElement(By.id("dropdown"));
		Select s = new Select(we);
		s.selectByVisibleText("Option 2");
	}
	
	public void alert()
	{
		wd.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		wd.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		Alert a = wd.switchTo().alert();
		a.sendKeys("harry");
		a.accept();
	}
	
	public void entryAd()
	{
		
		wd.get("https://the-internet.herokuapp.com/entry_ad");
		
	    WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(10));
	    WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='modal']//p[text()='Close']")));
	    closeButton.click();
		
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("modal")));
		
	}
	
	public void dynamicLoading()
	{
		wd.get("https://the-internet.herokuapp.com/dynamic_loading");
		
		wd.findElement(By.xpath("//a[@href='/dynamic_loading/1']")).click();
		
		WebDriverWait w = new WebDriverWait(wd, Duration.ofSeconds(10));
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Start']"))).click();
		
		
	    WebElement message = w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));

	    String actualText = message.getText();
	    String expectedText = "Hello World!";

	    if (actualText.equals(expectedText)) {
	        System.out.println("Validation passed: Message is '" + actualText + "'");
	    } else {
	        System.out.println("Validation failed: Expected 'Hello World!' but got '" + actualText + "'");
	    }
		
	}
	
	public void multipleWindow()
	{
		wd.get("https://the-internet.herokuapp.com/windows");
		
		wd.findElement(By.xpath("//a[text()='Click Here']")).click();
		
		Set <String> wh = wd.getWindowHandles();
		
		List <String> handles = new ArrayList<String>();
		
		handles.addAll(wh);
		
		wd.switchTo().window(handles.get(1));
		
		System.out.println("Number of tabs are : " + handles.size());
		
		  WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(10));
		
	    WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h3")));
	    String headingText = heading.getText();
	    
	    String expectedText = "New Window";
	    if (headingText.equals(expectedText)) {
	        System.out.println("Heading text is correct: " + headingText);
	    } else {
	        System.out.println("Heading text is incorrect: " + headingText);
	    }

	    wd.close();
	    wd.switchTo().window(handles.get(0));
	}
	
	public void scroll()
	{
//		wd.get("https://the-internet.herokuapp.com/infinite_scroll");
		wd.get("https://help.hackerearth.com/solving-java-selenium-question");
		
		JavascriptExecutor jse = (JavascriptExecutor) wd;
		
//		jse.executeScript("window.scrollBy(0,5000);");
		jse.executeScript("scroll(0,1000)");
	}
	
	public void infiniteScroll() throws InterruptedException {
	    wd.get("https://the-internet.herokuapp.com/infinite_scroll");

	    JavascriptExecutor jse = (JavascriptExecutor) wd;

	    int count = 0;
	    while (count < 3) {
	        jse.executeScript("window.scrollBy(0, 1000);");
	        Thread.sleep(1000);

	        List<WebElement> blocks = wd.findElements(By.className("jscroll-added"));
	        count = blocks.size();
	    }

	    System.out.println("Total text blocks loaded: " + count);
	}
	
	public void fileUpload()
	{
		wd.get("https://the-internet.herokuapp.com/upload");
		
		wd.findElement(By.xpath("//input[@id='file-upload']")).sendKeys("C:\\Users\\himan\\Downloads\\firstcry-automation.txt");
		
		wd.findElement(By.xpath("//input[@id='file-submit']")).click();
		
	}
	
	public void brokenImages() {
	    wd.get("https://the-internet.herokuapp.com/broken_images");

	    List<WebElement> images = wd.findElements(By.tagName("img"));
	    JavascriptExecutor js = (JavascriptExecutor) wd;

	    int brokenCount = 0;

	    for (WebElement img : images) {
	        Boolean isImageOk = (Boolean) js.executeScript("return arguments[0].naturalWidth > 0;", img);	

	        if (!isImageOk) {
	            System.out.println("Broken Image Found: " + img.getDomAttribute("src"));
	            brokenCount++;
	        }
	    }

	    System.out.println("Total Broken Images: " + brokenCount);
	}
	
	public void challengingDom() {
	    wd.get("https://the-internet.herokuapp.com/challenging_dom");

	    List<WebElement> rows = wd.findElements(By.xpath("//table/tbody/tr"));

	    for (WebElement row : rows) {
	        List<WebElement> cells = row.findElements(By.tagName("td"));

	        if (cells.get(0).getText().equals("Iuvaret4")) {
	            WebElement actionCell = cells.get(6);
	            List<WebElement> links = actionCell.findElements(By.tagName("a"));

	            for (WebElement link : links) {
	                System.out.println(link.getText() + " Link: " + link.getDomAttribute("href"));
	            }
	            break;
	        }
	    }
	}
	
	public void iframes()
	{
		wd.get("https://practice-automation.com/iframes/");
		
//		WebElement we = wd.findElement(By.id("iframe-1"));
		
		wd.switchTo().frame(0);
		
		wd.findElement(By.xpath("//a[@class='getStarted_Sjon']")).click();
		
		wd.switchTo().defaultContent();
		
		String act = wd.findElement(By.xpath("//p[text()='Me too!']")).getText();
		
		if(act.equals("Me too!"))
		{
			System.out.println("Back to Main Frame");
		}
		
		wd.switchTo().frame(1);
		
		JavascriptExecutor jse = (JavascriptExecutor) wd;
		
		WebElement w = wd.findElement(By.xpath("//a[@class='selenium-button selenium-webdriver text-uppercase fw-bold']"));
		
		jse.executeScript("arguments[0].scrollIntoView(true);", w);
		
		w.click();
		
	}
	
	public void keyPresses() {
	    wd.get("https://the-internet.herokuapp.com/key_presses");

	    WebElement inputBox = wd.findElement(By.id("target"));

	    Keys[] keys = {Keys.TAB, Keys.SHIFT, Keys.ESCAPE, Keys.SPACE, Keys.ENTER };

	    for (Keys key : keys) {
	        inputBox.sendKeys(key);
	        WebElement result = wd.findElement(By.id("result"));
	        System.out.println("Pressed: " + key.name() + " → " + result.getText());
	    }
	}
	
	public void loginPage()
	{
		wd.get("https://the-internet.herokuapp.com/login");
		
		wd.findElement(By.id("username")).sendKeys("tomsmith");
		
		wd.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		
		wd.findElement(By.xpath("//button[@type='submit']")).click();
		
		String act = wd.findElement(By.xpath("//*[text()=' Secure Area']")).getText();
		
		if(act.equals("Secure Area"))
		{
			System.out.println("You have sucessfully logged in");
		}
		
		wd.findElement(By.xpath("//a[@href='/logout']")).click();
		
		String act1 = wd.findElement(By.xpath("//div[@class='flash success']")).getText();

		String expt = "You logged out of the secure area!";

		
		if(act1.contains(expt))
		{
			System.out.println("You have successfully logged out");
		}
		else
		{
			throw new RuntimeException("Logout validation failed! Expected message not found.");
		}	
	}
	
	public void captureScreenshot(String fileName, String dirPath) throws IOException {
	    File screenshot = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
	    File destination = new File(dirPath, fileName + ".png");
	    Files.copy(screenshot, destination);
	}
	
	public void dataTable() {
	    wd.get("https://the-internet.herokuapp.com/tables");

	    List<WebElement> rows = wd.findElements(By.xpath("//table[@id='table2']/tbody/tr"));

	    for (WebElement row : rows) {
	        System.out.println(row.getText());
	    }
	}
	
	public void dynamicControl()
	{
		wd.get("https://the-internet.herokuapp.com/dynamic_controls");
		
		wd.findElement(By.xpath("//input[@type='checkbox']")).click();
		
		wd.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
		
		WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(10));
		
		WebElement add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Add'])")));
		
		add.click();
		
		wd.findElement(By.xpath("//button[@onclick='swapInput()']")).click();
		
	}
	
	public void scrollToBottom()
	{
		wd.get("https://en.wikipedia.org/wiki/List_of_Marvel_Cinematic_Universe_films");
		
		JavascriptExecutor js = (JavascriptExecutor) wd;
//	    js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
//		js.executeScript("scroll(0,5000)");
		
		WebElement we = wd.findElement(By.xpath("//h4[text()='Phase Six']"));
		
		js.executeScript("arguments[0].scrollIntoView(true);", we);
		
	}
	
	






	

}
