package com.clarivate.bdd_framework.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.winium.WiniumDriver;

public class CalculatorHomePage {
	 private WiniumDriver winiumDriver;

	    public CalculatorHomePage(WiniumDriver winiumDriver) {
	        this.winiumDriver = winiumDriver;
	        PageFactory.initElements(winiumDriver, this);
	    }
	    @FindBy(id="num0Button")
		public WebElement num0;
	    @FindBy(id="num1Button")
		public WebElement num1;
	    @FindBy(id="num2Button")
		public WebElement num2;
	    @FindBy(id="num3Button")
		public WebElement num3;
	    @FindBy(id="num4Button")
		public WebElement num4;
	    @FindBy(name="Five")
		public WebElement num5;
	    @FindBy(name="Six")
		public WebElement num6;
	    @FindBy(id="num7Button")
		public WebElement num7;
	    @FindBy(id="num8Button")
		public WebElement num8;
	    @FindBy(id="num9Button")
		public WebElement num9;
	    @FindBy(id="squareRootButton")
		public WebElement squareroot;
	    @FindBy(id="CalculatorResults")
		public WebElement result;
	    
	    public void inputNumber(String number) {
	        for (char ch : number.toCharArray())
	            pressNumber(ch);
	        }
	    public void pressSquareRootButton() {
	    	squareroot.click();
	    }
	    public double getResult() {
	        String displayedResult = result.getAttribute("name");
	        return Double.parseDouble(displayedResult.split("Display is ")[1]);
	    }
	    public void pressNumber(char ch) {
	    	switch(ch) {
	    	case '0': num0.click();
	    	winiumDriver.findElement(By.name(""));
	    		break;
	    	case '1':num1.click();
	    		break;
	    	case '2':num2.click();
	    		break;
	    	case '3':num3.click();
	    		break;
	    	case '4':num4.click();
	    		break;
	    	case '5':num5.click();
	    		break;
	    	case '6':
	    		num6.click();
//	    		winiumDriver.findElement(By.name("Six")).click();
	    		break;
	    	case '7':num7.click();
	    		break;
	    	case '8':num8.click();
	    		break;
	    	case '9':num9.click();
	    		break;
	    	default:
	    		break;
	    	}
	    }    
	   
}
