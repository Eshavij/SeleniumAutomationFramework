package com.esha.test1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.automation.browsers.Browser;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.pages.SignupPage;
import com.automation.pages.SignupPageChecker;
import com.automation.pages.SignupConfirm;

import exceptionhandling.FileNotFound;
import exceptionhandling.NoSuchElement;

/**
 * Test Class
 * @author esha
 *
 */
public class TestClass { 
	WebDriver driver;
	LoginPage obj1;
	
	@BeforeClass
	public void start() throws IOException, FileNotFound{
		Browser b = new Browser();
		String sel = b.selectbrowser();
		driver = b.startBrowser(sel);
	}
	
	@Test
	public void verifyHomepage() throws IOException, FileNotFound, NoSuchElement{ 
		HomePage obj=PageFactory.initElements(driver, HomePage.class);
			obj.openHomePageUrl()
			.verifyHomepagetitle()
			.verifyhomepagelogin()
			.clickloginButton();
			
	}
	
	@Test(dependsOnMethods="verifyHomepage")
	public void verifyloginpage() throws IOException, NoSuchElement{
		obj1 = PageFactory.initElements(driver, LoginPage.class);
		obj1.verifywait()
			.verifyTitle()
			.verifysignup()
			.waitVisibilityConditionByXpath()
			.clickLogin(driver); 
	} 
				
	@Test(dependsOnMethods="verifyloginpage")
	public void verifySignUpPage() throws IOException{
		SignupPageChecker obj4=new SignupPageChecker(driver);
		obj4.Signuptitle();
		
	}
		@Test(dependsOnMethods="verifySignUpPage")
		public void verifySignup() throws IOException, NoSuchElement, FileNotFound{
		SignupPage obj2 = PageFactory.initElements(driver, SignupPage.class);
		obj2.emailid()
			.save();

	}
		@Test(dependsOnMethods="verifySignup")
		public void verifysignuplast() throws IOException{
			SignupConfirm lastpage= new SignupConfirm(driver);
			lastpage.waitVisibilityConditionByXpath();
			lastpage.verifysignup2();
		}

		
		
			@AfterClass
			public void exit(){
			driver.close();
				
			}
	
		
	

}

			
			
			




