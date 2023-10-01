package lab7_SELENIUM_Testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import lab7_SELENIUM_base.initiateDriver;
import lab7_SELENIUM_library.LoginPage;
import lab7_SELENIUM_library.PropertiesFileUtils;

public class Testcase extends initiateDriver {
	
	@Test (priority = 0)
	public void TC01_LoginFirstAccount() throws IOException, InterruptedException {
				
		LoginPage login1 = new LoginPage(driver);
		login1.openLogInTab();
		login1.enterEmail(PropertiesFileUtils.getConfigProperty("email_1"));
		login1.enterPassword(PropertiesFileUtils.getConfigProperty("password_1"));
		login1.clickLogIn();
		WebElement btnLogOut = driver.findElement(By.xpath(PropertiesFileUtils.getElementProperty("btnLogOut")));
		Assert.assertEquals(true, btnLogOut.isDisplayed(), "Login unsuccessfully!");
		btnLogOut.click();
		Thread.sleep(2000);
		
	}
	
	@Test (priority = 1)
	public void  TC02_LoginSecondAccount() throws IOException, InterruptedException {
		
		LoginPage login2 = new LoginPage(driver);
		login2.openLogInTab();
		login2.enterEmail(PropertiesFileUtils.getConfigProperty("email_2"));
		login2.enterPassword(PropertiesFileUtils.getConfigProperty("password_2"));
		login2.clickLogIn();
		WebElement btnLogOut = driver.findElement(By.xpath(PropertiesFileUtils.getElementProperty("btnLogOut")));
		Assert.assertEquals(true, btnLogOut.isDisplayed(), "Login unsuccessfully!");
		btnLogOut.click();
		Thread.sleep(2000);
	}
	
}
