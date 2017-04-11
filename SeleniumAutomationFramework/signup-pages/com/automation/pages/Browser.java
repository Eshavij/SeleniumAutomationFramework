package com.automation.pages;

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

public class Browser {
	ReportLog log;
	Properties properties = new Properties();
	WebDriver driver;
	Scanner obj=new Scanner(System.in);
	
	public Browser() throws IOException{
		 FileInputStream FileInput = new FileInputStream(new File("HomePage.properties"));
		 properties.load(FileInput);
	}
	public String selectbrowser(){
		//log.info("Selecting a  Browser");
		
		System.out.println("CHROME\t FIREFOX\t SAFARI");
		String input=obj.next();
		return input;
	}
	
	 public WebDriver startBrowser(String browser){
		 if(browser.equalsIgnoreCase("firefox")) {
			    System.setProperty(properties.getProperty("fdrivername"),properties .getProperty("fdriverpath") );
			    driver = new FirefoxDriver();
		  }else if (browser.equalsIgnoreCase("safari")) { 
			  driver = new SafariDriver();
		  } else if(browser.equalsIgnoreCase("chrome")){
			  Reporter.log("Initialze the chromebrowser");
			  System.setProperty(properties.getProperty("cdrivername"),properties.getProperty("cdriverpath"));
			  driver=new ChromeDriver();
		  }
		 
		 return driver;
		 
		 
		 
		 
	 }
}
