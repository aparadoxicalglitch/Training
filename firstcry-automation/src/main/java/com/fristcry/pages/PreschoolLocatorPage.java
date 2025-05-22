package com.fristcry.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PreschoolLocatorPage {
    WebDriver driver;

    By storesPreschoolMenu = By.xpath("//span[text()='Stores & Preschools']");
    By findPreschoolsLink = By.xpath("//a[text()='Find Preschools']");
    By pincodeInput = By.id("txtPinCode");
    By submitButton = By.id("btnSubmit");
    By errorMessage = By.xpath("//*[contains(text(),\"Ooopss\")]");

    public PreschoolLocatorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void hoverOnStoresMenu() {
        Actions action = new Actions(driver);
        WebElement menu = driver.findElement(storesPreschoolMenu);
        action.moveToElement(menu).perform();
    }

    public void clickFindPreschools() {
        driver.findElement(findPreschoolsLink).click();
    }

    public void enterPincode(String pincode) {
        driver.findElement(pincodeInput).clear();
        driver.findElement(pincodeInput).sendKeys(pincode);
    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }

    public boolean isErrorMessageShown() {
        return driver.findElement(errorMessage).isDisplayed();
    }

    public boolean isSubmitDisabled() {
        return !driver.findElement(submitButton).isEnabled();
    }
}
