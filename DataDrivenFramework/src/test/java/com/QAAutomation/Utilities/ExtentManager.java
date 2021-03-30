package com.QAAutomation.Utilities;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	
	
	public static ExtentReports extent;
	
	public static String ExtentReportFilePath;
	
	public static ExtentSparkReporter spark;
	
	public static ExtentReports getInstance() {
		
			
			ExtentReportFilePath="/Users/ojaskulkarni/eclipse-workspace/DataDrivenFramework/target/surefire-reports/html/extentReport.html";
			extent= new ExtentReports();
			
			spark = new ExtentSparkReporter(ExtentReportFilePath);
			
			extent.attachReporter(spark);
			
			try {
				spark.loadXMLConfig("/Users/ojaskulkarni/eclipse-workspace/DataDrivenFramework/src/test/resources/extentConfig.xml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return extent;
			
		}
		
}


