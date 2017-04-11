package com.automation.browsers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;

import com.automation.pages.ReportLog;

import exceptionhandling.FileNotFound;

public class Browser {
	ReportLog log=new ReportLog();
	Properties properties = new Properties();
	WebDriver driver;
	Scanner obj=new Scanner(System.in);
	
	public Browser() throws IOException, FileNotFound{
	try{
		
		 FileInputStream FileInput = new FileInputStream(new File("HomePage.properties"));
		 properties.load(FileInput);
	}
	catch(Exception e)
	{
		throw new FileNotFound("File not Found");
	}
	}
	
	public String selectbrowser(){
		log.info("Selecting a  Browser");
		Reporter.log("CHROME\t FIREFOX\t SAFARI");
		String input=obj.next();
		return input;
	}
	
	
	 public WebDriver startBrowser(String browser){
		 if(browser.equalsIgnoreCase("firefox")){
			 log.info("Firefox is launched");
		 
			    System.setProperty(properties.getProperty("fdrivername"),properties .getProperty("fdriverpath") );
			    driver = new FirefoxDriver();
		  }else if (browser.equalsIgnoreCase("safari")) { 
			  log.info("Safari is launched");
			  driver = new SafariDriver();
		  } else if(browser.equalsIgnoreCase("chrome")){
			  log.info("Chrome is launched");
			  Reporter.log("Initialze the chromebrowser");
			  System.setProperty(properties.getProperty("cdrivername"),properties.getProperty("cdriverpath"));
			  driver=new ChromeDriver();
		  }
		 
		 return driver;
		 
		 
		 
		 
	 }
}
