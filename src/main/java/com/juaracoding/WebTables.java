package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebTables {
    public static void main(String[] args) {

        // Firefox
        System.setProperty("webdriver.gecko.driver", "C:\\MyTools\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/webtables");

        System.out.println("Open browser and maximize");

        // Add data (10 Record)
        for (int i = 0; i < 10; i++) {
            driver.findElement(By.id("addNewRecordButton")).click();
            driver.findElement(By.id("submit")).click();
            driver.findElement(By.id("firstName")).sendKeys("John");
            driver.findElement(By.id("lastName")).sendKeys("Cena");
            driver.findElement(By.id("userEmail")).sendKeys("john@juaracoding.co.id");
            driver.findElement(By.id("age")).sendKeys("35");
            driver.findElement(By.id("salary")).sendKeys("8000");
            driver.findElement(By.id("department")).sendKeys("QA");
            driver.findElement(By.id("submit")).click();
        }

        // SearchBox
        driver.findElement(By.id("searchBox")).sendKeys("Kierra");
        js.executeScript("window.scrollBy(0,150)");
        // delay 2 detik sebelum clear search
        Utils.delay(2);
        driver.findElement(By.id("searchBox")).clear();

        // scroll vertical: untuk edit data
        js.executeScript("window.scrollBy(0,400)");

        // Edit data (name)
        driver.findElement(By.id("edit-record-1")).click();
        driver.findElement(By.id("firstName")).clear();
        driver.findElement(By.id("firstName")).sendKeys("Sharon");
        driver.findElement(By.id("submit")).click();

        // scroll vertical: untuk next page di bawah
        js.executeScript("window.scrollBy(0,400)");

        // Change page (Next)
        driver.findElement(By.cssSelector(".-next > button:nth-child(1)")).click();
        // Change page (Previous)
        driver.findElement(By.cssSelector(".-previous > button:nth-child(1)")).click();


        // scroll vertical: kembali ke atas
        js.executeScript("window.scrollBy(0,-400)");

        // Remove data (10 record)
        for (int i = 1; i <= 10; i++) {
            driver.findElement(By.id("delete-record-" + i)).click();
        }

        // delay 5 detik sebelum close
        Utils.delay(5);
        driver.quit();
        System.out.println("Quit browser");
    }
}
