package com.comcast.crm.contacttestng;


import java.io.IOException;

import org.testng.annotations.Test;

import com.comcast.cm.genericUtility.ExcelUtility;
import com.comcast.cm.genericUtility.JavaUtility;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.elementrepository.ContactInfoPage;
import com.comcast.crm.elementrepository.ContactsPage;
import com.comcast.crm.elementrepository.CreateContactsPage;
import com.comcast.crm.elementrepository.HomePage;

public class CreateContactWithDepartmentTest {


	public class CreateContactTest extends BaseClass{
		@Test	(groups= {"smokeTest"})	
		public void createContactTest() throws IOException {
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
		String lastname=cip.getHeaderMsg().getText();
		if(lastname.contains(Department))
			System.out.println(lastname + "---Passed");
		else
			System.out.println(lastname + "---Failed");
		

		
		}

	}

}
