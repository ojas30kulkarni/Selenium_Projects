package com.QAAutomation.Listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;

import com.QAAutomation.Base.TestBase;
import com.QAAutomation.Utilities.TestUtil;
import com.aventstack.extentreports.Status;

public class CustomListeners extends TestBase implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		String testname=result.getMethod().getMethodName();
		test=rep.createTest(testname);
		
		//runmode -Y
		
		
		
	}

	public void onTestSuccess(ITestResult result) {
	
		test.log(Status.PASS, result.getName()+"  "+"pass");
		
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		test.log(Status.FAIL, result.getName()+"  "+"Failed with Exception"+result.getThrowable());
		//test.addScreenCaptureFromPath(TestUtil.scrName);
		
		
		try {
			TestUtil.CaptureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("Click to see Screenshot");
		
		Reporter.log("<a target=\"_blank\" href="+TestUtil.scrName+">Screenshot</a>");
		
		
		
	}

	
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
		test.log(Status.SKIP, "Skipping Test as RunMode is No"+result.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		
		rep.flush();
	}

}
