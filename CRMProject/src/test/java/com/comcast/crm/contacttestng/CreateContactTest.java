package com.comcast.crm.contacttestng;

import java.io.IOException;

//import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.cm.genericUtility.ExcelUtility;
import com.comcast.cm.genericUtility.JavaUtility;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.elementrepository.ContactInfoPage;
import com.comcast.crm.elementrepository.ContactsPage;
import com.comcast.crm.elementrepository.CreateContactsPage;
import com.comcast.crm.elementrepository.HomePage;


public class CreateContactTest extends BaseClass{
	
	
	@Test	(groups= {"Smoke Test"})		
	public void createContactsTest() throws IOException {
	HomePage hp=new HomePage(driver);
	hp.getContactsLink().click();
	ContactsPage cp=new ContactsPage(driver);
	cp.getCreateContactImg().click();
	
	JavaUtility ju=new JavaUtility();
	int random=ju.randomInputs();
	
	ExcelUtility eutil = new ExcelUtility();
	String LASTNAME = eutil.readExcelFile("Sheet1", 4, 2)+random;
	CreateContactsPage ccp=new CreateContactsPage(driver);
	ccp.getLastName(LASTNAME);
	
	ContactInfoPage cip=new ContactInfoPage(driver);
	String actHeader=cip.getHeaderMsg().getText();
	
	
	//String actHeader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	boolean status=actHeader.contains(LASTNAME);
	Assert.assertEquals(status, true);
	//if(actHeader.equals(LASTNAME)) System.out.println("lastname header is verified===PASS");
	//else System.out.println("lastname header is verified==FAIL");
	
	//String actLastName=driver.findElement(By.xpath("//td[@id='mouseArea_Last Name']")).getText();
	//if(actLastName.equals(LASTNAME))   System.out.println("lastname header is verified===PASS");
	//else System.out.println("lastname header is verified==FAIL");
	String actLastName=cip.getHeaderlastname().getText();
	SoftAssert soft=new SoftAssert();
	soft.assertEquals(actLastName, LASTNAME);

	
	
	System.out.println("1st TC completed");
	}
	
	@Test
	public class CreateContactWithDepartmentTest extends BaseClass{
		@Test	(groups= {"Regression Test"})	
		public void createContactWithDepartmentTest() throws IOException {
		HomePage hp=new HomePage(driver);
		hp.getContactsLink().click();
		ContactsPage cp=new ContactsPage(driver);
		cp.getCreateContactImg().click();
		
		JavaUtility ju=new JavaUtility();
		int random=ju.randomInputs();
		
		ExcelUtility eutil = new ExcelUtility();
		String LASTNAME = eutil.readExcelFile("Sheet1", 4, 2)+random;
		String Department = eutil.readExcelFile("Sheet1", 4, 4)+random;
		CreateContactsPage ccp=new CreateContactsPage(driver);
		ccp.getLastname().sendKeys(LASTNAME);
		ccp.getdepttextfield().sendKeys(Department);
		ccp.getSaveButton().click();
		
		ContactInfoPage cip=new ContactInfoPage(driver);
		
		String actHeader=cip.getHeaderMsg().getText();
		boolean status=actHeader.contains(LASTNAME);
		Assert.assertTrue(status);
	//	if(actHeader.contains(LASTNAME))     System.out.println(actHeader + "---Passed");
	//	else   	System.out.println(actHeader + "---Failed");
		
		String actDept=cip.getHeaderdepartment().getText();
		boolean status1=actDept.contains(Department);
		SoftAssert assertobj=new SoftAssert();
		assertobj.assertTrue(status1);
		
		System.out.println("2nd TC completed");
		
		}
		
		@Test	(groups= {"Regression Test"})	
		public void createContactWithSupportStartDateTest() throws IOException, InterruptedException {
		HomePage hp=new HomePage(driver);
		hp.getContactsLink().click();
		ContactsPage cp=new ContactsPage(driver);
		cp.getCreateContactImg().click();
		
		JavaUtility ju=new JavaUtility();
		int random=ju.randomInputs();
		
		ExcelUtility eutil = new ExcelUtility();
		String LASTNAME = eutil.readExcelFile("Sheet1", 4, 2)+random;
		//String Support_Start_Date = eutil.readExcelFile("Sheet1", 4, 3)+random;
		CreateContactsPage ccp=new CreateContactsPage(driver);
		String Support_Start_Date="2025-01-24";
		ccp.getLastName(LASTNAME, Support_Start_Date);
		
		System.out.println("3rd TC completed");
		

		
		}

	}
	

}
