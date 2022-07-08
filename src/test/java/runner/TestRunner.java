package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import utilities.CucumberReporting;


@RunWith(Cucumber.class)
@CucumberOptions(
		features =".\\src\\test\\resources\\Features",         //classPath:Features",//\src\test\resources\Features
		glue = "stepDefinitions",
		dryRun = false,  
		tags ="@RetailPage",
		monochrome = true, 
		strict = true, 
		plugin = {"pretty","html:target/site/cucumber-pretty","json:target/cucumber.json"},
		publish = true
		
		)
public class TestRunner {
@AfterClass
	public static void gerateReport() {
	CucumberReporting.reportConfig();
}
	
}
