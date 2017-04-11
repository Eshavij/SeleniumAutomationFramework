package com.automation.pages;

import java.io.File;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import exceptionhandling.*;
/**
 * Page object class for login
 * @author esha
 *
 */

public class LoginPage {
	WebDriver driver;
	ReportLog log = new ReportLog();
	FileInputStream fileInputstream;
	Properties properties = new Properties();

	WebDriverWait wait;

	public LoginPage(WebDriver driver) throws NoSuchElement {
		this.driver = driver;

		try {
			FileInputStream FileInput = new FileInputStream(new File("LoginPage.properties"));
			properties.load(FileInput);
		} catch (IOException i) {
			throw new NoSuchElement("File Not Found");
		}

	}

	public LoginPage verifyTitle() throws NoSuchElement {
		LoginPageChecker checker = new LoginPageChecker(driver);
		checker.title();
		return new LoginPage(driver);
	}

	public LoginPage clickLogin(WebDriver driver) throws NoSuchElement {
		log.info("Opens signup page");

		try {
			driver.findElement(By.xpath(properties.getProperty("signupbtn"))).click();
		} catch (Exception e) {
			throw new NoSuchElement("Element path not found\n" + e.getMessage());
		}
		return new LoginPage(driver);
	}

	public LoginPage verifywait() throws NoSuchElement {
		log.info("wait is implemented");
		LoginPageChecker loginchecker = new LoginPageChecker(driver);
		loginchecker.waitVisibilityConditionByXpath();
		return new LoginPage(driver);
	}

	public LoginPage verifysignup() throws NoSuchElement {
		log.info("signup page is verified");
		LoginPageChecker loginchecker = new LoginPageChecker(driver);
		loginchecker.checksignupchecker();
		return new LoginPage(driver);
	}

	public LoginPage waitVisibilityConditionByXpath() throws NoSuchElement {
		wait = new WebDriverWait(driver, 20);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("signupbtn"))));
		} catch (Exception e) {
			throw new NoSuchElement("Element not found\n" + e.getMessage());
		}
		return new LoginPage(driver);
	}
}
