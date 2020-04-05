package com.dkatalis.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectPaymentPage {
	private WebDriver driver;
	
	@FindBy(xpath="//a[@href='#/credit-card']")
	private WebElement creditCard;
	
	SelectPaymentPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public CreditCardDetailsPage clickCreditCardOption()
	{
		creditCard.click();
		return new CreditCardDetailsPage(driver);
	}

}
