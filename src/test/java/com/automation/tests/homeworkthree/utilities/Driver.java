package com.automation.tests.homeworkthree.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Driver {
    private static WebDriver driver;
    private Driver(){

    }
    public static WebDriver getDriver(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(true);
        if (driver == null){
            String browser = ConfigReader.getProperty("browser");
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().version("79").setup();
                    driver = new ChromeDriver(chromeOptions);
                    driver.manage().window().maximize();
                    break;
                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.setHeadless(true);
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
                default:
                    throw new RuntimeException("wrong browser name");
            }
        }
        return driver;
    }
    public static void closeDriver(){
        if (driver!=null){
            driver.quit();
            driver = null;
        }
    }

}
