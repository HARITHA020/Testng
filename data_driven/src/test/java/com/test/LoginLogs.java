package com.test;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.util.DHExcel;

public class LoginLogs {

	private static final ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private static final Logger log= LogManager.getLogger(LoginLogs.class);
	
	@BeforeMethod
	public void setup() {
	    System.out.println("Start the test");
	    WebDriver driver1 = new ChromeDriver();
	    driver.set(driver1);
	    driver1.get("https://www.demoblaze.com/");
	    driver1.manage().window().maximize();
	    log.info("Moved to the website");
	}


	@AfterMethod
	public void tearDown() {
		WebDriver driver1 = driver.get();
		if (driver1 != null)
			driver1.quit();
		    log.info("the browser is closed");
	}

	@Test(dataProvider="valid", dataProviderClass=DHExcel.class)
	public void valid(String name, String password) {

	    WebDriver driver1 = driver.get();
	    log.info("Starting valid login test");
	    driver1.findElement(By.id("login2")).click();
	    log.info("Clicked on login button");
	    WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys(name);
	    log.info("Entered username: " + name);
	    driver1.findElement(By.id("loginpassword")).sendKeys(password);
	    log.info("Entered password");
	    driver1.findElement(By.xpath("//button[text()='Log in']")).click();
	    log.info("Clicked login submit");
	    try {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
	        String actual = driver1.findElement(By.id("nameofuser")).getText();
	        log.info("Login successful, message: " + actual);
	        if (actual.contains("Welcome")) {
	            log.info("user is valid ");
	        } else {
	            log.warn("login fails due to expected word not occured");
	        }
	    } catch (Exception e) {
	        log.error("Login failed due to exception: " + e.getMessage());
	    }
	}

	@Test(dataProvider="invalid", dataProviderClass=DHExcel.class)
	public void Invalid1(String name, String password) {
	    WebDriver driver1 = driver.get();
	    log.info("Starting invalid login test");
	    driver1.findElement(By.id("login2")).click();
	    log.info("Clicked on login button");
	    WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys(name);
	    log.info("Entered username: " + name);
	    driver1.findElement(By.id("loginpassword")).sendKeys(password);
	    log.info("Entered password");
	    driver1.findElement(By.xpath("//button[text()='Log in']")).click();
	    log.info("Clicked login submit");
	    try {
	        wait.until(ExpectedConditions.alertIsPresent());
	        Alert alert = driver1.switchTo().alert();
	        String alertText = alert.getText();
	        log.info("Alert displayed: " + alertText);
	        alert.accept();
	        log.info("Alert accepted");
	    } catch (Exception e) {
	        log.error("invalid login failed");
	    }
	}

}