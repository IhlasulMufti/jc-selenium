package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class HandlingSelect {

    public static void main(String[] args) {

        // Firefox
        System.setProperty("webdriver.gecko.driver", "C:\\MyTools\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Timeout
        driver.manage().window().maximize();                                // Maximize
        driver.get("https://demoqa.com/select-menu");
        System.out.println("Open browser and maximize");

        //*[@id="selectMenuContainer"]/h1 -> copy Xpath Inspect
        //h1[@class='text-center']  -> Selector Hub
        String txtTitlePage = driver.findElement(By.xpath("//*[@id=\"selectMenuContainer\"]/h1")).getText();
        System.out.println(txtTitlePage);

        js.executeScript("window.scrollBy(0,300)");
        WebElement selectColor = driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(selectColor);
        select.selectByIndex(7);
        Utils.delay(3);
        select.selectByValue("red");
        Utils.delay(3);
        select.selectByVisibleText("Indigo");
        Utils.delay(3);

        // delay 5 detik sebelum close
        Utils.delay(5);
        driver.quit();
        System.out.println("Quit browser");

    }

}
