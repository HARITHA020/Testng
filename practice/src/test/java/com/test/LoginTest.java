package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.DemoLoginPage;
import com.pages.HomePage;

public class LoginTest extends MainTest{
  @Test
  public void login() {
	  logpage = new DemoLoginPage(driver);
	  logpage.logintest("admin", "admin");
	  home = new HomePage(driver);
	  home.waitForLogout(wait);
	  Assert.assertTrue(home.logout(), "Login failed - Logout not visible");
	  
	  
  }
}
