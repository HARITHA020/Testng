package com.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.support.PageFactory;

import com.pages.LoginPageLocator;
import com.utilities.Baseclass;

public class LoginPageAction {
	LoginPageLocator loginpagelocator =null;
	String strusername, strpassword;
	
	public LoginPageAction() {
		this.loginpagelocator = new LoginPageLocator();
		PageFactory.initElements(Baseclass.getDriver(), loginpagelocator);
	}
	
	public void setusername(String strusername) {
		loginpagelocator.username.sendKeys(strusername);
	}
	
	public void setpassword(String strpassword) {
		loginpagelocator.password.sendKeys(strpassword);
	}
	
	public void clickLogin() {
		loginpagelocator.login.click();
	}
	
	public void login() {
		File file= new File("C:\\Users\\HARITHA\\OneDrive\\Desktop\\testng\\TutorialninjaPOM\\src\\test\\resources\\logindata.properties");
		FileInputStream fileInput=null;
		
		try {
			fileInput = new FileInputStream(file);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Properties prop= new Properties();
		
		try {
			prop.load(fileInput);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		strusername = prop.getProperty("username");
		strpassword=prop.getProperty("password");
		
		this.setusername(strusername);
		
		this.setpassword(strpassword);
		
		this.clickLogin();
		
	}
}
