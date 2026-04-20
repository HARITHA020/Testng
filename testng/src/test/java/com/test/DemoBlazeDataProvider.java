package com.test;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Assert;

public class DemoBlazeDataProvider {
    ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    ThreadLocal<WebDriverWait> wait = new ThreadLocal<>();
    public WebDriver getDriver() {
        return driver.get();
    }

    public WebDriverWait getWait() {
        return wait.get();
    }
    @BeforeMethod
    @Parameters({"browser","url"})
    public void beforeMethod(String browser, String url) {

        if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--start-maximized");
            driver.set(new FirefoxDriver(options));
        }
        else if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            driver.set(new ChromeDriver(options));
        }

        wait.set(new WebDriverWait(getDriver(), Duration.ofSeconds(10)));
        getDriver().get(url);
        System.out.println("Browser started: " + browser);
    }
    @Test
    public void title() {
        String expected = "STORE";
        String actual = getDriver().getTitle();
        Assert.assertEquals(actual, expected);
        System.out.println("Title: " + actual);
    }
 
    @Test
    public void validation() {
        getDriver().findElement(By.id("login2")).click();
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
        getDriver().findElement(By.id("loginusername")).sendKeys("admin");
        getDriver().findElement(By.id("loginpassword")).sendKeys("admin");
        getDriver().findElement(By.xpath("//button[text()='Log in']")).click();
        WebElement logout = getWait().until(ExpectedConditions.visibilityOfElementLocated(By.id("logout2")));
        Assert.assertTrue(logout.isDisplayed());
        System.out.println("Login successful");
    }
    @DataProvider(name="testData", parallel=true)
    public Object[][] dataProv(){
        return new Object[][] {
            {"Hello","haritha"},
            {"admin","haritha"}
        };
    }
    @Test(dataProvider="testData")
    public void invalid(String iname, String ipass) {

        getDriver().findElement(By.id("login2")).click();
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
        getDriver().findElement(By.id("loginusername")).sendKeys(iname);
        getDriver().findElement(By.id("loginpassword")).sendKeys(ipass);
        getDriver().findElement(By.xpath("//button[text()='Log in']")).click();
        try {
            Alert alert = getWait().until(ExpectedConditions.alertIsPresent());
            String msg = alert.getText();
            System.out.println("Alert: " + msg);
            Assert.assertTrue(msg.contains("Wrong"));
            alert.accept();
        } catch (Exception e) {
            String user = getDriver().findElement(By.id("nameofuser")).getText();
            System.out.println("Logged in: " + user);
            Assert.fail("Expected alert, but login succeeded");
        }
    }
    @AfterMethod
    public void after() {
        getDriver().quit();
        System.out.println("Browser closed");
    }
}