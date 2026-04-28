package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class DashBoard {
	WebDriver driver;
	By dashboardTitle=By.xpath("//h6[normalize-space()='Dashboard']");
	
	public DashBoard(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getDashboardTitle() {
		return driver.findElement(dashboardTitle).getText();
	}

  }

