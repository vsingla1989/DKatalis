package com.dkatalis.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummaryPage {
	WebDriver driver;
	
	@FindBy(xpath="//a[@class='button-main-content']")
	WebElement continueOrderButton;
	
	OrderSummaryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, OrderSummaryPage.class);
	}

	SelectPaymentPage clickContinueButton()
	{
		continueOrderButton.click();
		return new SelectPaymentPage(driver);
	}
}
