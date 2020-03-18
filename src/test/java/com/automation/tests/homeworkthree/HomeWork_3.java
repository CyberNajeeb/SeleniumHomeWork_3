package com.automation.tests.homeworkthree;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeWork_3 {

    private WebDriver driver;
    private By dobWarningTextLocator = By.xpath("//small[text()='The date of birth is not valid']");

    @Test
    public void test1() throws InterruptedException {
        driver.findElement(By.name("birthday")).sendKeys("“wrong_dob");
        Thread.sleep(2000);
        WebElement webElement = driver.findElement((dobWarningTextLocator));
        Assert.assertTrue(webElement.isDisplayed());
    }

    @Test
    public void test2() {
        Assert.assertTrue(driver.findElement(By.xpath("//label[text()='C++']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Java']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//label[text()='JavaScript']")).isDisplayed());
    }

    @Test
    public void test3() {
        driver.findElement(By.name("firstname")).sendKeys("N");
        Assert.assertTrue(driver.findElement(By.xpath("//small[text()='first name must be " +
                "more than 2 and less than 64 characters long']")).isDisplayed());
    }

    @Test
    public void test4() {
        driver.findElement(By.name("lastname")).sendKeys("N");
        Assert.assertTrue(driver.findElement(By.xpath("//*[@name='lastname']/following-sibling::small[2]")).isDisplayed());
    }

    @Test
    public void test5() throws InterruptedException {
        driver.findElement(By.name("firstname")).sendKeys("Najeeb");
        driver.findElement(By.name("lastname")).sendKeys("Sahar");
        driver.findElement(By.name("username")).sendKeys("NajSahar");
        driver.findElement(By.name("email")).sendKeys("dsdsahar@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Naj123ABC");
        driver.findElement(By.name("phone")).sendKeys("123-456-7890");
        driver.findElement(By.xpath("//*[@value='male']")).click();
        driver.findElement(By.name("birthday")).sendKeys("01/01/2020");
        driver.findElement(By.name("department")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//option[@value='AO']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//select[@name='job_title']//option[5]")).click();
        Thread.sleep(700);
        driver.findElement(By.id("inlineCheckbox1")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("wooden_spoon")).click();
        Thread.sleep(2000);

        Assert.assertTrue(driver.findElement(By.xpath("//p")).isDisplayed());
    }

    @BeforeMethod
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://practice-cybertekschool.herokuapp.com/registration_form");
        Thread.sleep(2000);

    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();

            driver = null;
        }
    }
}
