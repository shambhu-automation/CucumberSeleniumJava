package com.clarivate.bdd_framework.stepDefinitions;

import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.openqa.selenium.winium.WiniumDriver;
import org.testng.Assert;

import com.clarivate.bdd_framework.helper.DesktopUtility;
import com.clarivate.bdd_framework.helper.LoggerHelper;
import com.clarivate.bdd_framework.pageObjects.CalculatorHomePage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;




public class DesktopAutomationSteps extends DesktopUtility{
	
	private int inputNumber;
	CalculatorHomePage calculatorhomepage;
	Logger logger = LoggerHelper.getLogger(DesktopAutomationSteps.class);


    @Given("I open Windows Calculator Application")
    public void openWindowsCalculatorApplication() throws MalformedURLException, InterruptedException {
    	DesktopUtility desktopUtility= new DesktopUtility();
    	desktopUtility.initDriver("http://localhost:9999");
    	Thread.sleep(20000);
    	calculatorhomepage = new CalculatorHomePage(winiumDriver);
    }

    @When("^I enter number \"([^\"]*)\"$")
    public void enterValue(String number) {
        inputNumber = Integer.parseInt(number);
        calculatorhomepage.inputNumber(number);
    }

    @And("click on square root button")
    public void clickOnSquareRootButton() {
    	calculatorhomepage.pressSquareRootButton();
    }

    @Then("the calculate result should be correct")
    public void verifyCalulatorResult() {
        double actual = calculatorhomepage.getResult();
        double expected = Math.sqrt(inputNumber);
        Assert.assertEquals(actual,expected,0.001);
    }
}
