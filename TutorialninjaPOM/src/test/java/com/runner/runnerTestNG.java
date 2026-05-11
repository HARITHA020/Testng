package com.runner;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@Test
@CucumberOptions(
		features = "src/test/resources/feature/loginpage.feature",
		glue = "com.definition",
		plugin= {
				"pretty",
				//"html:target/cucumber-reports/Cucumber.html",
				//"json: target/cucumber.json",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
		},
		monochrome=true)

public class runnerTestNG  extends AbstractTestNGCucumberTests{
	 @Override
	    @DataProvider(parallel = true)
	    public Object[][] scenarios() {
	        return super.scenarios();
	    }
}
