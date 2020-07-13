package com.clarivate.bdd_framework.testRunner;



import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;



@CucumberOptions(features = "resources/features", 
				 glue = { "com/clarivate/bdd_framework/stepDefinitions" },
				 plugin = { "pretty", "html:target/cucumber-reports/cucumber-pretty",
		"json:target/cucumber-reports/CucumberTestReport.json", "rerun:target/cucumber-reports/rerun.txt" },
		        monochrome = true, 
		        dryRun = false)
public class TestRunner extends AbstractTestNGCucumberTests{

}
