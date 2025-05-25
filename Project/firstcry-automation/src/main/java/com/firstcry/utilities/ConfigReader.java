package com.firstcry.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    
    private static Properties properties;
    
    static {
        loadProperties();
    }
    
    private static void loadProperties() {
        properties = new Properties();
        InputStream inputStream = null;
        

        inputStream = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties");
        
        if (inputStream == null) {

            try {
                inputStream = new FileInputStream("src/resources/config.properties");
            } catch (IOException e) {
                throw new RuntimeException("Failed to load config.properties file", e);
            }
        }
        
        try {
            properties.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties file", e);
        }
    }
    
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
    
    public static String getUrl() {
        return getProperty("url");
    }
    
    public static String getBrowser() {
        return getProperty("browser");
    }
}