package com.comcast.crm.listenerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;


import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.webdriverutility.UtilityClassObject;


public class ListenerImplementation implements ITestListener,ISuiteListener{
	
	
	public static ExtentReports report;
	public static ExtentTest test;
	@Override
	public void onStart(ISuite suite) {
		System.out.println("Report Configuration");
		String time=new Date().toString().replace(" ", "_").replace(":", "_");
		
		//spark report config
		ExtentSparkReporter	spark=new ExtentSparkReporter("D:\\Selenium-ms\\CRMProject\\AdvanceReport\\report_"+time+".html");
				spark.config().setDocumentTitle("CRM Test Suite Results");
				spark.config().setReportName("CRM Report");
				spark.config().setTheme(Theme.DARK);
				
				//add env info and create test
				report=new ExtentReports();
				report.attachReporter(spark);
				report.setSystemInfo("OS", "Windows11");
				report.setSystemInfo("BROOWSER", "CHROME-100");
			}
	
	
	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report backup");
		report.flush();
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("======"+result.getMethod().getMethodName()+"=======");
		 test=report.createTest(result.getMethod().getMethodName());
		 UtilityClassObject.setTest(test);
		 test.log(Status.INFO, result.getMethod().getMethodName()+"==> STARTED==");
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("======"+result.getMethod().getMethodName()+"===========");
		//test=report.createTest(result.getMethod().getMethodName());
		test.log(Status.PASS, result.getMethod().getMethodName()+"==> COMPLETED==");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		
		String tsName=result.getMethod().getMethodName();
		String time=new Date().toString().replace(" ", "_").replace(":", "_");
		
		TakesScreenshot eDriver=(TakesScreenshot)BaseClass.sdriver;
		String filePath=eDriver.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(filePath,tsName+"_"+time);
		test.log(Status.FAIL, result.getMethod().getMethodName()+"==> FAILED==");
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		
	}
	
	
	
	

}
