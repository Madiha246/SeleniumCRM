package com.comcast.crm.elementrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement OrgHeaderElement;
	
	@FindBy(xpath="//input[@name='phone']")
	private WebElement phoneinfoheader;

	public WebElement getPhoneinfoheader() {
		return phoneinfoheader;
	}

	public WebElement getOrgHeaderElement() {
		return OrgHeaderElement;
	}
}
