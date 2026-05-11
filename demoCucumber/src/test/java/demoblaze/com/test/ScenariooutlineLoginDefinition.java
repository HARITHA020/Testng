package demoblaze.com.test;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class ScenariooutlineLoginDefinition {
	WebDriver driver = Hooks.driver;
	WebDriverWait wait = Hooks.wait;

	@Given("registered user on demo home page")
	public void registered_user_on_demo_home_page() {
		System.out.println("open browser");
		driver.get("https://www.demoblaze.com/");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@When("user clicks login link")
	public void user_clicks_login_link() {
		driver.findElement(By.id("login2")).click();
	}

	@When("the user enters {string} and {string}")
	public void the_user_enters_and(String username, String password) {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
	    
	    driver.findElement(By.id("loginusername")).clear();
	    driver.findElement(By.id("loginusername")).sendKeys(username);

	    driver.findElement(By.id("loginpassword")).clear();
	    driver.findElement(By.id("loginpassword")).sendKeys(password);
	}

	@When("when  user clicks the login button")
	public void when_user_clicks_the_login_button() {
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
	}

	@Then("user should be see appropriate {string}")
	public void user_should_be_see_appropriate(String errmsg) {
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		String msg = alert.getText();
		System.out.println(msg);
		if (msg.contains("Please fill out")) {
		    Assert.assertTrue(errmsg.contains("Please fill out"));
		} else if (msg.contains("Wrong password.")) {
		    Assert.assertTrue(errmsg.contains("Wrong password."));
		} else if (msg.contains("User does not exist")) {
		    Assert.assertTrue(errmsg.contains("User does not exist"));
		} else {
		    Assert.fail("Unexpected message: " + msg);
		}
	}

	

}
