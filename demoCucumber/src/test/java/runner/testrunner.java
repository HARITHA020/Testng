package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin= {"pretty","html:target/cucumber-reports/Cucumber.html"},
features="src/test/resources/features/login.feature",tags=("not @regression"),
glue="demoblaze.com.test")

public class testrunner extends AbstractTestNGCucumberTests {
}
