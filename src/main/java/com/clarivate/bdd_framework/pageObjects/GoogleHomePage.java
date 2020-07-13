package com.clarivate.bdd_framework.pageObjects;

import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.clarivate.bdd_framework.helper.Utility;

public class GoogleHomePage {
	
	private WebDriver driver;
	
	@FindBy(name="q")
	public WebElement searchField;
	@FindBy(css=".r>a")
	public List<WebElement> results;
	
	
	Utility utility;
	
	public GoogleHomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterTextOnSearchField(String searchtext){
		searchField.sendKeys(searchtext);
	}
	
	public void clickSubmit(){
		searchField.sendKeys(Keys.ENTER);
	}
	public String getUrlOfFirstResult() {
		String url=results.get(0).getAttribute("href");
		return url;
	}
	public void clickOnFirstResult() {
		results.get(0).click();
	}
	
}
