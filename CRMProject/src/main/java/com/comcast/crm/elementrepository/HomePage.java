package com.comcast.crm.elementrepository;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;

	public HomePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationsLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement logoutEle;
	
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signoutLink;

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getOrganizationsLink() {
		return organizationsLink;
	}

	public WebElement getLogoutEle() {
		return logoutEle;
	}

	public WebElement getSignoutLink() {
		return signoutLink;
	}
	
	public void logOut() {
		
		Actions action=new Actions(driver);
		action.moveToElement(getLogoutEle()).pause(Duration.ofSeconds(2)).click(getSignoutLink()).build().perform();
		
	}

}
