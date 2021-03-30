package com.QAAutomation.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomer {
	
	WebDriver driver;
	
	public AddCustomer(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//input[@ng-model='fName']")
	WebElement enterFirstName;
	
	
	@FindBy(xpath="//input[@ng-model='lName']")
	WebElement enterLastName;
	
	@FindBy(xpath="//input[@ng-model='postCd']")
	WebElement enterPostCode;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement AddCustomerSubmit;
	
	@FindBy(xpath="//button[contains(text(),'Add Customer')]")
	WebElement addCutomerButton;
	
	public WebElement addCutomerButton() {
		
		return addCutomerButton;
		
	}
	
	public WebElement enterFirstName() {
		
		return enterFirstName;
		
	}
	
	public WebElement enterLastName() {
		
		return enterLastName;
	}
	
	public WebElement enterPostCode() {
		
		return enterPostCode;
	}
	
	public WebElement AddCustomerSubmit() {
		
		return AddCustomerSubmit;
	}
	

}
