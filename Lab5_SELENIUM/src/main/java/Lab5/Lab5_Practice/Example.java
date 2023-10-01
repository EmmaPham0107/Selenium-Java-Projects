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

public class Example {
	
	private ChromeDriver driver;
	
	@BeforeMethod
	public void startBrowser() {
		
//		System.setProperty("webdriver.chrome.driver","./Driver/chromedriver_mac64/chromedriver");
//		driver = new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://accounts.lambdatest.com/register");
	}
	
	
	@Test
	public void TC01() {
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		element.sendKeys("abc@gmail.com");

	}
	
	@Test
	public void TC02() {
		
		WebDriverWait wait = new WebDriverWait(driver,15);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text() = 'SIGN UP']")));
		element.click();
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
	
}
