package com.esha.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
/**
 * To listen all events automatically
 * @author esha
 *
 */
public class Listener implements ITestListener {
	public void onTestStart(ITestResult Result) {
        Reporter.log(Result.getName()+" test case started");
   }
   public void onTestSuccess(ITestResult Result) {
	   Reporter.log("The name of the testcase passed is :"+Result.getName());
   }
   public void onTestFailure(ITestResult Result) {
	   Reporter.log("The name of the testcase failed is :"+Result.getName());
   }
   public void onTestSkipped(ITestResult Result) {
	   Reporter.log("The name of the testcase Skipped is :"+Result.getName());
   }
   public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {}
   public void onStart(ITestContext context) {}
   public void onFinish(ITestContext context) {}

}
