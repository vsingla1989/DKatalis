package com.dkatalis.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrameUtils {
	public static void switchToFrame(WebDriver driver, int frameIndex)
	{
		WebDriverWait wd = new WebDriverWait(driver,30);
		wd.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
	}
	public static void switchToFrame(WebDriver driver, String frameNameOrID)
	{
		WebDriverWait wd = new WebDriverWait(driver,30);
		wd.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameNameOrID));
	}
	public static void switchToFrame(WebDriver driver, WebElement frameElement)
	{
		WebDriverWait wd = new WebDriverWait(driver,30);
		wd.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
	}
	
	public static void switchToMainContent(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}

}
