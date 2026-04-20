package com.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.Assert;

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

public class parameter {
	WebDriver driver;
    public WebDriverWait wait;
    
    @BeforeMethod
    @Parameters({"browser","url"})
    public void beforeMethod(String browser,String url) {
		if (browser.equalsIgnoreCase("firefox")) {
			System.out.println("Start the test");
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--start-maximized");
			driver = new FirefoxDriver(options);
			// options.addArguments("--headless");
			System.out.println("Browser started:" + browser);	
		}
		else if (browser.equalsIgnoreCase("chrome")) {
			System.out.println("Start the test");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);
			// options.addArguments("--headless");
			System.out.println("Browser started:" + browser);
		}  
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get(url);
	}
    
    @Test
    public void title() {
    	String expect="STORE";
    	String original=driver.getTitle();
    	Assert.assertEquals(original, expect);
    	System.out.println("the title is:"+driver.getTitle());
    	}
    
    @Test
    @Parameters({"name","pass"})
    public void validation(String name,String pass) {
    	driver.findElement(By.id("login2")).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
    	driver.findElement(By.id("loginusername")).sendKeys(name);
    	driver.findElement(By.id("loginpassword")).sendKeys(pass);
    	driver.findElement(By.xpath("//button[text()='Log in']")).click();
      WebElement logout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout2")));
      boolean isVisible = logout.isDisplayed();
      System.out.println("Logout visible: " + isVisible);
      Assert.assertTrue(isVisible);  
    }
    
    @Test
    @Parameters({"iname","ipass"})
    public void invaliduser(String iname,String ipass) {
    	driver.findElement(By.id("login2")).click();
	  	driver.findElement(By.id("loginusername")).sendKeys(iname);
	  	driver.findElement(By.id("loginpassword")).sendKeys(ipass);
	    driver.findElement(By.xpath("//button[text()='Log in']")).click();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    try {
	        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	        String msg = alert.getText();
	        System.out.println(msg);
	        System.out.println("invalid name");
	        Assert.assertTrue(msg.contains("Wrong"));
	        alert.accept();

	    } catch (Exception e) {
	        String user = driver.findElement(By.id("nameofuser")).getText();
	        System.out.println("Logged in: " + user);
	        Assert.fail("Expected alert, but login succeeded");
	    }
    }
    
    @Test
    @Parameters({"iname1","ipass1"})
    public void invalidpassword(String iname1,String ipass1) {
    	driver.findElement(By.id("login2")).click();
	  	driver.findElement(By.id("loginusername")).sendKeys(iname1);
	  	driver.findElement(By.id("loginpassword")).sendKeys(ipass1);
	    driver.findElement(By.xpath("//button[text()='Log in']")).click();
	    
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	    String alertMessage = alert.getText();
	    System.out.println(alertMessage);
	    Assert.assertEquals(alertMessage, "Wrong password.");
	    alert.accept();
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}