package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RadioButton {
    public static void main(String[] args) {

        // Firefox
        System.setProperty("webdriver.gecko.driver", "C:\\MyTools\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/radio-button");

        System.out.println("Open browser and maximize");

        // locator : cssSelector
        driver.findElement(By.cssSelector("#app > div > div > div > div.col-12.mt-4.col-md-6 > " +
                "div:nth-child(3) > div:nth-child(2) > label")).click();
        driver.findElement(By.cssSelector("#app > div > div > div > div.col-12.mt-4.col-md-6 > " +
                "div:nth-child(3) > div:nth-child(3) > label")).click();

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
