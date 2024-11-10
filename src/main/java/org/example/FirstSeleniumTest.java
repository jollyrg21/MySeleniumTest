package org.example;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import java.io.IOException;


public class FirstSeleniumTest {
    public String driverPath = "/Users/Jolly/code/java/drivers/chromedriver";
    public WebDriver driver;
    public String URL = "https://www.amazon.com";

    @BeforeTest
    public void launchBrowser () {
    System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get(URL);
    }
    @Test
    public void clickSignIn() throws InterruptedException {
        //WebDriverWait wait;
        //wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'nav-line-2 ')]")));
        Actions builder = new Actions(driver);
        WebElement hoverElement = driver.findElement(By.id("nav-link-accountList"));
        builder.moveToElement(hoverElement).perform();
        WebDriverWait wait;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Sign')]")));
// click on the compose button as soon as the "compose" button is visible
        WebElement signInButton = driver.findElement(By.xpath("//span[contains(text(),'Sign')]"));
        //WebElement element = driver.findElement(By.xpath("//span[@name='emailid']"));
        //element.sendKeys("abc@gmail.com");
        //WebElement button=driver.findElement(By.xpath("//input[@name='btnLogin']"));
        signInButton.click();
        Thread.sleep(3000);
        driver.navigate().back();
    }

    @Test
    public void findProductandAdd () {
        WebElement product = driver.findElement(By.xpath("//img[contains(text(),'Skincare')]"));
        product.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        WebElement product2add = driver.findElement(By.xpath("//button[contains(text(),'Add')]"));
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}

