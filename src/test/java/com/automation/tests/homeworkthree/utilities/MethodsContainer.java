package com.automation.tests.homeworkthree.utilities;

public class MethodsContainer {

    public static void createDriver() {
//        if (browserName.equalsIgnoreCase("chrome")) {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
//        WebDriver driver = new ChromeDriver();
        //WebDriverManager.chromedriver().version("79").setup();
//            return new ChromeDriver();
//        } else if (browserName.equalsIgnoreCase("firefox")){
//            WebDriverManager.firefoxdriver().setup();
//            return new FirefoxDriver();
//        }else
//            WebDriverManager.iedriver().setup();
//            return new InternetExplorerDriver();
//        }
    }
    public static boolean verifyEquals(String expected, String actual) {
        if (expected.equals(actual)) {
            System.out.println("TEST PASSED");
            return true;
        } else {
            System.out.println("Test failed!!!");
            System.out.println("Expected: " + expected);
            System.out.println("Actual: " + actual);
            return false;
        }
    }

    }