package com.comcast.crm.elementrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactsPage {
	public CreateContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "lastname")
	private WebElement lastname;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(xpath="(//img[@alt='Select'])[1]")
	private WebElement orgImg;

	@FindBy(id="department")
	private WebElement depttextfield;
	
	@FindBy(xpath="//input[@name='support_start_date']")
	private WebElement support_start_date_calendar;
	
	public void getLastName(String name) {
		lastname.clear();
		lastname.sendKeys(name);
		saveButton.click();
	}
	
	public void getLastName(String name, String supportdate) {
		lastname.clear();
		lastname.sendKeys(name);
		support_start_date_calendar.sendKeys(supportdate);
		saveButton.click();
	}
	
	public WebElement getsupport_start_date_calendar() {
		return support_start_date_calendar;
	}
	
	public WebElement getOrgImg() {
		return orgImg;
	}

	
	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	public WebElement getdepttextfield() {
		return depttextfield;
	}
	

}
