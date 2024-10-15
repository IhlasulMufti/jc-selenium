package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TextBox {
    public static void main(String[] args) {

        // Firefox
        System.setProperty("webdriver.gecko.driver", "C:\\MyTools\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");

        System.out.println("Open browser and maximize");

        // locator: id
        driver.findElement(By.id("userName")).sendKeys("Johan Day");
        driver.findElement(By.id("userEmail")).sendKeys("johan@gmail.com");
        driver.findElement(By.id("currentAddress")).sendKeys("Jakarta");

        // Scroll vertical 500 px
        js.executeScript("window.scrollBy(0, 500)");

        // Continue locator after scroll
        driver.findElement(By.id("permanentAddress")).sendKeys("Makassar");
        driver.findElement(By.id("submit")).click();

        // delay 5 detik sebelum close
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // close windows
        driver.quit();
        System.out.println("Quit browser");
    }
}
