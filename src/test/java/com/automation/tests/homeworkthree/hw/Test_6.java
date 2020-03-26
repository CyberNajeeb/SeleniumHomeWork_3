package com.automation.tests.homeworkthree.hw;

import com.automation.tests.homeworkthree.utilities.BrowserUtils;
import com.automation.tests.homeworkthree.utilities.MethodsContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_6 {
    WebDriver driver;

    @Test
    public void test6(){
        String email = driver.findElement(By.id("email")).getText();
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        driver.findElement(By.name("full_name")).sendKeys("abc123def");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.cssSelector("[type=\"submit\"]")).click();
        String expectedText = "Thank you for signing up. Click the button below to return to the home page.";
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals(expectedText, actualText);

        driver.navigate().to("https://www.tempmailaddress.com");
        BrowserUtils.wait(2);
        String actualEmailText = driver.findElement(By.xpath("//*[@id=\"schranka\"]/tr[1]/td[1]")).getText().trim();
        String emailConfirm = "do-not-reply@practice.cybertekschool.com";
        Assert.assertEquals(actualEmailText, emailConfirm);
    }
    @BeforeMethod
    public void setup() {
        MethodsContainer.createDriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tempmailaddress.com");
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();

            driver = null;
        }
    }
}
