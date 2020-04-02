package com.dkatalis.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(xpath="//a[@class='btn buy']")
	WebElement buyNowButton;
	
	@FindBy(xpath="//div[@class='cart-checkout']")
	WebElement cartCheckoutButton;
	
	@FindBy(xpath="//a[@class='button-main-content']")
	WebElement continueOrderButton;
	
	@FindBy(xpath="//a[@href='#/credit-card']")
	WebElement creditCard;
	
	@FindBy(xpath="//div[@class='text-button-main']/span")
	WebElement payNowButton;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement passwordText;
	
	@FindBy(xpath="//button[@name='ok']")
	WebElement okButton;
	
	@FindBy(xpath="//div[@class='trans-status trans-success']/span[1]")
	WebElement successMsg1;
	
	@FindBy(xpath="//div[@class='trans-status trans-success']/span[2]")
	WebElement successMsg2;
	
	HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, HomePage.class);
	}
	
	
}
