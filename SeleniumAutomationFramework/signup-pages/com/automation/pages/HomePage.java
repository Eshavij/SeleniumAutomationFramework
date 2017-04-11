package com.automation.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.gargoylesoftware.htmlunit.javascript.host.Element;

import exceptionhandling.NoSuchElement;
import exceptionhandling.FileNotFound;

public class HomePage {
	ReportLog log=new ReportLog();
	 WebDriver driver;
	public  FileInputStream fileInputstream;
	
	Properties properties=new Properties();
	
	
	 public HomePage(WebDriver driver) throws FileNotFound{
		 this.driver=driver; 
	 try{
	 FileInputStream FileInput = new FileInputStream(new File("HomePage.properties"));
	 properties.load(FileInput);
	 
	 }
	 catch(Exception e){
		 throw new FileNotFound("Element path not found\n"+e.getMessage());
	 }	
	 
	 }
	 
	 public HomePage openHomePageUrl()throws FileNotFound{
		 log.info("Open appdirect website");
		 driver.get(properties.getProperty("website"));
		 return new HomePage(driver);
	 }

	public HomePage clickloginButton() throws  NoSuchElement, FileNotFound{
		log.info("click loginIn button");
		try{
		driver.findElement(By.cssSelector(".login")).click();
		}
		catch(Exception e){
		 throw new NoSuchElement("Element path not  found");
		 }
		return new HomePage(driver);
	} 
	
		 public HomePage verifyHomepagetitle() throws FileNotFound, IOException{
			 log.info("Homepage title verified");
			 HomepageChecker homepage=new HomepageChecker(driver);
			 homepage.homepagetitle();
			
			 return new HomePage(driver);	 
			 
		 }
		 public HomePage verifyhomepagelogin() throws IOException, FileNotFound, NoSuchElement{
			 log.info("Homepage login");
			 HomepageChecker homepage=new HomepageChecker(driver);
			 homepage.loginchecker();
			 return new HomePage(driver);	
		 
		 }	 
}

	 
	
	
	
