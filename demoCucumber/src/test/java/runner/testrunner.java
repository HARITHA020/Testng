package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin= {"pretty","html:target/cucumber-reports/Cucumber.html"},
features="src/test/resources/demoblaze/DataLogin.feature",tags=("@validlogin"),
glue="demoblaze.com.test")

public class testrunner extends AbstractTestNGCucumberTests {
}
