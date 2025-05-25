package com.firstcry.base;

import org.openqa.selenium.WebDriver;
import com.firstcry.utilities.ConfigReader;

public class BaseTest {
    
    protected WebDriver driver;
    
    public void setUp() {
        String browser = ConfigReader.getBrowser();
        WebDriverManager.setDriver(browser);
        driver = WebDriverManager.getDriver();
        driver.get(ConfigReader.getUrl());
    }
    
    public void tearDown() {
        WebDriverManager.quitDriver();
    }
    
    public WebDriver getDriver() {
        return WebDriverManager.getDriver();
    }
}