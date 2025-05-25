package com.fristcry.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver wd;

    By mobileNO = By.xpath("//input[@id='lemail']");
    By submit = By.xpath("//span[text()='CONTINUE']");
    By otpSubmit = By.xpath("//div[@class='loginSignup_submitOtpBtn_block bg_ff btn_fill']");

    public LoginPage(WebDriver wd) {
        this.wd = wd;
    }

    public void enterMobileNo(String mobileNo) {
        wd.findElement(mobileNO).sendKeys(mobileNo);
    }

    public void clickContinue() throws InterruptedException {
        Thread.sleep(3000);
        wd.findElement(submit).click();
    }
    
    public void submitOTP() throws InterruptedException
    {
    	Thread.sleep(30000);
    	wd.findElement(otpSubmit).click();
    	Thread.sleep(5000);
    }
}