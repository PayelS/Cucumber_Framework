package com.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		
		features = "/Users/Payel/Desktop/OwnFRM/Cucumber_Framework/src/test/resources/Features",
		glue = "StepDefinitions",
		
		plugin = {"pretty", "html:test-output"},
		
		dryRun = false,
		monochrome = true,
		
		tags = {"@regression"}
		
		)





public class TestRunner {

}
