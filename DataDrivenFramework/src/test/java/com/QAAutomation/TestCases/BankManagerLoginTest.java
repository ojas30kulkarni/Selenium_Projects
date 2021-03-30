package com.QAAutomation.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.QAAutomation.Base.TestBase;
import com.QAAutomation.PageFactory.BankManagerLogin;
import com.QAAutomation.PageFactory.LoginPage;

public class BankManagerLoginTest extends TestBase {

	@Test
	public void LoginAsBankManager() throws IOException {

		
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		log.debug("Inside Login Test");
		LoginPage p = new LoginPage(driver);
		p.getManagerLogin().click();
		

		log.debug("Login Successfully Executed");

		BankManagerLogin bm = new BankManagerLogin(driver);

		Assert.assertTrue(bm.getAddCustomersButton().isDisplayed(), "Login not Successful");
		log.debug("Bank manager Login Test Pass");
		
		
		Reporter.log("Bank manager Login Test Pass");

		

	}
	
	

}
