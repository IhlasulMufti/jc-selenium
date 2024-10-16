package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class HandlingFrame {

    public static void main(String[] args) {

        // Firefox
        System.setProperty("webdriver.gecko.driver", "C:\\MyTools\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Timeout
        driver.manage().window().maximize();                                // Maximize
        driver.get("https://demoqa.com/frames");
        System.out.println("Open browser and maximize");

        js.executeScript("window.scrollBy(0,100)");

        WebElement frameOne = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frameOne);
        String txtSampleHeading = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println(txtSampleHeading);

        driver.switchTo().defaultContent();

        String txtHeader = driver.findElement(By.cssSelector("#framesWrapper > h1")).getText();
        System.out.println(txtHeader);

        // delay 5 detik sebelum close
        Utils.delay(5);
        driver.quit();
        System.out.println("Quit browser");
    }
}
