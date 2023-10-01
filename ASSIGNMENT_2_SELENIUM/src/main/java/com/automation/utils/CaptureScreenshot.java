package com.automation.utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class CaptureScreenshot {
	
	static String fileName = null;

	public static void takeScreenshot (WebDriver driver, String accountName) {
		
		String imageName = accountName + ".png";
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		fileName = "./Screenshots/"+imageName;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File destiny = new File(fileName);
		try {
			FileHandler.copy(source, destiny);
		} catch (IOException e) {
			System.out.println("An error occurred when taking screenshot!");
			e.printStackTrace();
		}
		attachScreenshot();
	}
	
	public static void attachScreenshot() {
		
		try {
			System.setProperty("org.uncommons.reportng.escape-output", "false");
			File file = new File(fileName);
		
			Reporter.log("<br><a title=\"ScreenShot\"href=\"" + file.getAbsolutePath() + "\">" 
					+ "<img alt='" + file.getName()+"'src='" + file.getAbsolutePath() + "'height='243' width='418'/></a><br>");
			
		} catch (Exception e) {
			System.out.println("An error occurred when taking screenshot!");
			e.printStackTrace();
		}
		
	}
	
}
