package com.automation.tests.homeworkthree.utilities;

import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties configFile;
    static {
        try {
            String path = System.getProperty("user.dir")+"/configuration.properties";
            FileInputStream input = new FileInputStream(path);
            configFile = new Properties();
            configFile.load(input);
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties file!");
        }
    }
    public static String getProperty(String keyName) {
        return configFile.getProperty(keyName);
    }
}