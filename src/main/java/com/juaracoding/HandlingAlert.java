package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class HandlingAlert {
    public static void main(String[] args) {

        // Firefox
        System.setProperty("webdriver.gecko.driver", "C:\\MyTools\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Timeout
        driver.manage().window().maximize();                                // Maximize
        driver.get("https://demoqa.com/alerts");
        System.out.println("Open browser and maximize");

        js.executeScript("window.scrollBy(0,300)");

        driver.findElement(By.id("alertButton")).click();
        Utils.delay(3);
        driver.switchTo().alert().accept(); // OK
        System.out.println("Alert Button");

        driver.findElement(By.id("timerAlertButton")).click();
        Utils.delay(5);
        driver.switchTo().alert().accept(); // OK
        System.out.println("Timer Alert Button");

        driver.findElement(By.id("confirmButton")).click();
        Utils.delay(3);
        driver.switchTo().alert().dismiss(); // Cancel
        System.out.println("Confirm Button");

        driver.findElement(By.id("promtButton")).click();
        Utils.delay(3);
        driver.switchTo().alert().sendKeys("JuaraCoding");
        driver.switchTo().alert().accept();
        System.out.println("Prompt Button");

        // delay 5 detik sebelum close
        Utils.delay(5);
        driver.quit();
        System.out.println("Quit browser");
    }
}
