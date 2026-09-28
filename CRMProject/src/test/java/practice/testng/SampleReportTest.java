package practice.testng;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportTest {
	
	ExtentReports report;
	
	@BeforeSuite
	public void configBS() {
		//spark report config
		ExtentSparkReporter spark=new ExtentSparkReporter("D:\\Selenium-ms\\CRMProject\\AdvanceReport\\report.html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		//add env info and create test
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows11");
		report.setSystemInfo("BROOWSER", "CHROME-100");
	}
	
	@AfterSuite
	public void configAS() {
		report.flush();
	}
	
	@Test
	public void createContactTest() {
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		
		TakesScreenshot eDriver=(TakesScreenshot)driver;
		String filePath=eDriver.getScreenshotAs(OutputType.BASE64);
		
		
		ExtentTest test=report.createTest("createContactTest");
		
		test.log(Status.INFO,"execute createContactTest ");		
		test.log(Status.INFO,"Step-1");
		test.log(Status.INFO,"Step-2");
		test.log(Status.INFO,"Step-3");
		test.log(Status.INFO,"Step-4");
		
		if("hdfc".equals("hdffc")) {
			test.log(Status.PASS, "contact is created");
		}else {
			test.addScreenCaptureFromBase64String(filePath,"Errorfile");
		}
		
		
		driver.close();
		
	}
		@Test
		public void createContactWithOrgTest() {
			
			ExtentTest test=report.createTest("createContactWithOrgTest");
			
			test.log(Status.INFO,"execute createContactWithOrgTest ");		
			test.log(Status.INFO,"Step-1");
			test.log(Status.INFO,"Step-2");
			test.log(Status.INFO,"Step-3");
			test.log(Status.INFO,"Step-4");
			
			if("hdfc".equals("hdfc")) {
				test.log(Status.PASS, "contact is created");
			}else {
				test.log(Status.FAIL, "contact is not created");
			}
		}	
			@Test
			public void createContactWithPhnNoTest() {
				
				ExtentTest test=report.createTest("createContactWithPhnNoTest");
				
				test.log(Status.INFO,"execute createContactWithPhnNoTest ");		
				test.log(Status.INFO,"Step-1");
				test.log(Status.INFO,"Step-2");
				test.log(Status.INFO,"Step-3");
				test.log(Status.INFO,"Step-4");
				
				if("hdfc".equals("hdfc")) {
					test.log(Status.PASS, "contact is created");
				}else {
					test.log(Status.FAIL, "contact is not created");
				}
		
	
		
	}
}
