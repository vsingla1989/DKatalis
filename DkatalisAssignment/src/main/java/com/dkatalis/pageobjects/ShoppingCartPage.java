package com.dkatalis.pageobjects;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
	WebDriver driver;
	
	@FindBy(xpath="//input[@data-reactid='.0.0.1.0.3.0.0.0.1.0']")
	WebElement nameTextbox;
	
	@FindBy(xpath="//input[@data-reactid='.0.0.1.0.3.0.0.1.1.0']")
	WebElement emailTextbox;
	
	@FindBy(xpath="//input[@data-reactid='.0.0.1.0.3.0.0.2.1.0']")
	WebElement phoneNoTextbox;
	
	@FindBy(xpath="//input[@data-reactid='.0.0.1.0.3.0.0.3.1.0']")
	WebElement cityTextbox;
	
	@FindBy(xpath="//textarea[@data-reactid='.0.0.1.0.3.0.0.4.1.0']")
	WebElement addressTextArea;
	
	@FindBy(xpath="//input[@data-reactid='.0.0.1.0.3.0.0.5.1.0']")
	WebElement postalCodeTextBox;
	
	@FindBy(xpath="//div[@class='cart-checkout']")
	WebElement cartCheckoutButton;
	
	public ShoppingCartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void fillCustomerDetails(Map<String,String> custDetails)
	{
		nameTextbox.clear();
		nameTextbox.sendKeys(custDetails.get("Name"));
		emailTextbox.clear();
		emailTextbox.sendKeys(custDetails.get("Email"));
		phoneNoTextbox.clear();
		phoneNoTextbox.sendKeys(custDetails.get("PhoneNo"));
		cityTextbox.clear();
		cityTextbox.sendKeys(custDetails.get("City"));
		addressTextArea.clear();
		addressTextArea.sendKeys(custDetails.get("Address"));
		postalCodeTextBox.clear();
		postalCodeTextBox.sendKeys(custDetails.get("PostalCode"));
	}
	
	
	public OrderSummaryPage clickCheckoutButton()
	{
		cartCheckoutButton.click();
		return new OrderSummaryPage(driver);
	}
	
}
