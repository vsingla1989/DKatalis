package com.dkatalis.pageobjects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreditCardDetailsPage {
	private WebDriver driver;
	
	@FindBy(xpath="//div[@class='notice danger']/div[@class='content']")
	private WebElement invalidCardMsg;
	
	@FindBy(xpath="//input[@name='cardnumber']")
	private WebElement cardNumberTextbox;
	
	@FindBy(xpath="//div[@class='input-group col-xs-7']/input")
	private WebElement expiryDateTextbox;
	
	@FindBy(xpath="//div[@class='input-group col-xs-5']/input")
	private WebElement cvvTextbox;

	@FindBy(xpath="//input[@type='checkbox' and @name='promo']")
	private List<WebElement> promoCheckboxes;
	
	@FindBy(xpath="//div[@class='text-button-main']/span")
	private WebElement payNowButton;
	
	CreditCardDetailsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void fillcreditCardDetails(Map<String,String> creditCardDetails)
	{
		cardNumberTextbox.sendKeys(creditCardDetails.get("CardNumber"));
		expiryDateTextbox.sendKeys(creditCardDetails.get("ExpiryDate"));
		cvvTextbox.sendKeys(creditCardDetails.get("CVV"));
	}
	
	public void uncheckPromoCheckboxes()
	{
		for(WebElement promoCheckbox : promoCheckboxes)
		{
			if(promoCheckbox.isSelected())
				promoCheckbox.click();
		}
	}
	
	public IssuingBankPage clickPayNowButton()
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", payNowButton);
		//payNowButton.click();
		return new IssuingBankPage(driver);
	}

}
