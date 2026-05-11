package com.definition;

import org.testng.Assert;

import com.action.HomePageAction;
import com.action.LoginPageAction;
import com.utilities.Baseclass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {

	LoginPageAction objLogin = new LoginPageAction();
	HomePageAction objHomePage = new  HomePageAction();
	@Given("user is on HRMLogin Page {string}")
	public void user_is_on_hrm_login_page(String url) {
		Baseclass.openPage(url);
	}

	@When("user enters username and password")
	public void user_enters_username_and_password() {
	      objLogin.login();
	}

	@Then("user should able to login successfully and should see dashboard")
	public void user_should_able_to_login_successfully_and_should_see_dashboard() {
		Assert.assertTrue(objHomePage.getHomePageText().contains("Dashboard"));
	}

}
