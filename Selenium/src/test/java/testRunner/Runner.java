package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/feature/Customer.feature"},
 glue = {"stepdefinition"},
 dryRun=true,
plugin = {"html:target/html/report.html"})


public class Runner {
	
	


}
