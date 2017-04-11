package com.automation.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import exceptionhandling.NoSuchElement;

public class LoginPageChecker { 
	WebDriver driver;
	WebDriverWait wait;
	public LoginPageChecker( WebDriver driver){
		this.driver=driver;
		
	}
	
	public void  title(){ 
		Assert.assertEquals(driver.getTitle(),"Log In | AppDirect");
		
	}
	public void checksignupchecker() throws NoSuchElement{
		boolean status;
		try{
			status = driver.findElement(By.xpath("//*[@id='id5']/div[3]/p/a")).isDisplayed();
			
		}
		catch( Exception e){
			throw new NoSuchElement("Element path not found\n"+e.getMessage());
		}
		Assert.assertTrue( status);
	}
	
	public void waitVisibilityConditionByXpath() throws NoSuchElement{
        wait = new WebDriverWait(driver, 20);
        try{
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='id5']/div[3]/p/a")));
        }
        catch(Exception e){
        	 throw new NoSuchElement("Element path not found\n"+e.getMessage());
        }
	
     
    }
}


