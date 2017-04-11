package com.automation.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
/**
 * checker class for signup 
 * @author esha
 *
 */

public class SignupPageChecker {
	WebDriver driver;

	public SignupPageChecker(WebDriver driver) {
		this.driver = driver;
	}

	public SignupPageChecker Signuptitle() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ida']/fieldset/div[2]/div/input")));
		Assert.assertEquals(driver.getTitle(), "Sign Up for AppDirect");
		return new SignupPageChecker(driver);
	}

	public SignupPageChecker signupchecker() {
		boolean status = true;
		status = driver.findElement(By.xpath("//*[@id='id12']/fieldset/div[2]/div/input")).isDisplayed();
		Assert.assertTrue(status);
		return new SignupPageChecker(driver);

	}

}
