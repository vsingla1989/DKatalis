package com.dkatalis.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dkatalis.utils.FrameUtils;

public class OrderSummaryPage {
	private WebDriver driver;
	
	@FindBy(xpath="//iframe[contains(@name,'popup_')]")
	private WebElement frame;
	
	@FindBy(xpath="//a[@class='button-main-content']")
	private WebElement continueOrderButton;
	
	public OrderSummaryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public SelectPaymentPage clickContinueButton()
	{
		FrameUtils.switchToFrame(driver, frame);
		continueOrderButton.click();
		return new SelectPaymentPage(driver);
	}
	
}
