package com.automation.pages;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import exceptionhandling.NoSuchElement;
import exceptionhandling.FileNotFound;
/**
 * Page object class for signup webpage
 * @author esha
 *
 */

public class SignupPage {

	public FileInputStream fileInputstream;
	Properties properties = new Properties();
	private WebDriver driver;
	private String Expected;

	public SignupPage(WebDriver driver) throws IOException, FileNotFound {
		this.driver = driver;
		try {
			FileInputStream FileInput = new FileInputStream(new File("Signup.properties"));
			properties.load(FileInput);
		} catch (Exception e) {
			throw new FileNotFound("File not Found");

		}
	}

	public SignupPage emailid() throws IOException, NoSuchElement, FileNotFound {
		Reporter.log("Enter mailid", true);
		String emailid;
		WebElement input;
		try {
			emailid = (RandomStringUtils.randomAlphabetic(3, 50)).toLowerCase() + "@"
					+ (RandomStringUtils.randomAlphabetic(3)).toLowerCase() + ".com";
			input = driver.findElement(By.xpath(properties.getProperty("emailid")));
		} catch (Exception e) {

			throw new NoSuchElement("Element path not found");

		}
		input.sendKeys(emailid);

		return new SignupPage(driver);
	}

	public SignupPage save() throws IOException, FileNotFound {
		WebElement signup = driver.findElement(By.xpath(properties.getProperty("signup")));
		signup.click();
		return new SignupPage(driver);
	}

	public SignupPage wait(WebDriver driver) throws IOException, FileNotFound {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertEquals(Expected, "Welcome");
		return new SignupPage(driver);
	}

}
