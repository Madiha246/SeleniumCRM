package com.comcast.crm.elementrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {


	public ContactInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerMsg;
	
	@FindBy(xpath="//td[@id='mouseArea_Last Name']")
	private WebElement headerlastname;
	
	@FindBy(id="mouseArea_Department")
	private WebElement headerdepartment;

	public WebElement getHeaderdepartment() {
		return headerdepartment;
	}

	public WebElement getHeaderlastname() {
		return headerlastname;
	}

	public WebElement getHeaderMsg() {
		return headerMsg;
	}
	
}
