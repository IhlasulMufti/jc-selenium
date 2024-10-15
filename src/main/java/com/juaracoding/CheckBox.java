package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckBox {
    public static void main(String[] args) {

        // Firefox
        System.setProperty("webdriver.gecko.driver", "C:\\MyTools\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/checkbox");

        System.out.println("Open browser and maximize");

        // locator : cssSelector
        // checklist: Home
        driver.findElement(By.cssSelector("#tree-node > ol > li > span > label")).click();
        // unchecklist: Home
        driver.findElement(By.cssSelector("#tree-node > ol > li > span > label")).click();

        // expand: Home
        driver.findElement(By.cssSelector("#tree-node > ol > li > span > button")).click();

        // scroll vertical 400 px
        js.executeScript("window.scrollBy(0,400)");

        // checklist: Documents, Downloads
        driver.findElement(By.cssSelector("#tree-node > ol > li > ol > li:nth-child(2) > span > label")).click();
        driver.findElement(By.cssSelector("#tree-node > ol > li > ol > li:nth-child(3) > span > label")).click();

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
