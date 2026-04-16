package com.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class FirstTest {
	public WebDriver driver;
  @Test
  public void loginTest() {
	  driver.findElement(By.cssSelector("#login2")).click();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  driver.findElement(By.cssSelector("#loginusername")).sendKeys("admin");
	  driver.findElement(By.cssSelector("#loginpassword")).sendKeys("admin");
	  driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[3]")).click();
	  
  }
  @BeforeTest
  public void beforeTest() {
	  ChromeOptions options = new ChromeOptions();
	 // driver.manage().window().maximize();
	  options.addArguments("--start-maximized");
	  //options.addArguments("--headless");
	  driver=new ChromeDriver(options);
	  driver.get("https://www.demoblaze.com/");
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
