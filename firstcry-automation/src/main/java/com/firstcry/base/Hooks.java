package com.firstcry.base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import com.firstcry.utilities.ConfigReader;

public class Hooks {
    
    @Before
    public void setUp() {
        System.out.println("Setting up WebDriver...");
        String browser = ConfigReader.getBrowser();
        WebDriverManager.setDriver(browser);
        WebDriverManager.getDriver().get(ConfigReader.getUrl());
        System.out.println("WebDriver setup completed.");
    }
    
    @After
    public void tearDown() {
        System.out.println("Tearing down WebDriver...");
        WebDriverManager.quitDriver();
    }
}