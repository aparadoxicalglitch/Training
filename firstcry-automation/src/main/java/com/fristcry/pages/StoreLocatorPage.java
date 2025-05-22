package com.fristcry.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class StoreLocatorPage {
	
	
    WebDriver driver;

    // Locators
    By storeTypeDropdown = By.id("storetype");
    By stateDropdown = By.xpath("//div[@id='dvstate']");
    By cityDropdown = By.xpath("//div[@id='dvcity']");
    By searchButton = By.xpath("//input[@type='button']");
    By storeResults = By.cssSelector(".store-results");

    public StoreLocatorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectStoreType(String storeType) {
        new Select(driver.findElement(storeTypeDropdown)).selectByVisibleText(storeType);
    }

    public void selectState(String state) {
        new Select(driver.findElement(stateDropdown)).selectByVisibleText(state);
    }

    public void selectCity(String city) {
        new Select(driver.findElement(cityDropdown)).selectByVisibleText(city);
    }

    public void clickSearch() {
        driver.findElement(searchButton).click();
    }
}
