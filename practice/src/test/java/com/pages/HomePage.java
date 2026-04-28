package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends MainPage {
	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "logout2")
	WebElement logoutbtn;

	@FindBy(xpath = "(//a[@id='itemc'])[2]")
	WebElement laptopcat;

	@FindBy(xpath = "//a[text()='MacBook Pro']")
	WebElement maclap;

	public boolean logout() {
		return logoutbtn.isDisplayed();
	}

	public void clicklap() {
		laptopcat.click();
	}

	public String macText() {
		return maclap.getText();
	}
	
	public void clickMac() {
		maclap.click();
	}
	public void waitForLogout(WebDriverWait wait) {
		wait.until(ExpectedConditions.visibilityOf(logoutbtn));
	}

	public void waitForMac(WebDriverWait wait) {
		wait.until(ExpectedConditions.visibilityOf(maclap));
	}

}
