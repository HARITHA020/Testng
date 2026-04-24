package com.test;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class FirstTest {

	    WebDriver driver;
	    public WebDriverWait wait;
	    @BeforeMethod
	    public void beforeMethod() {
	  	  System.out.println("Start the test");
	  	  ChromeOptions options=new ChromeOptions();
	  	  options.addArguments("--start-maximized");
	  	  driver=new ChromeDriver(options);
	  	  //options.addArguments("--headless");
	  	  driver.get("https://demoblaze.com/");
	  	  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  	 // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    }
	    @Test(groups="groupA")
	    public void title() {
	    	String expect="STORE";
	    	String original=driver.getTitle();
	    	Assert.assertEquals(original, expect);
	    	System.out.println("the title is:"+driver.getTitle());
	    	}
	    
	    @Test(groups="groupA")
	    public void validation() {
	    	driver.findElement(By.id("login2")).click();
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
	    	driver.findElement(By.id("loginusername")).sendKeys("admin");
	    	driver.findElement(By.id("loginpassword")).sendKeys("admin");
	    	driver.findElement(By.xpath("//button[text()='Log in']")).click();
	      WebElement logout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout2")));
	      boolean isVisible = logout.isDisplayed();
	      System.out.println("Logout visible: " + isVisible);
	      Assert.assertTrue(isVisible);  
	    }
	    
	    @Test(groups="groupA")
	    public void invaliduser() {
	    	driver.findElement(By.id("login2")).click();
		  	driver.findElement(By.id("loginusername")).sendKeys("hello");
		  	driver.findElement(By.id("loginpassword")).sendKeys("haritha");
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
	    
	    @Test (groups="groupA")
	    public void invalidpassword() {
	    	driver.findElement(By.id("login2")).click();
		  	driver.findElement(By.id("loginusername")).sendKeys("admin");
		  	driver.findElement(By.id("loginpassword")).sendKeys("haritha");
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