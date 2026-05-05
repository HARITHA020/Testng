package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class Home {

	@Given("User is on Home Page")
	public void user_is_on_home_page() {
		System.out.println("user is on home page");
	}

	@When("User enters username as {string}")
	public void user_enters_username_as(String string) {
		System.out.println("user is on home page");
		
	}

	@When("User enters password as {string}")
	public void user_enters_password_as(String string) {
		System.out.println("user is on home page");
	}

	@Then("User should be able to login successfully")
	public void user_should_be_able_to_login_successfully() {
		System.out.println("user is on home page");
	}

}