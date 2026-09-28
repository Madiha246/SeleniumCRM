package com.comcast.crrm.organizationtestng;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
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
import com.comcast.crm.listenerutility.ListenerImplementation;
import com.comcast.crm.webdriverutility.UtilityClassObject;

public class CreateOrganizationTest extends BaseClass {

	@Test(groups = { "Smoke Test" })
	public void createOrganizationsTest() throws IOException {

		
		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLink().click();

		OrganizationsPage cop = new OrganizationsPage(driver);
		cop.getCreateOrgImg().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		ExcelUtility eu = new ExcelUtility();
		JavaUtility ju = new JavaUtility();
		int random = ju.randomInputs();
		String orgName = eu.readExcelFile("Sheet1", 1, 2) + random;
		
		UtilityClassObject.getTest().log(Status.INFO, "navigating to org page");
		CreatingNewOrganizationPage cnp = new CreatingNewOrganizationPage(driver);
		cnp.getOrgName(orgName);

		UtilityClassObject.getTest().log(Status.INFO, "create org page");
		OrganizationInfoPage op = new OrganizationInfoPage(driver);
		String orgHeader = op.getOrgHeaderElement().getText();
		boolean status = orgHeader.contains(orgName);
		Assert.assertEquals(status, true);
		// if (orgHeader.contains(orgName))System.out.println(orgHeader + " passed");
		// else System.out.println(orgHeader + " failed");
	}

	@Test(groups = { "Regression Test" })
	public void createOrganizationWithIndustryTest() throws IOException {

		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLink().click();

		OrganizationsPage cop = new OrganizationsPage(driver);
		cop.getCreateOrgImg().click();

		ExcelUtility eu = new ExcelUtility();
		JavaUtility ju = new JavaUtility();
		int random = ju.randomInputs();
		String orgName = eu.readExcelFile("Sheet1", 1, 2) + random;
		String Phone = eu.readExcelFile("Sheet1", 1, 4);
		String Industry = eu.readExcelFile("Sheet1", 1, 3);
		CreatingNewOrganizationPage cno = new CreatingNewOrganizationPage(driver);
		cno.getOrgName(orgName, Phone, Industry);

		OrganizationInfoPage op = new OrganizationInfoPage(driver);
		String orgHeader = op.getOrgHeaderElement().getText();
		boolean status = orgHeader.contains(orgName);
		Assert.assertTrue(status);
		// if (orgHeader.contains(orgName))System.out.println(orgHeader + " passed");
		// else System.out.println(orgHeader + " failed");

		String phoneinfo = op.getPhoneinfoheader().getText();
		SoftAssert assertobj = new SoftAssert();
		assertobj.assertEquals(phoneinfo, Phone);
	}

	@Test(groups = { "Regression Test" })
	public void createOrganizationWithPhoneTest() throws IOException {

		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLink().click();

		OrganizationsPage cop = new OrganizationsPage(driver);
		cop.getCreateOrgImg().click();

		ExcelUtility eu = new ExcelUtility();
		JavaUtility ju = new JavaUtility();
		int random = ju.randomInputs();
		String orgName = eu.readExcelFile("Sheet1", 1, 2) + random;
		String Phone = eu.readExcelFile("Sheet1", 1, 4);

		CreatingNewOrganizationPage cnp = new CreatingNewOrganizationPage(driver);
		cnp.getOrgName(orgName, Phone);

		OrganizationInfoPage op = new OrganizationInfoPage(driver);
		String orgHeader = op.getOrgHeaderElement().getText();
		if (orgHeader.contains(orgName))
			System.out.println(orgHeader + "  passed");
		else
			System.out.println(orgHeader + "  failed");

	}
}