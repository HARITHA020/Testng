package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider1 {
	@DataProvider(name="testData",parallel=true)
	public Object[][] dataProv(){
		return new Object[][] {
			{"selenium"},{"TestNG"}
		};
	}
	private static final ThreadLocal <WebDriver> driver=new ThreadLocal<WebDriver>();
	@BeforeMethod
	public void setUp() {
		System.out.println("Start the test");
		driver.set(new ChromeDriver());
	}
  @Test(dataProvider="testData")
  public void search(String keyWord) throws InterruptedException {
	  WebDriver driver1= driver.get();
	  driver1.get("https://www.bing.com/");
	  WebElement box= driver1.findElement(By.id("sb_form_q"));
	  box.sendKeys(keyWord);
	  System.out.println("keyword entered:"+keyWord);
	  box.sendKeys(Keys.ENTER);
	  System.out.println("the keyword is displayed");
  }
  @AfterMethod
  public void testDown() {
	  WebDriver driver1=driver.get();
	  System.out.println("Afternmethid thread id:"+Thread.currentThread());
	  if(driver1!=null) {
		  driver1.quit();
	  }
  }
}
