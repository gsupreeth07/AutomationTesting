package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/feature/CustomerwithDT.feature"},
glue = {"stepdefinition"},
dryRun = false,
plugin= {"html:target/html/Report.html"})

public class Runner {

}
