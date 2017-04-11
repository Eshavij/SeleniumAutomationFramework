package com.automation.pages;

import java.sql.Timestamp;

import org.testng.Reporter;

public class ReportLog { 
	
	public void info(String msg){
		Reporter.log(new Timestamp(System.currentTimeMillis())+" [info]\t"+msg);
	}
	
	public void check(String msg){
	       Reporter.log(new Timestamp(System.currentTimeMillis())+" [Verifying/Check]\t"+msg);
	   }
	
	public void exception(String msg,boolean var){
		Reporter.log(new Timestamp(System.currentTimeMillis())+" [exception]\t"+msg);
		
	}

}
