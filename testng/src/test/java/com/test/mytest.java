package com.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.Assert;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class mytest {

    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeTest
    public void beforeTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.demoblaze.com/");
    }

    @BeforeMethod
    public void beforeMethod() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("login2"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
    }

    @Test
    public void loginTest() {
        driver.findElement(By.id("loginusername")).sendKeys("admin");
        driver.findElement(By.id("loginpassword")).sendKeys("admin");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        WebElement logout = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("logout2"))
        );

        Assert.assertTrue(logout.isDisplayed());
    }

    @Test(dependsOnMethods = "loginTest")
    public void loginName() {
        driver.findElement(By.id("loginusername")).sendKeys("haritha");
        driver.findElement(By.id("loginpassword")).sendKeys("admin");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        String alertText = wait.until(ExpectedConditions.alertIsPresent()).getText();

        Assert.assertEquals(alertText, "Wrong password.");
    }

    @Test(dependsOnMethods = "loginTest")
    public void loginPassword() {
        driver.findElement(By.id("loginusername")).sendKeys("admin");
        driver.findElement(By.id("loginpassword")).sendKeys("haritha");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        String alertText = wait.until(ExpectedConditions.alertIsPresent()).getText();

        Assert.assertEquals(alertText, "Wrong password.");
    }

    @AfterMethod
    public void afterMethod() {

        try {
            WebElement close = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Close']"))
            );
            close.click();
        } catch (Exception e) {}

        try {
            WebElement logout = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("logout2"))
            );
            logout.click();
        } catch (Exception e) {}
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}