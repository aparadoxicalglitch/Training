//package googleList;
//
//import java.time.Duration;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class GoogleList {
//	
//	WebDriver wd;
//	
//	public GoogleList()
//	{
//		wd = new EdgeDriver();
//		wd.manage().window().maximize();
//	}
//	
//	public void storingList()
//	{
//		wd.get("https://www.google.com/");
//		wd.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys("uber");
//		
//        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@role='listbox']")));
//		
//		List <WebElement> list = wd.findElements(By.xpath("//li[@data-view-type='1']"));
//		
//		List <String> sg = new ArrayList<String>();
//		
//		for(int i=0;i<=list.size()-1;i++) {
//			String val= list.get(i).getText();
//			sg.add(val);
//		}
//		
//		System.out.println(sg);
//		
//	}
//
//}


package googleList;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleList {

    WebDriver wd;

    public GoogleList() {
        wd = new EdgeDriver();
        wd.manage().window().maximize();
    }

    public void retrieveMarvelMovies() throws InterruptedException {
        // Task 1: Open Google and search
        wd.get("https://www.google.com/");
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q"))).sendKeys("List of Marvel Cinematic Universe films");
        wd.findElement(By.name("q")).submit();

        Thread.sleep(20000);
        // Click on the first search result
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3"))).click();

        // Store the title of the resulting website
        String website_title = wd.getTitle();
        System.out.println("Website Title: " + website_title);

        // Task 2-4: Retrieve first 5 movies from Phase 1, 2, and 3
        List<String> phase1_movies = new ArrayList<>();
        List<String> phase2_movies = new ArrayList<>();
        List<String> phase3_movies = new ArrayList<>();

        // Wait until the Phase 1 table is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table[contains(@class, 'wikitable')])[1]")));

        // Get first 5 movies of Phase 1
        List<WebElement> phase1_rows = wd.findElements(By.xpath("(//table[contains(@class, 'wikitable')])[1]//tr[position()>1 and position()<7]/th[1]"));
        for (WebElement row : phase1_rows) {
            phase1_movies.add(row.getText().trim());
        }

        // Get first 5 movies of Phase 2
        List<WebElement> phase2_rows = wd.findElements(By.xpath("(//table[contains(@class, 'wikitable')])[2]//tr[position()>1 and position()<7]/th[1]"));
        for (WebElement row : phase2_rows) {
            phase2_movies.add(row.getText().trim());
        }

        // Get first 5 movies of Phase 3
        List<WebElement> phase3_rows = wd.findElements(By.xpath("(//table[contains(@class, 'wikitable')])[3]//tr[position()>1 and position()<7]/th[1]"));
        for (WebElement row : phase3_rows) {
            phase3_movies.add(row.getText().trim());
        }

        System.out.println("Phase 1 Movies: " + phase1_movies);
        System.out.println("Phase 2 Movies: " + phase2_movies);
        System.out.println("Phase 3 Movies: " + phase3_movies);

        // Optional: Close the browser
        wd.quit();
    }

    public static void main(String[] args) throws InterruptedException {
        GoogleList gl = new GoogleList();
        gl.retrieveMarvelMovies();
    }
}
