package com.fristcry.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver wd;

    By mobileNO = By.xpath("//input[@id='lemail']");
    By submit = By.xpath("//span[text()='CONTINUE']");

    public LoginPage(WebDriver wd) {
        this.wd = wd;
    }

    public void enterMobileNo(String mobileNo) {
        wd.findElement(mobileNO).sendKeys(mobileNo);
    }

    public void clickContinue() {
        wd.findElement(submit).click();
    }
}