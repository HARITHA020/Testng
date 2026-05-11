package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
/*
@CucumberOptions(plugin= {"pretty","html:target/cucumber-reports/Cucumber.html"},
features="src/test/resources/demoblaze/DataLogin.feature",tags=("@validlogin"),
glue="demoblaze.com.test")
*/

@CucumberOptions(plugin= {"pretty","html:.reports/cucumber-reports/Cucumber.html/imdex.html",
		"rerun:target/failedrun.txt"},
//features="src/test/resources/demoblaze/DataLogin.feature",tags=("@validlogin"),
features= {"@target/failedrun.txt"},
glue="demoblaze.com.test")
public class testrunner extends AbstractTestNGCucumberTests {
}
