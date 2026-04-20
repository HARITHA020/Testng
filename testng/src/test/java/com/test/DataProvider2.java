package com.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;


public class DataProvider2 {
	WebDriver driver;
	
  @BeforeMethod
  public void setup() {
	  System.out.println("Start the test");
	  driver=new ChromeDriver();
	  driver.get("https://www.bing.com/");
	  driver.manage().window().maximize();
  }

  @AfterMethod
  public void tearDown() {
	  driver.quit();
  } 
  
  @Test(dataProvider = "dp", dataProviderClass=DPClassDemo.class)
  public void search(String  keyword) {
	  WebElement s=driver.findElement(By.id("sb_form_q"));
	  s.sendKeys(keyword);
	  System.out.println("Keyword: "+keyword);
	  s.sendKeys(Keys.ENTER);
  }


 
  }