package com.dkatalis.pageobjects;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreditCardDetailsPage {
	WebDriver driver;
	
	@FindBy(xpath="//div[@class='notice danger']/div[@class='content']")
	WebElement invalidCardMsg;
	
	@FindBy(xpath="//input[@name='cardnumber']")
	WebElement cardNumberTextbox;
	
	@FindBy(xpath="//div[@class='input-group col-xs-7']/input")
	WebElement expiryDateTextbox;
	
	@FindBy(xpath="//div[@class='input-group col-xs-5']/input")
	WebElement cvvTextbox;

	@FindBy(xpath="//label[text()='Promo Weekend']/input[@type='checkbox']")
	WebElement promoWeekendCheckbox;
	
	@FindBy(xpath="//div[@class='text-button-main']/span")
	WebElement payNowButton;
	
	CreditCardDetailsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, CreditCardDetailsPage.class);
	}
	
	void fillcreditCardDetails(HashMap creditCardDetails)
	{
		cardNumberTextbox.sendKeys(creditCardDetails.get("CardNumber"));
		expiryDateTextbox.sendKeys(creditCardDetails.get("ExpiryDate"));
		cvvTextbox.sendKeys(creditCardDetails.get("CVV"));
	}
	
	void uncheckPromoCheckbox()
	{
		promoWeekendCheckbox.click();
	}
	
	IssuingBankPage clickPayNowButton()
	{
		payNowButton.click();
		return new IssuingBankPage(driver);
	}

}
