package com.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class productPage extends MainPage{
  public productPage(WebDriver driver) {
		super(driver);
	}
  @FindBy(xpath="//div[@id='tbodyid']/child::h2")
  WebElement laptitle;
  
  @FindBy(xpath="//div[@id=\"tbodyid\"]/div[2]/div/a")
  WebElement cartbtn;
  
  @FindBy(css="#cartur")
  WebElement cart;
  public String lapTittle() {
	  return laptitle.getText();
  }
  
  public void clickcartlink() {
	  cart.click();
  }

  public void waitFortitle(WebDriverWait wait) {
	wait.until(ExpectedConditions.visibilityOf(laptitle));
  }
  public void clickcart(WebDriverWait wait) {
	    cartbtn.click();
	    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	    System.out.println("Alert text: " + alert.getText());
	    alert.accept();
	}
  
}
