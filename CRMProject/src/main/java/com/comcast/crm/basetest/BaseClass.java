package com.comcast.crm.basetest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.comcast.cm.genericUtility.DatabaseUtility;
import com.comcast.cm.genericUtility.JavaUtility;
import com.comcast.cm.genericUtility.PropertyFileUtility;
import com.comcast.cm.genericUtility.WebDriverUtility;
import com.comcast.crm.elementrepository.HomePage;
import com.comcast.crm.elementrepository.LoginPage;
import com.comcast.crm.webdriverutility.UtilityClassObject;


public class BaseClass {

	public WebDriver driver=null;
	public static WebDriver sdriver=null;
	DatabaseUtility db = new DatabaseUtility();
	PropertyFileUtility pf = new PropertyFileUtility();
	WebDriverUtility wu=new WebDriverUtility();
	JavaUtility ju=new JavaUtility();
	

	@BeforeSuite(groups= {"Smoke Test","Regression Test"})
	public void configBS() {
		System.out.println("====Connect to DB, Report config====");
		// db.getDbConnection();
	}
    
	//@Parameters("BROWSER")
	
	@BeforeClass(groups= {"Smoke Test","Regression Test"})
		//public void configBC(String browser) throws IOException {
		public void configBC() throws IOException {
		System.out.println("====Launch Browser====");
	//	String BROWSER=browser;
		String browser=pf.readPropertyfile("browser");
		driver=wu.launchBrowser(browser);
	
		sdriver=driver;
		UtilityClassObject.setTest(driver);
	}
	
	

	@BeforeMethod(groups= {"Smoke Test","Regression Test"})
	public void configBM() throws IOException {
		
		String URL=pf.readPropertyfile("url");
		wu.maximizeBrowser();
		wu.implicitWaitMethod();
		wu.getUrl(URL);
		String USERNAME = pf.readPropertyfile("username");
		String PASSWORD = pf.readPropertyfile("password");
		LoginPage lp = new LoginPage(driver);
		lp.userLogin(USERNAME, PASSWORD);
		System.out.println("Logged In to Vtiger");
	}
	

	@AfterMethod(groups= {"Smoke Test","Regression Test"})
	public void configAM() {
		HomePage hp=new HomePage(driver);
		hp.logOut();
	}

	@AfterClass(groups= {"Smoke Test","Regression Test"})
	public void configAC() {
		driver.quit();
	}

	@AfterSuite(groups= {"Smoke Test","Regression Test"})
	public void configAS() {
		System.out.println("====Close DB, Report backup====");
	}

}
