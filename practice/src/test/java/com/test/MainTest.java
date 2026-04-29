package com.test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;


import com.pages.CartPage;
import com.pages.DemoLoginPage;
import com.pages.HomePage;
import com.pages.productPage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;



public class MainTest {
	WebDriver driver;
	WebDriverWait wait;
	HomePage home;
	DemoLoginPage logpage;
	productPage product;
	CartPage cart;
	 @BeforeClass
	    public void start() {
	        System.out.println("Start the test ");

	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--start-maximized");

	        driver = new ChromeDriver(options);
	        driver.get("https://demoblaze.com/");

	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }

	    @AfterClass
	    public void stop() {
	        driver.quit();
	    }
  
}
