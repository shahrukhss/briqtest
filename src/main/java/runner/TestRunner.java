package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/feature",
        glue = {"stepdefinition"},
        format = {"pretty", "html:test-output"},
        dryRun = false,
        monochrome = true //generate readable console output
        //strict = true //fail the execution if definition for a step is not implemented(PendingException)
)

public class TestRunner {

}
