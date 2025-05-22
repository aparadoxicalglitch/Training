package com.fristcry.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
    WebDriver wd;

    By stores = By.xpath("//span[text()='Stores & Preschools']");
    By findStores = By.xpath("//a[contains(text(), 'Find Stores')]");

    public HomePage(WebDriver wd) {
        this.wd = wd;
    }

    public void hoverOverStoreAndPreschool() throws InterruptedException {
        WebElement storesPreschools = wd.findElement(stores);

        // Hover over the "Stores & Preschools" tab
        Actions a = new Actions(wd);
        a.moveToElement(storesPreschools).perform();

        // Wait for the dropdown to appear (tune this as needed)
        Thread.sleep(2000);

        // Now click the "Find Stores" link
        WebElement findStore = wd.findElement(findStores);
        a.moveToElement(findStore).click().perform();
    }
}