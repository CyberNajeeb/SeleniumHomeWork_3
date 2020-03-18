package com.automation.tests.homeworkthree.officHour;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.Key;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Vytrack {
    private WebDriver driver;

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://qa3.vytrack.com");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//ul[@class='quick-launchpad-toolbar']//li[2]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/div/div/div[2]/div[2]/a")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getTitle(), "Create Contact - Contacts - Customers");
    }

    public static void main(String[] args) {


        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("First Name", "John");
        hashMap.put("Last Name", "Doe");
        hashMap.put("Phone Number", "123-456-7890");
        hashMap.put("Street Address", "123 456th Ave");
        hashMap.put("City", "LA");
        hashMap.put("State", "CA");
        hashMap.put("Zip code", "90032");
        hashMap.put("Country", "United States");
        hashMap.put("sales group", "true");

        System.out.println("hashMap = " + hashMap.get("First Name"));
    }
    @BeforeMethod
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(2000);

    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            //close browser, close session
            driver.quit();
            //destroy webdriver object for sure
            driver = null;
        }
    }
}