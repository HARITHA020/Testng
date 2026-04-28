package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class LoginPage  extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(name="username")
	public WebElement userName;
	
	@FindBy(name="password")
	public WebElement password;
	
	@FindBy(xpath="//h5[normalize-space()='Login']")
	public WebElement login_text;
	
	@FindBy(css="button[type='submit']")
	public WebElement login;
	
	public void setUserName(String strUserName) {
		userName.sendKeys(strUserName);
	}
	
	public  void setPassword(String strPassword) {
		password.sendKeys(strPassword);
	}
	
	public void clicllogin() {
		login.click();
	}
	
	public String getLogintext() {
		return login_text.getText();
	}
	
	public void login(String strUserName, String strPassword) {
		userName.sendKeys(strUserName);
		password.sendKeys(strPassword);
		login.click();
	}
  }

