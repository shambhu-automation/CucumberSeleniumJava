package com.clarivate.bdd_framework.stepDefinitions;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import com.clarivate.bdd_framework.helper.DesktopUtility;
import com.clarivate.bdd_framework.helper.LoggerHelper;
import com.clarivate.bdd_framework.helper.Utility;;

public class Hooks {

	Utility utility;
	Process pr;
	Logger log = LoggerHelper.getLogger(Hooks.class);

	@Before("@BrowserAutomation")
	public void initializeTest() {
		utility = new Utility();
		utility.openBrowser();
	}

	@After("@BrowserAutomation")
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
	
	 @Before("@DesktopAutomation")
	    public void startWiniumDriver() throws IOException {
	        Runtime rt = Runtime.getRuntime();
	        // Executing the Winium.Desktop.Driver.exe file
	        pr = rt.exec(System.getProperty("user.dir") + "/resources/drivers/Winium.Desktop.Driver.exe");
	    }

	    @After("@DesktopAutomation")
	    public void quitWiniumDriver() {
	        // Destroying the Winium.Desktop.Driver.exe execution process
	        pr.destroy();
	        System.out.println("Quitting Winium Driver");
	    }
//	    public static void main(String[] args) throws IOException {
//	    	Runtime rt = Runtime.getRuntime();
//	        // Executing the Winium.Desktop.Driver.exe file
//	    	Process pr ;
//	 
//	        pr = rt.exec(System.getProperty("user.dir") + "/resources/drivers/Winium.Desktop.Driver.exe");
//	        System.out.println("executed");
//		}
}
