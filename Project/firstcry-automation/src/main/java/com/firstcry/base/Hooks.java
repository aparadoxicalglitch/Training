package com.firstcry.base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import com.firstcry.utilities.ConfigReader;

public class Hooks {
    
    @Before
    public void setUp() {
        String browser = ConfigReader.getBrowser();
        WebDriverManager.setDriver(browser);
        WebDriverManager.getDriver().get(ConfigReader.getUrl());

    }
    @After
    public void tearDown() {
        WebDriverManager.quitDriver();
    }
}