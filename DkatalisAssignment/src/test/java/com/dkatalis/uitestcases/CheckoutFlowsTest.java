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

	final private String expectedMgs1 = "Thank you for your purchase.";
	final private String expectedMgs2 = "Get a nice sleep.";
	
	
	@Test(description="Verify user is able to successfully place an order for purchasing a pillow")
	void purchasePillowCreditCard() throws InterruptedException, IOException
	{
		
		Map<String,String> customerData= CSVReader.readCSV(System.getProperty("user.dir")+"//src//main//java//com//dkatalis//resources//CustomerDetails.csv", 1);
		Map<String,String> creditCardData= CSVReader.readCSV(System.getProperty("user.dir")+"//src//main//java//com//dkatalis//resources//CreditCardDetails.csv", 1);
		HomePage homePage = new HomePage(driver);
		
		reportLog("Click on Buy Now button");
		ShoppingCartPage shoppingCartPage= homePage.clickBuyNowButton();
		
		reportLog("Input the customer details");
		shoppingCartPage.fillCustomerDetails(customerData);
		
		reportLog("Click on Checkout button");
		OrderSummaryPage orderSummaryPage= shoppingCartPage.clickCheckoutButton();
		
		reportLog("Click on Continue button");
		SelectPaymentPage selectPaymentPage= orderSummaryPage.clickContinueButton();
		
		reportLog("Choose Credit Card by clicking on it");
		CreditCardDetailsPage creditCardDetailsPage= selectPaymentPage.clickCreditCardOption();
		
		reportLog("Input credit card details, uncheck the checked promos and click on Pay Now button");
		creditCardDetailsPage.fillcreditCardDetails(creditCardData);
		creditCardDetailsPage.uncheckPromoCheckboxes();
		IssuingBankPage issuingBankPage= creditCardDetailsPage.clickPayNowButton();
		
		reportLog("Enter the password and click on Ok button");
		issuingBankPage.enterPassword(creditCardData);
		homePage= issuingBankPage.clickOkButton();
		
		reportLog("Verify success message on homepage");
		String actualMgs1=homePage.getMessagePart1();
		String actualMgs2=homePage.getMessagePart2();
		Assert.assertEquals(actualMgs1,expectedMgs1);
		Assert.assertEquals(actualMgs2,expectedMgs2);
	}
	
	@Test(description="Verify user is not able to place an order when incorect credit card innfo is given")
	void purchasePillowCreditCardNegative() throws InterruptedException, IOException
	{
		Map<String,String> customerData= CSVReader.readCSV(System.getProperty("user.dir")+"//src//main//java//com//dkatalis//resources//CustomerDetails.csv", 1);
		Map<String,String> creditCardData= CSVReader.readCSV(System.getProperty("user.dir")+"//src//main//java//com//dkatalis//resources//CreditCardDetails.csv", 2);
		HomePage homePage = new HomePage(driver);
		
		reportLog("Click on Buy Now button");
		ShoppingCartPage shoppingCartPage= homePage.clickBuyNowButton();
		
		reportLog("Input the customer details");
		shoppingCartPage.fillCustomerDetails(customerData);
		
		reportLog("Click on Checkout button");
		OrderSummaryPage orderSummaryPage= shoppingCartPage.clickCheckoutButton();
		
		reportLog("Click on Continue button");
		SelectPaymentPage selectPaymentPage= orderSummaryPage.clickContinueButton();
		
		reportLog("Choose Credit Card by clicking on it");
		CreditCardDetailsPage creditCardDetailsPage= selectPaymentPage.clickCreditCardOption();
		
		reportLog("Input credit card details, uncheck the checked promos and click on Pay Now button");
		creditCardDetailsPage.fillcreditCardDetails(creditCardData);
		creditCardDetailsPage.uncheckPromoCheckboxes();
		IssuingBankPage issuingBankPage= creditCardDetailsPage.clickPayNowButton();
		
		reportLog("Enter the password and click on Ok button");
		issuingBankPage.enterPassword(creditCardData);
		homePage= issuingBankPage.clickOkButton();
		
		reportLog("Verify success message on homepage");
		String actualMgs1=homePage.getMessagePart1();
		String actualMgs2=homePage.getMessagePart2();
		Assert.assertEquals(actualMgs1,expectedMgs1);
		Assert.assertEquals(actualMgs2,expectedMgs2);
	}
	
	
	
	
	
}
