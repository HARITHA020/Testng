package runner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(plugin="pretty",
features="src/test/resources/features/login.feature",tags="@validlogin",
glue="demoblaze.com.test")

public class junitrunner {
  
}
