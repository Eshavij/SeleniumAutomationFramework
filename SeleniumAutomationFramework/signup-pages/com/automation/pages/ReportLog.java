package com.automation.pages;

import java.sql.Timestamp;


import org.testng.Reporter;
/**
 * For creating customised logger
 * @author esha
 *
 */

public class ReportLog { 
	
	public void info(String msg){
		Reporter.log(new Timestamp(System.currentTimeMillis())+" [info]\t"+msg,true);
	}
	
	public void check(String msg){
	       Reporter.log(new Timestamp(System.currentTimeMillis())+" [Verifying/Check]\t"+msg,true);
	   }
	
	public void exception(String msg,boolean var){
		Reporter.log(new Timestamp(System.currentTimeMillis())+" [exception]\t"+msg,true);
		
	}

}
