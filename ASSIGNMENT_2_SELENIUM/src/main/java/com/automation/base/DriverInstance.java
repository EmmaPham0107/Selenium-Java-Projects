package com.automation.base;


import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import com.automation.utils.CaptureScreenshot;
import com.automation.utils.PropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;


public class DriverInstance {

	public static WebDriver driver;
	
	@BeforeClass
	public void initDriverInstance() throws IOException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(PropertiesFile.getConfigs("base_url"));
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
	}
	
	@AfterClass
	public void closeDriverInstance() {
		driver.close();
	}
}
