package com.clarivate.bdd_framework.stepDefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import com.clarivate.bdd_framework.helper.LoggerHelper;
import com.clarivate.bdd_framework.helper.Utility;;

public class Hooks {

	Utility utility;

	Logger log = LoggerHelper.getLogger(Hooks.class);

	@Before
	public void initializeTest() {
		utility = new Utility();
		utility.openBrowser();
	}

	@After
	public void endTest(Scenario scenario) {
		if (scenario.isFailed()) {

			try {
				log.info(scenario.getName() + " is Failed");
				final byte[] screenshot = ((TakesScreenshot) Utility.driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png"); // ... and embed it in
			} catch (WebDriverException e) {
				e.printStackTrace();
			}

		} else {
			try {
				log.info(scenario.getName() + " is pass");
				scenario.embed(((TakesScreenshot) Utility.driver).getScreenshotAs(OutputType.BYTES), "image/png");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		Utility.driver.quit();
	}
}
