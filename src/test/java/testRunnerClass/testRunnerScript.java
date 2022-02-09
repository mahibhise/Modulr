package testRunnerClass;

import io.cucumber.junit.CucumberOptions;

@CucumberOptions(features = "src/test/resources/featureFiles", glue = { "stepDefinations" }, plugin = { "pretty","html:target/testRun-Reports/cucumber-pretty.html"})
public class testRunnerScript {

}
