package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Extendreport {

	public static void main(String[] args) {

       ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReport.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		WebDriver driver = new ChromeDriver();
		ExtentTest test = extent.createTest("Google search test");
		try {
			driver.get("https://www.google.com");
			test.pass("navigated to goggle");
		}
		catch(Exception e) {
			test.fail("Test failed due to exception:"+e.getMessage());
		}finally {
			driver.quit();
			extent.flush();
		}

	}

}
