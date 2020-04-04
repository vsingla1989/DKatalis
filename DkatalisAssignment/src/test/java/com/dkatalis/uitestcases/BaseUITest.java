package com.dkatalis.uitestcases;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
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

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseUITest {
	protected WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	String browser;
	int pageLoadTimeout;
	int implicitWait;
	String frontendURL;
	//protected SoftAssert assertion;
	
	BaseUITest() {
		System.out.println("Base contructor");
	}
	
	@BeforeSuite(alwaysRun=true)
	public void beforeTestUI(ITestContext context) {
		//Logger.getLogger("org.apache.http").setLevel(Level.ERROR);
		
		//Getting values from testng.xml
		System.out.println("Before Suite");
		browser= context.getCurrentXmlTest().getParameters().get("Browser");
		pageLoadTimeout = Integer.parseInt(context.getCurrentXmlTest().getParameters().get("Pageload_Timeout"));
		implicitWait = Integer.parseInt(context.getCurrentXmlTest().getParameters().get("Implicit_Wait"));
		frontendURL = context.getCurrentXmlTest().getParameters().get("Frontend_Server");
		
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\com\\dkatalis\\resources\\chromedriver.exe");
		
		/*System.out.println("here1");
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\com\\dkatalis\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("here3");
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\com\\dkatalis\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
			System.out.println("here2");
		}
		
		*/
		
		report=new ExtentReports(System.getProperty("user.dir")+"\\target\\ExtentReport.html",true);
		report.addSystemInfo("Env","QA");
		report.addSystemInfo("Url", frontendURL);
	}
	
	@AfterSuite(alwaysRun=true)
	void afterTestSuite()
	{
		System.out.println("After Suite");
		report.flush();
		report.close();
	}
	
	@BeforeMethod(alwaysRun=true)
	void beforeMethodUI(Method m)
	{
		System.out.println("Before Method");
		test= report.startTest(m.getName());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
		driver.get(frontendURL);
	}
	
	@AfterMethod(alwaysRun=true)
	void afterMethodUI(ITestResult result)
	{
		System.out.println("After Method");
		report.endTest(test);
		driver.close();
	}

}
