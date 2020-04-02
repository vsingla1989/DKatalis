package com.dkatalis.pageobjects;

import java.util.HashMap;

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
		PageFactory.initElements(driver, IssuingBankPage.class);
	}
	
	void enterPassword(HashMap creditCardDetails)
	{
		passwordText.sendKeys(creditCardDetails.get("Password"));
	}
	
	HomePage clickOkButton()
	{
		okButton.click();
		return new HomePage(driver);
	}

}
