package lab7_SELENIUM_base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import Lab7_SELENIUM_ScreenShots.CaptureScreenShot;
import io.github.bonigarcia.wdm.WebDriverManager;
import lab7_SELENIUM_library.PropertiesFileUtils;

public class initiateDriver {

	protected WebDriver driver;
	
	@BeforeClass
	public void initDriver () throws IOException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(PropertiesFileUtils.getConfigProperty("base_url"));
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void takeScreenshot(ITestResult result) throws InterruptedException  {
		
		Thread.sleep(1000);
		
		if(ITestResult.FAILURE == result.getStatus()) {
			try {
				CaptureScreenShot.takeScreenShot(driver, result.getName());
				System.out.println("Screenshot taken: " + result.getName());
			}
			catch (Exception e) {
				System.out.println("Exception while taking screenshot " + e.getMessage());
			}
		}	
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
}
