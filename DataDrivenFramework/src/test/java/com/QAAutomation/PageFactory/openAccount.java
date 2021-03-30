package com.QAAutomation.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class openAccount {
	
	WebDriver driver;
	
	public openAccount(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//button[@ng-class='btnClass2']")
	WebElement openAccountbtn;
	
	@FindBy(xpath="//select[@id='userSelect']")
	WebElement customerDropDown;
	
	
	@FindBy(xpath="//select[@id='currency']")
	WebElement currencyDropDown;
	
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement processButton;
	
	public WebElement openAccountbtn() {
		
		return openAccountbtn;
	}
	
	public WebElement customerDropDown() {
		
		return customerDropDown;
	}
	
	public WebElement currencyDropDown() {
		
		return currencyDropDown;
	}
	
	public WebElement processButton() {
		
		return processButton;
	}
	
}
