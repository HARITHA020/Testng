package com.definition;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.cucumber.java.Scenario;
import com.utilities.Baseclass;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	private static final Logger log= LogManager.getLogger(Hooks.class);
	@Before
	public static void setUp(Scenario scenario) {
		Baseclass.setUpDriver();
		Baseclass.getDriver().navigate().refresh();
		log.info("Scenario started:{}",scenario.getName());
	}
	
	@After
	public static void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			try {
			File screenshotfile = ((TakesScreenshot) Baseclass.getDriver()).getScreenshotAs(OutputType.FILE);
			File destinationFile= new File("screenshots/"+scenario.getName().replaceAll(" ", "_")+".png");
			FileUtils.copyFile(screenshotfile, destinationFile);
			byte[] screenshotBytes = ((TakesScreenshot) Baseclass.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshotBytes,"image/png","FailureScreenshot");
			log.error("Scenario failed:{}",scenario.getName());
		}
		catch(IOException e) {
			log.error("Failed to save screenshot:{}",e.getMessage());
		}
		}
		else {
			log.info("scenario passes:{}",scenario.getName());
		}
		Baseclass.tearDown();
	}
}
