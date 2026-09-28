package com.comcast.crrm.organizationtestng;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.comcast.cm.genericUtility.ExcelUtility;
import com.comcast.cm.genericUtility.JavaUtility;
import com.comcast.cm.genericUtility.PropertyFileUtility;
import com.comcast.cm.genericUtility.WebDriverUtility;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.elementrepository.CreatingNewOrganizationPage;
import com.comcast.crm.elementrepository.HomePage;
import com.comcast.crm.elementrepository.LoginPage;
import com.comcast.crm.elementrepository.OrganizationInfoPage;
import com.comcast.crm.elementrepository.OrganizationsPage;

public class CreateOrganizationWithPhoneTest extends BaseClass {
	
	@Test
public  void createOrganizationWithPhoneTest() throws IOException {
		
		
		HomePage hp=new HomePage(driver);
		hp.getOrganizationsLink().click();
		
		OrganizationsPage cop=new OrganizationsPage(driver);
		cop.getCreateOrgImg().click();
		
		ExcelUtility eu=new ExcelUtility();
		JavaUtility ju=new JavaUtility();
		int random=ju.randomInputs();
		String orgName=eu.readExcelFile("Sheet1", 1, 2)+random;
		String Phone=eu.readExcelFile("Sheet1", 1, 4);
				
		CreatingNewOrganizationPage cnp=new CreatingNewOrganizationPage(driver);
		cnp.getOrgName(orgName, Phone);
		
		OrganizationInfoPage op=new OrganizationInfoPage(driver);
		String orgHeader=op.getOrgHeaderElement().getText();
		if(orgHeader.contains(orgName)) 	System.out.println(orgHeader+"  passed");
		else System.out.println(orgHeader+"  failed");
	
}
}