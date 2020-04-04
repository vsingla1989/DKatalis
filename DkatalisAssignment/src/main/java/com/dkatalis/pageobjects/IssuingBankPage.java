package com.dkatalis.pageobjects;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IssuingBankPage {
	WebDriver driver;

	@FindBy(xpath="//input[@type='password']")
	WebElement passwordText;
	
	@FindBy(xpath="//button[@name='ok']")
	WebElement okButton;
	
	IssuingBankPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterPassword(Map<String,String> creditCardDetails)
	{
		passwordText.sendKeys(creditCardDetails.get("Password"));
	}
	
	public HomePage clickOkButton()
	{
		okButton.click();
		return new HomePage(driver);
	}

}
