package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.LoginPage;

public class LoginTest extends BaseTest{
  @Test
  public void loginTest() {
	  //create login page object
	 objLogin=new LoginPage(getDriver());
	 //verify login page title
	 String loginPageTitle=objLogin.getLogintext();
	 Assert.assertTrue(loginPageTitle.contains("Login"));
  }
}
