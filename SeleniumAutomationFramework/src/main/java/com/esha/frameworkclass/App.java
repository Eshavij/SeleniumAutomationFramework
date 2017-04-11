package com.esha.frameworkclass;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 * Hello world!
 *
 */
public class App 
{
	
    public static void main(String[] args) throws Exception
    {
    	
    	
    			WebDriver driver=new ChromeDriver();
    			
    			System.setProperty("webdriver.chrome.driver","/resources/chromedriver");
    			driver.manage().window().maximize();
    			
    			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	      
    			driver.get("http://www.appdirect.com");
  
    		//LOGIN
    			WebElement element=driver.findElement(By.xpath("//*[@id='newnav']/header/div/menu/ul/li[3]/a/span"));
    			element.click();
    			/* 
    			WebElement element =driver.findElement(By.xpath("//*[@id='username']"));
    			element.sendKeys("esha.vij@appdirect.com");
    			driver.findElement(By.xpath("//*[@id='password']"));
    			element.sendKeys("welcome!");
    			element=driver.findElement(By.name("signin"));
    			element.click();
    			
    			 */
    			
    			//SIGNUPBUTTON
    			element=driver.findElement(By.xpath("//*[@id='id5']/fieldset/div[3]/menu/a"));
    			element.click();
    			
    			
    			
   			//SIGNUP WITH EMAILID
    			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//*[@id="ida"]/fieldset/div[2]/div/input
    			element=driver.findElement(By.xpath("//*[@id='ida']/fieldset/div[2]/div/input"));
    			element.sendKeys("abc@gmail.com");
    			System.out.println(element.getText());
    			System.out.println("***********");		    
    			
    		

    	

    } 
}
