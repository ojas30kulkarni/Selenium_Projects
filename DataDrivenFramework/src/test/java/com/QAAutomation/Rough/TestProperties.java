package com.QAAutomation.Rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Properties config=new Properties();
		FileInputStream fis=new FileInputStream("/Users/ojaskulkarni/eclipse-workspace/DataDrivenFramework/src/test/resources/Properties/Config.properties");
		config.load(fis);
		
		String browserName=config.getProperty("browser");
		System.out.println(browserName);
		
		
		
		
		
	}

}
