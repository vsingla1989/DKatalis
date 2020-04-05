package com.dkatalis.uitestcases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.dkatalis.utils.ScreenShot;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseUITest {
	protected WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	String browser;
	int pageLoadTimeout;
	int implicitWait;
	String frontendURL;

	
	@BeforeSuite(alwaysRun=true)
	public void beforeTestUI(ITestContext context) {
		//Getting values of parameters from testng.xml
		browser= context.getCurrentXmlTest().getParameters().get("Browser");
		pageLoadTimeout = Integer.parseInt(context.getCurrentXmlTest().getParameters().get("Pageload_Timeout"));
		implicitWait = Integer.parseInt(context.getCurrentXmlTest().getParameters().get("Implicit_Wait"));
		frontendURL = context.getCurrentXmlTest().getParameters().get("Frontend_Server");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//main//java//com//dkatalis//resources//chromedriver.exe");
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//src//main//java//com//dkatalis//resources//geckodriver.exe");
		}
		
		//Configuring extent reports
		report=new ExtentReports(System.getProperty("user.dir")+"//target//ExtentReport.html",true);
		report.addSystemInfo("Env","QA");
		report.addSystemInfo("Url", frontendURL);
	}
	
	@AfterSuite(alwaysRun=true)
	void afterTestSuite()
	{
		report.flush();
		report.close();
	}
	
	@BeforeMethod(alwaysRun=true)
	void beforeMethodUI(Method m)
	{
		test= report.startTest(m.getName());
		
		//instantiating webdriver object based on value of browser
		if(browser.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if(browser.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
		driver.get(frontendURL);
	}
	
	@AfterMethod(alwaysRun=true)
	void afterMethodUI(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(LogStatus.FAIL, test.addScreenCapture(ScreenShot.getScreenshot(driver)));	
			test.log(LogStatus.FAIL, result.getThrowable());
			test.log(LogStatus.FAIL, result.getName());
		}
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(LogStatus.PASS, result.getName());
		}
		if(result.getStatus()==ITestResult.SKIP)
		{
			test.log(LogStatus.SKIP, result.getName());
		}
		report.endTest(test);
		driver.close();
	}

	public void reportLog(String message) {    
	    test.log(LogStatus.INFO, message);
	}
}
