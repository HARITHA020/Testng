package demoblaze.com.test;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DataLoginDefinition {

	WebDriver driver = Hooks.driver;
	WebDriverWait wait = Hooks.wait;
	@Given("registered  user on demo home page")
	public void registered_user_on_demo_home_page() {
		System.out.println("open browser");
		driver.get("https://www.demoblaze.com/");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@When("user  clicks login link")
	public void user_clicks_login_link() {

		driver.findElement(By.id("login2")).click();
	}

	@When("the  user enters valid credentials")
	public void the_user_enters_valid_credentials(DataTable dataTable) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));

		List<List<String>> data = dataTable.asLists();

		String username = data.get(0).get(0);
		String password = data.get(0).get(1);

		driver.findElement(By.id("loginusername")).clear();
		driver.findElement(By.id("loginusername")).sendKeys(username);

		driver.findElement(By.id("loginpassword")).clear();
		driver.findElement(By.id("loginpassword")).sendKeys(password);
	}

	@When("when   user clicks the login button")
	public void when_user_clicks_the_login_button() {

		driver.findElement(By.xpath("//button[text()='Log in']")).click();
	}

	@Then("user  should be redirected to user homepage")
	public void user_should_be_redirected_to_user_homepage() {

   	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
	}

	@Then("user  should see their username on home page")
	public void user_should_see_their_username_on_home_page() {

        String name = driver.findElement(By.id("nameofuser")).getText();
        Assert.assertEquals(name, "Welcome harithasr");
        System.out.println("Logged in user: " + name);
	}
	

}
