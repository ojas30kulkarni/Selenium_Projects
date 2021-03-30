package com.QAAutomation.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;	
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[contains(text(),'Customer Login')]")
	WebElement CustomerLogin;
	
	
	@FindBy(xpath="//button[contains(text(),'Bank Manager Login')]")
	WebElement ManagerLogin;
	
	
	public WebElement getCustomerLogin() {
		
		return CustomerLogin;
		
	}
	
	public WebElement getManagerLogin() {
		
		return ManagerLogin;
		
	}
	
}
