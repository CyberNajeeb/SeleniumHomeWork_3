package com.automation.tests.homeworkthree.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserUtils {

    public static void wait(int seconds){
        try {
            Thread.sleep(1000* seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void practiceWebsiteLocators() {
        WebDriver driver = new ChromeDriver();
        driver.findElement(By.name("firstname")).sendKeys("Najeeb");
        driver.findElement(By.name("lastname")).sendKeys("Sahar");
        driver.findElement(By.name("username")).sendKeys("NajSahar");
        driver.findElement(By.name("email")).sendKeys("dsdsahar@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Naj123ABC");
        driver.findElement(By.name("phone")).sendKeys("123-456-7890");
        driver.findElement(By.xpath("//*[@value='male']")).click();
        driver.findElement(By.name("birthday")).sendKeys("01/01/2020");
        driver.findElement(By.name("department")).click();
        wait(2);
        driver.findElement(By.xpath("//option[@value='AO']")).click();
        wait(2);
        driver.findElement(By.xpath("//select[@name='job_title']//option[5]")).click();
        wait(2);
        driver.findElement(By.id("inlineCheckbox1")).click();
        wait(2);
        driver.findElement(By.id("wooden_spoon")).click();
        wait(2);

    }
}
