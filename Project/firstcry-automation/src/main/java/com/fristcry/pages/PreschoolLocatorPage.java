package com.fristcry.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class PreschoolLocatorPage {

    WebDriver driver;
    WebDriverWait wait;

    By verifyPreschoolPage = By.xpath("//*[@id=\"scrollHeight\"]/app-locator-listing/div[2]/div/h2");
    By pincodeInput = By.xpath("//*[@id=\"scrollHeight\"]/app-locator-listing/div[2]/div/div[2]/div[1]/input");
    By submitButton = By.xpath("//*[@id=\"scrollHeight\"]/app-locator-listing/div[2]/div/div[2]/div[2]/button/div");
    By errorMessage = By.xpath("//span[text()='Ooopss…']"); 
    By verifyPreschool = By.xpath("//p[text()='Preschools Near You ']");

    public PreschoolLocatorPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String verifyPreschoolLocator() {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(verifyPreschoolPage));
        String actual = element.getText();
        return actual;
    }

    public void enterPincode(String pincode) {
        WebElement pincodeField = wait.until(ExpectedConditions.elementToBeClickable(pincodeInput));
        pincodeField.clear();
        pincodeField.sendKeys(pincode);
    }

    public void clickSubmit() {
        WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitBtn.click();
    }

    public boolean isSubmitDisabled() {
        return !driver.findElement(submitButton).isEnabled();
    }

    public String verifyPreschool() {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(verifyPreschool));
        String actual = element.getText();
        return actual;
    }
    
    public String verifyInvalidError()
    {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(errorMessage));
        String actual = element.getText();
        return actual;
    }
}