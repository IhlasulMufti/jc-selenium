package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumActions {

    public static void main(String[] args) {

        // Firefox
        System.setProperty("webdriver.gecko.driver", "C:\\MyTools\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Timeout
        driver.manage().window().maximize();                                // Maximize
        System.out.println("Open browser and maximize");
        driver.get("https://www.browserstack.com/");

        WebElement menuProduct = driver.findElement(By.xpath("//button[@id='products-dd-toggle']"));
        WebElement menuDeveloper = driver.findElement(By.xpath("//button[@id='developers-dd-toggle']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(menuProduct).build().perform();
        Utils.delay(3);
        actions.moveToElement(menuDeveloper).build().perform();
        Utils.delay(3);

        List<WebElement> menuDeveloperList = driver.findElements(By.xpath("//div[@class='bstack-mm-sub-li']"));
        System.out.println(menuDeveloperList.size());
        menuDeveloperList.get(0).click();
        Utils.delay(2);
        driver.navigate().back();

        WebElement menuDevelopers = driver.findElement(By.xpath("//button[@id='developers-dd-toggle']"));
        actions.moveToElement(menuDevelopers).build().perform();

        // delay 5 detik sebelum close
        Utils.delay(5);
        driver.quit();
        System.out.println("Quit browser");

    }

}
