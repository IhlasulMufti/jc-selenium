package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class OrangeHRM {

    public static void main(String[] args) {

        // Firefox
        System.setProperty("webdriver.gecko.driver", "C:\\MyTools\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Timeout
        driver.manage().window().maximize();                                // Maximize
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        System.out.println("Open browser and maximize");

        // Positive Login Test
        loginTest(driver, "Admin", "admin123");
        String dashboardTitle = driver.findElement(By.xpath("//h6[contains(@class, 'header')]")).getText();
        System.out.println(dashboardTitle);
        customAssertEquals(dashboardTitle, "Dashboard");

        // Logout
        driver.findElement(By.xpath("//i[contains(@class, 'userdropdown')]")).click();
        driver.findElement(By.linkText("Logout")).click();

        // Negative Login Test
        loginTest(driver, "invalid", "invalid");
        String invalidAlert = driver.findElement(By.xpath("//p[contains(@class, 'alert-content')]")).getText();
        System.out.println(invalidAlert);
        customAssertEquals(invalidAlert, "Invalid credentials");

        // delay 5 detik sebelum close
        Utils.delay(5);
        driver.quit();
        System.out.println("Quit browser");

    }

    public static void customAssertEquals(String actual, String expected){
        if (actual.equals(expected)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
    }

    public static void loginTest(WebDriver driver, String username, String password){
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

}
