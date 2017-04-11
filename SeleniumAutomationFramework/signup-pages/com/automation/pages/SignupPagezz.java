package com.automation.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class SignupPagezz {
	ReportLog log=new ReportLog();
	WebDriver driver;
	WebDriverWait wait;	
		public SignupPagezz(WebDriver driver) throws IOException{
			 this.driver=driver; 		 
		 }  
		
		public void waitVisibilityConditionByXpath() throws IOException{
	        wait = new WebDriverWait(driver, 20);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".signupConfirmationPanel")));
	    }
		
		public SignupPagezz verifysignup2 () throws IOException{
			boolean status = driver.findElement(By.cssSelector(".signupConfirmationPanel")).isDisplayed();
			Assert.assertTrue(status);
			log.info("Registration Completed");
		
			return new SignupPagezz(driver);		
		} 
		
		

}
