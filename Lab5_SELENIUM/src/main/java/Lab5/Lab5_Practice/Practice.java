package Lab5.Lab5_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice {
	
	private ChromeDriver driver;
	
	@BeforeMethod
	public void startBrowser() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com.vn/");
	}
	
	@Test
	public void TC_GoogleSearch() {
		
		WebDriverWait wait = new WebDriverWait(driver,15);
		WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@type = 'search']")));
		search.sendKeys("selenium");
		
		WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value = 'Google Search']")));
		button.click();
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
