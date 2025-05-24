package com.fristcry.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class HomePage {
    WebDriver wd;
    WebDriverWait wait;
    
    By storesAndPreschools = By.xpath("//span[text()='Stores & Preschools']");
    By findStores = By.xpath("//a[@href='//www.firstcry.com/store-locator?ref2=topstrip']");
    
    public HomePage(WebDriver wd) {
        this.wd = wd;
        this.wait = new WebDriverWait(wd, Duration.ofSeconds(10));
    }
    
    public void hoverOverStoreAndPreschool() throws InterruptedException {
        WebElement storesPreschools = wait.until(ExpectedConditions.elementToBeClickable(storesAndPreschools));
        Actions a = new Actions(wd);
        a.moveToElement(storesPreschools).perform();
        
        WebElement findStore = wait.until(ExpectedConditions.elementToBeClickable(findStores));
        a.moveToElement(findStore).click().perform();
    }
}