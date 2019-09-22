package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = {"src/test/java/features/login.feature"}, format = {"json:target/cucumber.json", "html:target/site/cucumber-pretty"}, glue = "steps")
public class TestRunnerForTestNG extends AbstractTestNGCucumberTests {

}
