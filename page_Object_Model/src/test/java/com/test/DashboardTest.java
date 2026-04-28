package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.DashBoard;
import com.pages.LoginPage;

public class DashboardTest extends BaseTest {
  @Test
  public void DashBoardTest() {
	  objLogin =new LoginPage(getDriver());
	  objLogin.login("Admin", "admin123");
	  //dashboard title
	  objDashBoard = new DashBoard(getDriver());
	  String dashboardTitle=objDashBoard.getDashboardTitle();
	  Assert.assertTrue(dashboardTitle.contains("Dashboard"));
	  
  }
}
