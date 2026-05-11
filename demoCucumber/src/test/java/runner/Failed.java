package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    plugin = {
        "pretty",
        "html:target/cucumber-reports/index.html",
        "rerun:target/failedrun.txt"
    },
    features = "@target/failedrun.txt",
    glue = "demoblaze.com.test"
)

public class Failed extends AbstractTestNGCucumberTests {

}