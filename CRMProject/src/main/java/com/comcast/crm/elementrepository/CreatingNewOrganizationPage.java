
package com.comcast.crm.elementrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {
	
   public CreatingNewOrganizationPage(WebDriver driver) {
	   PageFactory.initElements(driver, this);
   }
	
	 @FindBy(name = "accountname")
	 private WebElement orgName;
	 
	 @FindBy(xpath = "//input[@title='Save [Alt+S]']")
	 private WebElement saveButton;
	 
	 public WebElement getPhone() {
		return phone;
	}

	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	@FindBy(name="phone")
	 private WebElement phone;

	 @FindBy(name="industry")
	 private WebElement industry;
	 
		public void getOrgName(String orgname) {
			orgName.clear();
			orgName.sendKeys(orgname);
			saveButton.click();
		}
		
		public void getOrgName(String orgname, String phoneno) {
			orgName.clear();
			orgName.sendKeys(orgname);
			phone.sendKeys(phoneno);
			saveButton.click();
		}
		
		public void getOrgName(String orgname, String phoneno, String industrydropdown) {
			orgName.clear();
			orgName.sendKeys(orgname);
			Select select=new Select(industry);
			select.selectByVisibleText(industrydropdown);
			phone.sendKeys(phoneno);
			saveButton.click();
		}

		
	
	
}
