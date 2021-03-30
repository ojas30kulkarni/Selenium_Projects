package com.QAAutomation.Utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.QAAutomation.Base.TestBase;

public class TestUtil extends TestBase{
	
	
	//public static String scrshotFile;
	public static String scrName;
	
	
	public static void CaptureScreenshot() throws IOException {
		
		
		Date d= new Date();
		scrName=d.toString().replace(":", "_").replace(" ","_");
		
		File screenshotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File("/Users/ojaskulkarni/eclipse-workspace/DataDrivenFramework/target/surefire-reports/html/"+scrName));
		
	}
	
	
	@DataProvider(name="dp")
	public Object[][] getData(Method m){
		 
		String sheetName=m.getName();
		int rows=e.getRowCount(sheetName);
		int cols=e.getColumnCount(sheetName);
		
		Object[][] data= new Object[rows-1][cols];
		
		for(int rowNum=2;rowNum<=rows;rowNum++ ) {
			
			for(int colNum=0;colNum<cols;colNum++) {
				
				data[rowNum-2][colNum]=e.getCellData(sheetName,colNum,rowNum);
				
			}
			
		}
		return data;
		
		
	}
	
	public static boolean isTestRunnable(String testName,ExcelReader excel) {
		
		String sheetName="test_suite";
		int rows=excel.getRowCount(sheetName);
		
		for(int rNum=2;rNum<=rows;rNum++) {
			
			String testCase=excel.getCellData(sheetName, "TCID", rNum);
			
			if(testCase.equalsIgnoreCase(testName)) {
				
				String runMode=excel.getCellData(sheetName, "RunMode", rNum);
				if(runMode.equalsIgnoreCase("Y")) {
					return true;
				}
				else {
					return false;
				}
				
			}
			return false;
			
			
		}
		
		
		return false;
		
		
	}


}
