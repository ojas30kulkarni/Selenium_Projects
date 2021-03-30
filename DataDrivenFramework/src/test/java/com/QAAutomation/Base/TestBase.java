package com.QAAutomation.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.QAAutomation.Utilities.ExcelReader;
import com.QAAutomation.Utilities.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class TestBase {
	
	/*Initializing
	 * WebDriver
	 * Properties
	 * Logs
	 * ExtentReport
	 * DB
	 * Excel
	 * Mail
	 */
	
	public static WebDriver driver;
	public static Properties config;
	public static FileInputStream fis;
	public static Logger log=Logger.getLogger("devpinoyLogger");
	public static ExcelReader e=new ExcelReader("/Users/ojaskulkarni/eclipse-workspace/DataDrivenFramework/src/test/resources/ExcelTestData/TestData.xlsx");
	public static WebDriverWait wait;
	public static ExtentReports rep=ExtentManager.getInstance();
	public static ExtentTest test;
	public static String browser;
	
	
	@BeforeSuite
	public WebDriver SetUp() throws IOException {
	
	config=new Properties();
	
	FileInputStream fis=new FileInputStream("/Users/ojaskulkarni/eclipse-workspace/DataDrivenFramework/src/test/resources/Properties/Config.properties");
	config.load(fis);
	log.debug("Config File Loaded");
	
	String browserName=config.getProperty("browser");
	
	if(System.getenv("browser")!=null && !System.getenv("browser").isEmpty()){
		
		browser=System.getenv("browser");
	}else {
		
		browser=config.getProperty("browser");
	}
	
	config.setProperty("browser", browser);
 	
	
	if(browserName.equalsIgnoreCase("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "/Users/ojaskulkarni/Desktop/Selenium/Drivers/chromedriver");
		
		driver =new ChromeDriver();
		log.debug("Chrome Browser Launched");

	}
	else if(browserName.equalsIgnoreCase("firefox")) {
		
		System.setProperty("webdriver.gecko.driver", "/Users/ojaskulkarni/Desktop/Selenium/Drivers/geckodriver");
		
		driver= new FirefoxDriver();
		
	}
	
	driver.get(config.getProperty("url"));
	
	log.debug("URL Launched"+config.getProperty("url"));
	
	//driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	wait=new WebDriverWait(driver,5);
	
	return driver;
	
	}
	
	/*public void click(WebElement element) {
		
		element.click();
		test.log(Status.INFO, "Clicking on"+"   "+element);
		
	}
		
	
	public void type(WebElement element, String value) {
		
		element.sendKeys(value);
		test.log(Status.INFO, "Typing on"+"  "+element+"Values are"+ "  "+value);
	}
	*/
	
	
	@AfterSuite
	public void tearDown() throws InterruptedException {
		
		
		driver.quit();
	}
	
	

}
