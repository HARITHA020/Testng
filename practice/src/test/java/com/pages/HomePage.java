package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage extends MainPage{
  public HomePage(WebDriver driver) {
		super(driver);
	}

@FindBy(id="logout2")
  WebElement logoutbtn;
  
  public boolean logout() {
	  return logoutbtn.isDisplayed();
  }
  public void waitForLogout(WebDriverWait wait) {
	    wait.until(ExpectedConditions.visibilityOf(logoutbtn));
	}
  
}
