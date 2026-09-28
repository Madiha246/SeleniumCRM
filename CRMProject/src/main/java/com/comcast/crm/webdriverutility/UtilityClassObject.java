package com.comcast.crm.webdriverutility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class UtilityClassObject {
	//share test object to multiple threads 
	public static ThreadLocal<ExtentTest> test=new ThreadLocal<ExtentTest>();
	public static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();

	public static ExtentTest getTest() {
		return test.get();
	}
	
	public static void setTest(ExtentTest actTest) {
		test.set(actTest);
	}
	//getTest() will share the obj by taking help of ThreadLocal
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	public static void setDriver(WebDriver actDriver) {
		driver.set(actDriver);
	}
}
