package com.QAAutomation.Rough;

import java.util.Date;

public class TestTimeStamp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Date d= new Date();
		String screenshotName=d.toString().replace(":", "_").replace(" ","_");
		
		String[] sName=screenshotName.split("_EST");
		System.out.println(screenshotName);
		System.out.println(sName[0]);
		System.out.println(sName[1]);
		

	}

}
