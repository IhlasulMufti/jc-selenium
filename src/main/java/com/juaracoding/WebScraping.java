package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class WebScraping {
    public static void main(String[] args) {

        // Firefox
        System.setProperty("webdriver.gecko.driver", "C:\\MyTools\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Timeout
        driver.manage().window().maximize();                                // Maximize
        driver.get("https://demoqa.com/webtables");

        System.out.println("Open browser and maximize");

        // web scraping
        String txtHeader = driver.findElement(By.cssSelector("#app > div > div > div > " +
                "div.col-12.mt-4.col-md-6 > h1")).getText();
        System.out.println(txtHeader);

        // get tag title
        String tagTitle = driver.getTitle();
        System.out.println(tagTitle);

        // get current url
        String currentURL = driver.getCurrentUrl();
        System.out.println(currentURL);

        // delay 5 detik sebelum close
        Utils.delay(5);
        driver.quit();
        System.out.println("Quit browser");
    }
}
