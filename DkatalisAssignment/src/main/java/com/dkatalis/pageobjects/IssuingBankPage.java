package com.dkatalis.pageobjects;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dkatalis.utils.FrameUtils;

public class IssuingBankPage {
	private WebDriver driver;

	@FindBy(xpath="//div[@id='application']//iframe")
	private WebElement frame;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement passwordText;
	
	@FindBy(xpath="//button[@name='ok']")
	private WebElement okButton;
	
	IssuingBankPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterPassword(Map<String,String> creditCardDetails) throws InterruptedException
	{
		Thread.sleep(3000);
		FrameUtils.switchToFrame(driver,frame);
		driver.switchTo().frame(frame);
		passwordText.sendKeys(creditCardDetails.get("Password"));
	}
	
	public HomePage clickOkButton() throws InterruptedException
	{
		okButton.click();
		Thread.sleep(5000);
		FrameUtils.switchToMainContent(driver);
		return new HomePage(driver);
	}

}
