package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class DashBoard extends BasePage {
	
	
	public DashBoard(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h6[normalize-space()='Dashboard']")
	WebElement dashboardTitle;
	
	public String getDashboardTitle() {
		return dashboardTitle.getText();
	}

  }

