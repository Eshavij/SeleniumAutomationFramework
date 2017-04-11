package com.esha.test1;

import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.automation.pages.Browser;
import com.automation.pages.HomePage;
import com.automation.pages.HomepageChecker;
import com.automation.pages.LoginPage;
import com.automation.pages.LoginPageChecker;
import com.automation.pages.SignupPage;
import com.automation.pages.SignupPageChecker;
import com.automation.pages.SignupPagezz;

import exceptionhandling.FileNotFound;
import exceptionhandling.NoSuchElement;

public class TestClass { 
	WebDriver driver;
	LoginPage obj1;
	
	@Test
	public void start() throws IOException{
		Browser b = new Browser();
		driver = b.startBrowser(b.selectbrowser());
	}
	
	@Test(dependsOnMethods="start")
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
			SignupPagezz lastpage= new SignupPagezz(driver);
			lastpage.waitVisibilityConditionByXpath();
			lastpage.verifysignup2();
		}

		
		
		@AfterTest
			public void exit(){
//			driver.close();
				
			}
	
		
	

}

			
			
			




