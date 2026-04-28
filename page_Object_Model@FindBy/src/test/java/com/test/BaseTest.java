package com.test;

import com.pages.DashBoard;
import com.pages.LoginPage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    LoginPage objLogin;
    DashBoard objDashBoard;
    public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();

    public WebDriver getDriver() {
        return tdriver.get();
    }

    @BeforeMethod
    public void beforeMethod() {
        WebDriver driver = new ChromeDriver();
        tdriver.set(driver);

        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterMethod
    public void afterMethod() {
        getDriver().quit();
    }
}