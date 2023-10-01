package Lab7_SELENIUM_ScreenShots;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class CaptureScreenShot {

	public static void takeScreenShot(WebDriver driver, String testcaseName) {
		try {
			String imageName = testcaseName + ".png";
			
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File source = screenshot.getScreenshotAs(OutputType.FILE);
			File destiny = new File("./ScreenShots/"+imageName);
			FileHandler.copy(source, destiny);
			
		} catch (IOException e) {
			
			System.out.print("An error occurred when taking screenshot!");
			e.printStackTrace();
		}
		
		
	}
	
}
