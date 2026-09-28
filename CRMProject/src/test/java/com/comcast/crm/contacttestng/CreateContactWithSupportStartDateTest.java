package com.comcast.crm.contacttestng;

import java.io.IOException;

import org.testng.annotations.Test;

import com.comcast.cm.genericUtility.ExcelUtility;
import com.comcast.cm.genericUtility.JavaUtility;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.elementrepository.ContactsPage;
import com.comcast.crm.elementrepository.CreateContactsPage;
import com.comcast.crm.elementrepository.HomePage;

public class CreateContactWithSupportStartDateTest extends BaseClass {
	@Test	(groups= {"smokeTest"})	
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

