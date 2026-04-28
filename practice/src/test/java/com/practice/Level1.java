package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Level1 {
	WebDriver driver;
	@BeforeMethod
	public void start() {
		 ChromeOptions options=new ChromeOptions();
	  	  options.addArguments("--start-maximized");
	  	  driver=new ChromeDriver(options);
	  	  driver.get("https://www.saucedemo.com/");
	}
  @Test
  public void test() {
	  WebElement name= driver.findElement(By.cssSelector("#user-name"));
	  name.sendKeys("standard_user");
	  WebElement pass= driver.findElement(By.cssSelector("#password"));
	  pass.sendKeys("secret_sauce");
	  WebElement login = driver.findElement(By.cssSelector("#login-button"));
	  login.click();
	  Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
  }
  
  @AfterMethod
  public void teardown() {
	  driver.quit();
  }
}
