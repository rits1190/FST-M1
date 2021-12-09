package cucumberTest;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features ="Features",
		glue = {"StepDefinitions"},
		tags = "@activity5",
		plugin = {"pretty","html:target/cucumber-reports/reports.html","json: target/test-reports/json-report.json"},
		monochrome = true
		
		)

public class ActivitiesRunner {

	

}
