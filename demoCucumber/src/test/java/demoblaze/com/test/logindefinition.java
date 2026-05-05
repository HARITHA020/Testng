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

public class logindefinition {

    WebDriver driver;
    WebDriverWait wait;
    @Before
    public void setup() {
    	System.out.println("=========before executing=========");
    	 ChromeOptions options=new ChromeOptions();
	  	  options.addArguments("--start-maximized");
	  	  driver=new ChromeDriver(options);
	  	  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Given("registered user on home page")
    public void registered_user_on_home_page() {
        System.out.println("open browser");
        driver.get("https://www.demoblaze.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
    }

    @When("user click login link")
    public void user_click_login() {
        driver.findElement(By.id("login2")).click();
    }

    @When("user should be redirected to login form")
    public void user_should_be_redirected_to_login_form() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
    }

    @When("user enters {string} and {string}")
    public void user_should_enter_and(String username, String password) {
        driver.findElement(By.id("loginusername")).sendKeys(username);
        driver.findElement(By.id("loginpassword")).sendKeys(password);
    }

    @When("user clicks the login button")
    public void user_should_click_the_login_button() {
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
    }

    @Then("user should be redirected to user homepage")
    public void user_should_be_redirected_to_user_homepage() {
    	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
    }

    @Then("user should see their username on home page")
    public void user_should_see_their_username_on_home_page() {
        String name = driver.findElement(By.id("nameofuser")).getText();
        Assert.assertEquals(name, "Welcome admin");
        System.out.println("Logged in user: " + name);
    }

    @Then("user should see appropriate error message")
    public void user_should_see_appropriate_message() {
    	Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String msg = alert.getText();
        System.out.println(msg);
        System.out.println("invalid name");
        Assert.assertTrue(msg.contains("Wrong"));
        alert.accept();
    }
    
    @After
    public void teardown() {
    	driver.quit();
    	System.out.println("========after exceuting========");
    }
}