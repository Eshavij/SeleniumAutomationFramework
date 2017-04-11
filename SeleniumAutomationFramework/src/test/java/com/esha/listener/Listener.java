package com.esha.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {
	public void onTestStart(ITestResult Result) {
        System.out.println(Result.getName()+" test case started");
   }
   public void onTestSuccess(ITestResult Result) {
       System.out.println("The name of the testcase passed is :"+Result.getName());
   }
   public void onTestFailure(ITestResult Result) {
       System.out.println("The name of the testcase failed is :"+Result.getName());
   }
   public void onTestSkipped(ITestResult Result) {
       System.out.println("The name of the testcase Skipped is :"+Result.getName());
   }
   public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {}
   public void onStart(ITestContext context) {}
   public void onFinish(ITestContext context) {}

}
