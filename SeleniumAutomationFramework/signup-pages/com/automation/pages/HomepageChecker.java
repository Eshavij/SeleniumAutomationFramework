package com.automation.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import exceptionhandling.NoSuchElement;

public class HomepageChecker { 

	WebDriver driver;
	public  FileInputStream fileInputstream;
	Properties properties=new Properties();
		
	public HomepageChecker(WebDriver driver) throws IOException{
		this.driver=driver; 
	}  
		 
	public void homepagetitle() throws IOException{ 
		Assert.assertEquals(driver.getTitle(),"AppDirect");
	
	}
	
	public  void loginchecker() throws IOException, NoSuchElement{
		boolean status;
		try{
		 status=driver.findElement(By.xpath("//*[@id='newnav']/header/div/menu/ul/li[3]/a/span")).isDisplayed();
		}
		catch(Exception e)
		{
			throw new NoSuchElement("Element path not found\n"+e.getMessage());
		}
		Assert.assertTrue( status);
		
	}

}
