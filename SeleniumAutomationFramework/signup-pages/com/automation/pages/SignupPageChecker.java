package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignupPageChecker {
	WebDriver driver;
	public SignupPageChecker(WebDriver driver){
		this.driver=driver;
	}
	
	public SignupPageChecker  Signuptitle(){ 
		Assert.assertEquals(driver.getTitle(),"Sign Up for AppDirect");
		return new SignupPageChecker(driver);
	}
	
	public  SignupPageChecker signupchecker(){
	boolean Status 	=driver.findElement(By.xpath("//*[@id='id12']/fieldset/div[2]/div/input")).isDisplayed();
	Assert.assertTrue( Status);
	return new SignupPageChecker(driver);
		
	}
	
	

}
