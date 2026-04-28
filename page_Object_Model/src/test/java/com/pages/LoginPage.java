package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginPage {
	WebDriver driver;
	By username =By.cssSelector("[name=\"username\"]");
	By password =By.cssSelector("[name=\"password\"]");
	By titleText =By.xpath("//h5[normalize-space()='Login']");
	By login=By.cssSelector("button[type='submit']");
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void setUserName(String strUserName) {
		driver.findElement(username).sendKeys(strUserName);
	}
	
	public  void setPassword(String strPassword) {
		driver.findElement(password).sendKeys(strPassword);
	}
	
	public void clicllogin() {
		driver.findElement(login).click();
	}
	
	public String getLogintext() {
		return driver.findElement(titleText).getText();
	}
	
	public void login(String strUserName, String strPassword) {
		//fill the user name
		this.setUserName(strUserName);
		//fill the password
		this.setPassword(strPassword);
		//click the login button
		this.clicllogin();
	}
  }

