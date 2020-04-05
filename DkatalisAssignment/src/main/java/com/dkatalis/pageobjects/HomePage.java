package com.dkatalis.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	private WebDriver driver;
	
	@FindBy(xpath="//a[@class='btn buy']")
	private  WebElement buyNowButton;
	
	@FindBy(xpath="//div[@class='trans-status trans-success']/span[1]")
	private  WebElement successMsg1;
	
	@FindBy(xpath="//div[@class='trans-status trans-success']/span[2]")
	private  WebElement successMsg2;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public ShoppingCartPage clickBuyNowButton()
	{
		buyNowButton.click();
		return new ShoppingCartPage(driver);
	}
	
	public String getMessagePart1()
	{
		return successMsg1.getText();
	}
	
	public String getMessagePart2()
	{
		return successMsg2.getText();
	}
	
}
