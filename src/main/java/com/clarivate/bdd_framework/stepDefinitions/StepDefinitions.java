package com.clarivate.bdd_framework.stepDefinitions;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.clarivate.bdd_framework.helper.LoggerHelper;
import com.clarivate.bdd_framework.helper.Utility;
import com.clarivate.bdd_framework.pageObjects.GoogleHomePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class StepDefinitions extends Utility {

	GoogleHomePage googlehomepage = new GoogleHomePage(driver);
	Utility utility = new Utility();
	Logger logger = LoggerHelper.getLogger(StepDefinitions.class);
	
	@Given("^User navigates to \"([^\"]*)\"$")
	public void UserNavigatesTo(String url) throws Throwable {
		driver.get(url);
		logger.info("Navigated to "+url+" successfully");
	}
	@When("^User search for \"([^\"]*)\"$")
	public void UserSearchFor(String searchword) throws Throwable {
		logger.info("Searching "+searchword+" on google...");
		googlehomepage.enterTextOnSearchField(searchword);
		googlehomepage.clickSubmit();
	}
	@Then("^User validates \"([^\"]*)\" is the first search result$")
	public void UserValidatesTheSearchResult(String expectedurl) throws Throwable {
		String actualurl=googlehomepage.getUrlOfFirstResult();
		Assert.assertEquals(actualurl, expectedurl);
		logger.info(expectedurl+" is the first search result");
		googlehomepage.clickOnFirstResult();
		String currenturl=driver.getCurrentUrl();
		Assert.assertEquals(currenturl, expectedurl);
	}	
}