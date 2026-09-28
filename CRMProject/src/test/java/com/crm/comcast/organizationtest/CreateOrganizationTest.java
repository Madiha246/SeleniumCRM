package com.crm.comcast.organizationtest;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.comcast.cm.genericUtility.ExcelUtility;
import com.comcast.cm.genericUtility.JavaUtility;
import com.comcast.cm.genericUtility.PropertyFileUtility;
import com.comcast.cm.genericUtility.WebDriverUtility;
import com.comcast.crm.elementrepository.CreatingNewOrganizationPage;
import com.comcast.crm.elementrepository.HomePage;
import com.comcast.crm.elementrepository.LoginPage;
import com.comcast.crm.elementrepository.OrganizationInfoPage;
import com.comcast.crm.elementrepository.OrganizationsPage;

public class CreateOrganizationTest {
      
	public static void main(String[] args) throws IOException {
		
		PropertyFileUtility pf=new PropertyFileUtility();
		String url=pf.readPropertyfile("url");
		String browser=pf.readPropertyfile("browser");
		String un=pf.readPropertyfile("username");
		String pwd=pf.readPropertyfile("password");
		
		WebDriverUtility wd=new WebDriverUtility();
		WebDriver driver=wd.launchBrowser(browser);
		wd.getUrl(url);
		wd.maximizeBrowser();
		wd.implicitWaitMethod();
		
		LoginPage lp = new LoginPage(driver);
		lp.userLogin(un, pwd);
	     
		HomePage hp=new HomePage(driver);
		hp.getOrganizationsLink().click();
		
		OrganizationsPage cop=new OrganizationsPage(driver);
		cop.getCreateOrgImg().click();
		
		ExcelUtility eu=new ExcelUtility();
		JavaUtility ju=new JavaUtility();
		int random=ju.randomInputs();
		String orgName=eu.readExcelFile("Sheet1", 1, 2)+random;
		
		CreatingNewOrganizationPage cnp=new CreatingNewOrganizationPage(driver);
		cnp.getOrgName().sendKeys(orgName);
		cnp.getSaveButton().click();
		
		OrganizationInfoPage op=new OrganizationInfoPage(driver);
		String orgHeader=op.getOrgHeaderElement().getText();
		if(orgHeader.contains(orgName)) 	System.out.println(orgHeader+"  passed");
		else System.out.println(orgHeader+"  failed");
		
		driver.quit();
		
		
		
		
		
		
		
		
	}

}
