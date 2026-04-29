package com.test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.CartPage;
import com.pages.DemoLoginPage;
import com.pages.HomePage;
import com.pages.productPage;import org.testng.annotations.Listeners;

@Listeners(com.test.listener.class)

public class CommonTest extends MainTest{
	WebElement failed;
  @Test
  public void logintest() {
	  logpage = new DemoLoginPage(driver);
	  logpage.logintest("admin", "admin");
	 // failed=logpage.passwordfield(); //only use for element screenshot
	  try {
	        String alertText = driver.switchTo().alert().getText();
	        driver.switchTo().alert().accept();

	        Assert.fail("Login failed: " + alertText); 

	    } catch (Exception e) {
	        System.out.println("Login successful");
	    }
  }
  @Test(dependsOnMethods="logintest")
  public void hometest() {
	  home = new HomePage(driver);
	  home.waitForLogout(wait);
	  Assert.assertTrue(home.logout(), "Login failed - Logout not visible");
	  home.clicklap();
	  home.waitForMac(wait);
	  Assert.assertEquals(home.macText(), "MacBook Pro");
	  System.out.println(home.macText());
	  home.clickMac();
	  
  }
  @Test(dependsOnMethods="hometest")
  public void productTest() {
	  product=new productPage(driver);
	  product.waitFortitle(wait);
	  System.out.println(product.lapTittle());
	  product.clickcart(wait);
	  product.clickcartlink();
  }
  @Test(dependsOnMethods="productTest")
  public void cartTest() {

	  cart=new CartPage(driver);
	  cart.place();
	  cart.order("haritha", "india", "salem", "123455", "jan", "2026");
	  System.out.println( cart.getOrderId());
  }
}
