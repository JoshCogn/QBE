package com.cognizant.qbe.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.cognizant.qbe.ExcelUtility.ExcelUtility;

public class Listeners implements ITestListener{

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		System.out.println("Listener Failed called for: " + arg0.getMethod().getMethodName());
		ExcelUtility.setTestCaseStatus("Failed");		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult arg0) {
		System.out.println("Listener Success called for: " + arg0.getMethod().getMethodName());
		ExcelUtility.setTestCaseStatus("Passed");
	}

}
