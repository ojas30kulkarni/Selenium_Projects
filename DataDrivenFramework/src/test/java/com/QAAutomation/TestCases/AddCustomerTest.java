package com.QAAutomation.TestCases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.QAAutomation.Base.TestBase;
import com.QAAutomation.PageFactory.AddCustomer;
import com.QAAutomation.Utilities.TestUtil;


public class AddCustomerTest extends TestBase{
	

	@Test(dataProviderClass=TestUtil.class,dataProvider="dp")
	public void addCustomerTest(String firstName,String lastName,String postalcode) throws IOException, InterruptedException {
		
		
		
		log.debug("Inside Add Customer Page");
		
		AddCustomer addc=new AddCustomer(driver);
		
		addc.addCutomerButton().click();
		addc.enterFirstName().sendKeys(firstName);
		addc.enterLastName().sendKeys(lastName);
		addc.enterPostCode().sendKeys(postalcode);
		addc.AddCustomerSubmit().click();
		
		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		
		
		
		alert.accept();
		
		
		
	}
	
	

}
