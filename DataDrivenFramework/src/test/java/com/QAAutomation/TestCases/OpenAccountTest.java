package com.QAAutomation.TestCases;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.QAAutomation.Base.TestBase;
import com.QAAutomation.PageFactory.openAccount;
import com.QAAutomation.Utilities.TestUtil;


public class OpenAccountTest extends TestBase{
	

	@Test(dataProviderClass=TestUtil.class,dataProvider="dp")
	public void openAccountTest(String customer,String currency) throws IOException, InterruptedException {
		
		
		openAccount openacc= new openAccount(driver);
		
		openacc.openAccountbtn().click();
	
		Select select = new Select(openacc.customerDropDown());
		select.selectByVisibleText(customer);
		
		Select select1 = new Select(openacc.currencyDropDown());
		select1.selectByValue(currency);
		
		openacc.processButton().click();
		
		
	}
	
	
}
