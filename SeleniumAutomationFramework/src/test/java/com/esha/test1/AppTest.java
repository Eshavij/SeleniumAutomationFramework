package com.esha.test1;
import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
/**
 * Automating the Signup
 * @author esha
 *
 */

public class AppTest{
	 @Test
	 public void testCase() throws IOException{
	 
		 
			WebDriver driver=new ChromeDriver();
			//CHROMEHOMEPAGE
			System.setProperty("webdriver.chrome.driver","chromedriver");
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	      //WEBSITEOPEN
			driver.get("http://www.appdirect.com");		
	  
		//LOGINBUTTON
			WebElement element=driver.findElement(By.xpath("//*[@id='newnav']/header/div/menu/ul/li[3]/a/span"));
			element.click();
	  //SIGNUPBUTTON
			element=driver.findElement(By.xpath("//*[@id='id5']/fieldset/div[3]/menu/a"));
			element.click();
		//EMAILIDFIELD
			element=driver.findElement(By.xpath("//*[@id='ida']/fieldset/div[2]/div/input"));
			element.sendKeys("abc@gmail.com");
			System.out.println(element.getText());
			System.out.println("***********");	
			//driver.quit();
			
	  }

	}

	
