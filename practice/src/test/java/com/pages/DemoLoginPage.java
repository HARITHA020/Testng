package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class DemoLoginPage extends MainPage {
	public DemoLoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="login2")
	WebElement loginlink;
	
	@FindBy(id="loginusername")
	WebElement username;
	
	@FindBy(id="loginpassword")
	WebElement password;
	
	@FindBy(xpath="//button[text()='Log in']")
	WebElement loginbtn;
	
	public void logintest(String name, String pass) {
		loginlink.click();
		username.sendKeys(name);
		password.sendKeys(pass);
		loginbtn.click();
	}
 
}
