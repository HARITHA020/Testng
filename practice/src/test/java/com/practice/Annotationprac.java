package com.practice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Annotationprac {
	WebDriver driver;
	WebDriverWait wait;
  @Test
  public void title() {
  	String expect="STORE";
  	String original=driver.getTitle();
  	Assert.assertEquals(original, expect);
  	System.out.println("the title is:"+driver.getTitle());
  	}
  @BeforeMethod
  public void beforeMethod() {
  	  System.out.println("Start the test");
  	  ChromeOptions options=new ChromeOptions();
  	  options.addArguments("--start-maximized");
  	  driver=new ChromeDriver(options);
  	  //options.addArguments("--headless");
  	  driver.get("https://demoblaze.com/");
  	  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
