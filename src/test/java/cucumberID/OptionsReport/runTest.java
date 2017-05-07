package cucumberID.OptionsReport;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/Features", 
		glue = "stepDefinitions", 
		monochrome = true, 
		plugin = {
		"html:target/reportHomepage", "json:target/Homepage-report-json.json" })

public class runTest {
}