package com.juaracoding;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumCollection {

    public static void main(String[] args) {

        // Firefox
        System.setProperty("webdriver.gecko.driver", "C:\\MyTools\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Timeout
        driver.manage().window().maximize();                                // Maximize
        System.out.println("Open browser and maximize");

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

/*        // Collection + Negative Login Test
        List<WebElement> listInput = driver.findElements(By.xpath("//input"));
        System.out.println("Jumlah tag html input: "+listInput.size());

        for (WebElement input : listInput){
            System.out.println(input.getAttribute("type"));
        }

        for (int i = 1; i < listInput.size(); i++) {
            listInput.get(i).sendKeys("invalid");
        }
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String invalidAlert = driver.findElement(By.xpath("//p[contains(@class, 'alert-content')]")).getText();
        System.out.println(invalidAlert);
        OrangeHRM.customAssertEquals(invalidAlert, "Invalid credentials");

        // Positive Login Test
        OrangeHRM.loginTest(driver, "Admin", "admin123");
        String dashboardTitle = driver.findElement(By.xpath("//h6[contains(@class, 'header')]")).getText();
        System.out.println(dashboardTitle);
        OrangeHRM.customAssertEquals(dashboardTitle, "Dashboard");

        // List Menu
        List<WebElement> menuList = driver.findElements(By.xpath("//span[contains(@class, 'main-menu-item')]"));
        System.out.println(menuList.size());

        for (WebElement menu : menuList){
            System.out.println(menu.getText());
        }*/

        // sendKeys
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Selenium");
        Utils.delay(2);
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(Keys.CONTROL+"A");
        Utils.delay(2);
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(Keys.DELETE);


        // Test Tokopedia
/*        driver.get("https://www.tokopedia.com/");
        List<WebElement> trends = driver.findElements(By.xpath("//a[@data-testid='trendkingKeywordList']"));
        System.out.println(trends.size());

        for (WebElement trend : trends){
            System.out.println(trend.getText());
        }*/

        // delay 5 detik sebelum close
        Utils.delay(5);
        driver.quit();
        System.out.println("Quit browser");

    }

}
