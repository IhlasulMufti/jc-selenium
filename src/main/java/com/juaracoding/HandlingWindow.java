package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class HandlingWindow {

    public static void main(String[] args) {

        // Firefox
        System.setProperty("webdriver.gecko.driver", "C:\\MyTools\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Timeout
        driver.manage().window().maximize();                                // Maximize
        driver.get("https://demoqa.com/browser-windows");
        System.out.println("Open browser and maximize");

        driver.findElement(By.id("tabButton")).click();

        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(tab.get(1));
        String txtSampleHeading = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println(txtSampleHeading);
        Utils.delay(3);

        driver.switchTo().window(tab.get(0));
        String txtTitlePage = driver.findElement(By.cssSelector("#browserWindows > h1")).getText();
        System.out.println(txtTitlePage);

        // Navigation
        driver.get("https://demoqa.com/modal-dialogs");
        System.out.println("Current URL: "+driver.getCurrentUrl()); // Modal Dialogs Page
        driver.findElement(By.id("showSmallModal")).click();
        Utils.delay(3);
        driver.findElement(By.id("closeSmallModal")).click();
        Utils.delay(3);

        driver.navigate().back();
        System.out.println("Current URL: "+driver.getCurrentUrl()); // Browser Windows Page
        driver.navigate().refresh();

        // delay 5 detik sebelum close
        Utils.delay(5);
        driver.quit();
        System.out.println("Quit browser");
    }
}
