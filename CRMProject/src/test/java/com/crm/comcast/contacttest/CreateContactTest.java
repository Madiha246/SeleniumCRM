package com.crm.comcast.contacttest;

import java.io.IOException;

import org.testng.annotations.Test;

import com.comcast.cm.genericUtility.ExcelUtility;
import com.comcast.cm.genericUtility.JavaUtility;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.elementrepository.ContactInfoPage;
import com.comcast.crm.elementrepository.ContactsPage;
import com.comcast.crm.elementrepository.CreateContactsPage;
import com.comcast.crm.elementrepository.HomePage;


public class CreateContactTest extends BaseClass{
	@Test		
	public void createContactTest() throws IOException {
	HomePage hp=new HomePage(driver);
	hp.getContactsLink().click();
	ContactsPage cp=new ContactsPage(driver);
	cp.getCreateContactImg().click();
	
	JavaUtility ju=new JavaUtility();
	int random=ju.randomInputs();
	
	ExcelUtility eutil = new ExcelUtility();
	String LASTNAME = eutil.readExcelFile("Sheet1", 4, 2)+random;
	CreateContactsPage ccp=new CreateContactsPage(driver);
	ccp.getLastname().sendKeys(LASTNAME);
	ccp.getSaveButton().click();
	
	ContactInfoPage cip=new ContactInfoPage(driver);
	String lastname=cip.getHeaderMsg().getText();
	if(lastname.contains(LASTNAME))
		System.out.println(lastname + "---Passed");
	else
		System.out.println(lastname + "---Failed");
	
	//if(actHeader.equals(LASTNAME)) System.out.println("lastname header is verified===PASS");
		//else System.out.println("lastname header is verified==FAIL");
		
		//String actLastName=driver.findElement(By.xpath("//td[@id='mouseArea_Last Name']")).getText();
		//if(actLastName.equals(LASTNAME))   System.out.println("lastname header is verified===PASS");
		//else System.out.println("lastname header is verified==FAIL");
	
	}

}
