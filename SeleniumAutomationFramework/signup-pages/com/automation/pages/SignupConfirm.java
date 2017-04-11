package com.automation.pages;

import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
/**
 * checker class for confirmation of signup
 * @author esha
 *
 */
public class SignupConfirm {
	ReportLog log = new ReportLog();
	WebDriver driver;
	WebDriverWait wait;

	public SignupConfirm(WebDriver driver) throws IOException {
		this.driver = driver;
	}

	public void waitVisibilityConditionByXpath() throws IOException {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".signupConfirmationPanel")));
	}

	public SignupConfirm verifysignup2() throws IOException {
		boolean status = true;
		status = driver.findElement(By.cssSelector(".signupConfirmationPanel")).isDisplayed();
		Assert.assertTrue(status);
		log.info("Registration Completed");

		return new SignupConfirm(driver);
	}

}
