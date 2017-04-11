package com.automation.browsers;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class MultipleBrowsers {
	
		 
		public WebDriver driver; 
	  public void firefoxbrowser(String browser) {
 
	  if(browser.equalsIgnoreCase("firefox")) {
		    //System.setProperty(Properties.getProperty("drivername"),Properties.getProperty("driverpath"));
		    driver = new FirefoxDriver();
	 
	  }else if (browser.equalsIgnoreCase("ie")) { 
		  
		  driver = new InternetExplorerDriver();
	 
	  } else if(browser.equalsIgnoreCase("chrome")){
	  
	  }
	 
	 	 
	  driver.get("www.appdirect.com"); 
	 
	  }
	 
	 
	 
	   public void login() throws InterruptedException {
	 
		driver.findElement(By.xpath(".//*[@id='account']/a")).click();
	 
	    driver.findElement(By.id("log")).sendKeys("testuser_1");
	 
	    driver.findElement(By.id("pwd")).sendKeys("Test@123");
	 
	    driver.findElement(By.id("login")).click();
	 
		}  
	 
	   public void afterTest() {
	 
			driver.quit();
	 
		}
	 
	



}



