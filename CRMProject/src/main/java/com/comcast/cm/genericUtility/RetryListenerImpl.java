package com.comcast.cm.genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListenerImpl implements IRetryAnalyzer {
	
	int count=0;
	int limit=5;
	@Override
	public boolean retry(ITestResult result) {
		if(count<limit) {
			count++;
			return true;
		}else {
		return false;
		}
	}

}
