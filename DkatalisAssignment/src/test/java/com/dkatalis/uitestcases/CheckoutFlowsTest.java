package com.dkatalis.uitestcases;


import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.dkatalis.pageobjects.CreditCardDetailsPage;
import com.dkatalis.pageobjects.HomePage;
import com.dkatalis.pageobjects.IssuingBankPage;
import com.dkatalis.pageobjects.OrderSummaryPage;
import com.dkatalis.pageobjects.SelectPaymentPage;
import com.dkatalis.pageobjects.ShoppingCartPage;
import com.dkatalis.utils.CSVReader;

public class CheckoutFlowsTest extends BaseUITest{

	
	/*@BeforeMethod
	void beforeMethodUI(Method m)
	{
		System.out.println("Another Before Method");
		test= report.startTest(m.getName());
	}
	
	@AfterMethod
	void afterMethodUI(ITestResult result)
	{
		System.out.println("Another After Method");
		report.endTest(test);
	}*/
	
	@Test
	void purchasePillowCreditCard() throws InterruptedException, IOException
	{
		System.out.println("here1");
		
		Map<String,String> customerData= CSVReader.readCSV(System.getProperty("user.dir")+"//src//main//java//com//dkatalis//resources//CustomerDetails.csv", 1);
		Map<String,String> creditCardData= CSVReader.readCSV(System.getProperty("user.dir")+"//src//main//java//com//dkatalis//resources//CreditCardDetails.csv", 1);
		
		System.out.println("here2");
		
		HomePage homePage = new HomePage(driver);
		ShoppingCartPage shoppingCartPage= homePage.clickBuyNowButton();
		shoppingCartPage.fillCustomerDetails(customerData);
		OrderSummaryPage orderSummaryPage= shoppingCartPage.clickCheckoutButton();
		SelectPaymentPage selectPaymentPage= orderSummaryPage.clickContinueButton();
		CreditCardDetailsPage creditCardDetailsPage= selectPaymentPage.clickCreditCardOption();
		creditCardDetailsPage.fillcreditCardDetails(creditCardData);
		creditCardDetailsPage.uncheckPromoCheckbox();
		IssuingBankPage issuingBankPage= creditCardDetailsPage.clickPayNowButton();
		issuingBankPage.enterPassword(creditCardData);
		homePage= issuingBankPage.clickOkButton();
		
		Assert.assertEquals(homePage.successMsg1, "Thank you for your purchase.");
		Assert.assertEquals(homePage.successMsg2, "Get a nice sleep.");
	}
	
	//@Test
	void purchasePillowCreditCardNegative()
	{
		System.out.println("Hello");
		System.out.println(Thread.currentThread().getId());
	}
	
	
	
	
	
}
