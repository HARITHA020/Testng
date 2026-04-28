package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends MainPage {

	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css=".btn.btn-success")
	WebElement placebtn;

	@FindBy(css="#name")
	WebElement name;
	
	@FindBy(css="#country")
	WebElement country;
	
	@FindBy(css="#city")
	WebElement city;
	
	@FindBy(css="#card")
	WebElement card;
	
	@FindBy(css="#month")
	WebElement month;
	
	@FindBy(css="#year")
	WebElement year;
	
	@FindBy(xpath="//div[@id=\"orderModal\"]/div/div/div[3]/button[2]")
	WebElement orderbtn;
	
    @FindBy(css=".lead.text-muted")
	WebElement orderRef;
	  
	
	
	public void order(String ordName, String ordCountry, String ordCity, String ordCard, String ordMonth,String ordYear) {
		name.sendKeys(ordName);
		country.sendKeys(ordCountry);
		city.sendKeys(ordCity);
		card.sendKeys(ordCard);
		month.sendKeys(ordMonth);
		year.sendKeys(ordYear);
		orderbtn.click();
	}
	public void place() {
		placebtn.click();
	}
	
	public String getOrderId() {
	    String text = orderRef.getText();
	    String[] lines = text.split("\n");
	    return lines[0].split(":")[1].trim();
	}
	
	
	
  
}
