package com.clarivate.bdd_framework.helper;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Utility {
	Logger logger = LoggerHelper.getLogger(Utility.class);
	public  static WebDriver driver;

	
	public WebDriver openBrowser() {
		        logger.info("Launching chrome browser...");
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/resources/drivers/chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				logger.info("Chrome browser launched successfully");
		return driver;
	}
	public void waitForElement(WebElement element,long timeOutInSeconds){
		logger.info("waiting for element visibilityOf..");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		logger.info("element is visible..");
	}
}
