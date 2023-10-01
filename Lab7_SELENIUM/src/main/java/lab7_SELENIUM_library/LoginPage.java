package lab7_SELENIUM_library;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver = null;
	
	public LoginPage (WebDriver driver){
		this.driver = driver;
	}
	
	public void openLogInTab() {
		
		WebElement LogInTab = driver.findElement(By.xpath(PropertiesFileUtils.getElementProperty("iconLogIn")));
		LogInTab.click();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PropertiesFileUtils.getElementProperty("inputEmail"))));
		
	}

	public void enterEmail(String email) throws IOException, InterruptedException {
		
		WebElement enterEmail = driver.findElement(By.xpath(PropertiesFileUtils.getElementProperty("inputEmail")));
		enterEmail.sendKeys(email);
		Thread.sleep(2000);
		
	}
	
	public void enterPassword (String password) throws IOException, InterruptedException {
		
		WebElement enterPass = driver.findElement(By.xpath(PropertiesFileUtils.getElementProperty("inputPassword")));
		enterPass.sendKeys(password);
		Thread.sleep(2000);
		
	}
	
	public void clickLogIn () throws IOException, InterruptedException {
		
		WebElement btnLogIn = driver.findElement(By.xpath(PropertiesFileUtils.getElementProperty("btnLogIn")));
		btnLogIn.click();;
		Thread.sleep(2000);
		
	}
	
}
