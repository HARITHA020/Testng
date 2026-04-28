package com.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class priorityprac {
	WebDriver driver;
	WebDriverWait wait;
	@BeforeMethod
	public void method() {
		System.out.println("Start test");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--start--maximized");
		driver= new ChromeDriver(options);
		driver.get("https://www.demoblaze.com/");
		wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	}
	@Test(priority=1)
	public void open() {
		System.out.println("geting title");
		String expect="STORE";
    	String original=driver.getTitle();
    	Assert.assertEquals(original, expect);
    	System.out.println("the title is:"+driver.getTitle());
	}
	
	@Test(priority=3)
	public void login() {
		System.out.println("geting loging");
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
	
	@Test(priority=2)
	public void cart() {
		System.out.println("click cart");
		driver.findElement(By.cssSelector("#cartur")).click();
		WebElement val=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='col-lg-8'] h2")));
		System.out.println("the val of cart page is:"+val.getText());
	}
	
	@AfterMethod
	public void stop() {
		driver.quit();
	}
}
