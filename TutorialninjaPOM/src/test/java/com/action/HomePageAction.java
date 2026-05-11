package com.action;

import org.openqa.selenium.support.PageFactory;

import com.pages.HomePageLocator;
import com.utilities.Baseclass;

public class HomePageAction {
	HomePageLocator homepagelocator= null;
	public HomePageAction() {
		this.homepagelocator=new HomePageLocator();
		PageFactory.initElements(Baseclass.getDriver(), homepagelocator);
	}
	
	public String getHomePageText() {
		return homepagelocator.homepageusername.getText();
	}
}
