package com.automation.tests.homeworkthree.hw;

import com.automation.tests.homeworkthree.utilities.BrowserUtils;
import com.automation.tests.homeworkthree.utilities.MethodsContainer;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
    }

    private WebDriver driver;
    private By dobWarningTextLocator = By.xpath("//small[text()='The date of birth is not valid']");

    @Test
    public void test1() throws InterruptedException {
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.name("birthday")).sendKeys("wrong_dob");
        Thread.sleep(2000);

        WebElement actualText = driver.findElement((dobWarningTextLocator));
        String expectedText = "The date of birth is not valid";

        MethodsContainer.verifyEquals(actualText.getText(), expectedText);
        Assert.assertEquals(actualText.getText(), expectedText);
        Assert.assertTrue(actualText.isDisplayed());
    }


    @Test
    public void test2() {
        driver.findElement(By.linkText("Registration Form")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//label[text()='C++']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Java']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//label[text()='JavaScript']")).isDisplayed());
    }

    @Test
    public void test3() {
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.name("firstname")).sendKeys("N");
        Assert.assertTrue(driver.findElement(By.xpath("//small[text()='first name must be " +
                "more than 2 and less than 64 characters long']")).isDisplayed());
    }

    @Test
    public void test4() {
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.name("lastname")).sendKeys("N");
        Assert.assertTrue(driver.findElement(By.xpath("//*[@name='lastname']/following-sibling::small[2]")).isDisplayed());
    }

    @Test
    public void test5() throws InterruptedException {
        driver.findElement(By.linkText("Registration Form")).click();
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

    @Test
    public void test12() throws InterruptedException {
        driver.findElement(By.linkText("Status Codes")).click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.linkText("500")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/div/ul/li[4]/a")).isDisplayed());

        driver.findElement(By.xpath("//*[@id='content']/div/ul/li[4]/a")).click();
        Thread.sleep(2000);

        if(driver.findElement(By.xpath("//p")).getText().contains( "This page returned a 500 status code")){
            System.out.println("Test passed");
        }else {
            System.out.println("Test failed");
        }
    }
    @Test
    public void test6(){
        driver.get("https://www.tempmailaddress.com");
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
    @Test
    public void test7(){
        driver.findElement(By.linkText("File Upload")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.id("file-upload")).sendKeys("/Users/mohammadsohrabi/Downloads/Text.txt");
        BrowserUtils.wait(2);
        driver.findElement(By.id("file-submit")).click();
        BrowserUtils.wait(3);
        String verify = driver.findElement(By.xpath("//h3")).getText();
        String actual = "File Uploaded!";
        Assert.assertEquals(verify, actual);
    }
    @Test
    public void test8(){
        driver.findElement(By.linkText("Autocomplete")).click();
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");
        driver.findElement(By.xpath("//input[@type='button']")).click();
        BrowserUtils.wait(3);
        String expected = "You selected: United States of America";
        String actual = driver.findElement(By.xpath("//*[@id='result']")).getText();
        MethodsContainer.verifyEquals(expected,actual);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void test9(){

    }

    @BeforeMethod
    public void setup() throws InterruptedException {
        MethodsContainer.createDriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://practice-cybertekschool.herokuapp.com");
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
