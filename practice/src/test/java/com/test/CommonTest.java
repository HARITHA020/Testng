package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.CartPage;
import com.pages.DemoLoginPage;
import com.pages.HomePage;
import com.pages.productPage;

public class CommonTest extends MainTest{
  @Test
  public void test() {
	  logpage = new DemoLoginPage(driver);
	  home = new HomePage(driver);
      product=new productPage(driver);
	  cart=new CartPage(driver);
	  
	  logpage.logintest("admin", "admin");
	  
	  home.waitForLogout(wait);
	  Assert.assertTrue(home.logout(), "Login failed - Logout not visible");
	  home.clicklap();
	  home.waitForMac(wait);
	  Assert.assertEquals(home.macText(), "MacBook Pro");
	  System.out.println(home.macText());
	  home.clickMac();
	  
	  
	  product.waitFortitle(wait);
	  System.out.println(product.lapTittle());
	  product.clickcart(wait);
	  product.clickcartlink();
	  
	  cart.place();
	 cart.order("haritha", "india", "salem", "123455", "jan", "2026");
	 System.out.println( cart.getOrderId());
	  
  }
}
