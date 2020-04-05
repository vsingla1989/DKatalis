package com.dkatalis.utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot {
	
	public static String getScreenshot(WebDriver driver) throws IOException
	{
		long time = System.currentTimeMillis();
		String path = System.getProperty("user.dir")+"\\target\\"+time+".png";
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File desc = new File(path);
		FileHandler.copy(src, desc);
		
		System.out.println(path);
		
		return path;
		
	}

}
