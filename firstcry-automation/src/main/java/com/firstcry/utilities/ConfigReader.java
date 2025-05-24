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
        try {
            properties = new Properties();
            // Try to load from resources first
            InputStream inputStream = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties");
            if (inputStream != null) {
                properties.load(inputStream);
                inputStream.close();
            } else {
                // Fallback to file path
                FileInputStream fis = new FileInputStream("src/resources/config.properties");
                properties.load(fis);
                fis.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties file");
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