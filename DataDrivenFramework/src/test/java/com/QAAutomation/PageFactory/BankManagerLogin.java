package com.QAAutomation.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankManagerLogin {

	WebDriver driver;
	
	public BankManagerLogin(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//button[contains(text(),'Home')]")
	WebElement home;
	
	@FindBy(xpath="//button[contains(text(),'Add Customer')]")
	WebElement addCustomers;
	
	@FindBy(xpath="//button[contains(text(),'Open Account')]")
	WebElement openAccount;
	
	@FindBy(xpath="//button[contains(text(),'Customers')]")
	WebElement customers;
	
	
	public WebElement getHomeButton() {
		
		return home;
	}
	
	public WebElement getAddCustomersButton() {
		
		return addCustomers;
	}
	
	public WebElement getOpenAccount() {
		
		return openAccount;
	}
	
	public WebElement getCustomersButton() {
		
		return customers;
	}
}
