package com.test;


import org.testng.annotations.Test;
import com.pages.DemoLoginPage;

public class LoginTest extends MainTest{
  @Test
  public void login() {
	  logpage = new DemoLoginPage(driver);
	 
	  logpage.logintest("admin", "admin");	  
  }
}
