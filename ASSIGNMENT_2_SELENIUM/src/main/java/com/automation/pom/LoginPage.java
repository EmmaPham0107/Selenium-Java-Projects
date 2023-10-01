package com.automation.pom;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.utils.PropertiesFile;

public class LoginPage {
	
	WebDriver driver;
	public WebElement btnA;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	//Lấy định danh iconLogin từ properties file và tìm kiếm, click
	public void openLoginTab() throws IOException {
		
		WebElement loginIcon = driver.findElement(By.xpath(PropertiesFile.getElements("iconLogIn")));
		loginIcon.click();
		WebDriverWait wail = new WebDriverWait(driver,30);
		wail.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PropertiesFile.getElements("inputEmail"))));
		
	}
	
	public void enterEmail(String email) throws IOException, InterruptedException {
		
		WebElement inputEmail = driver.findElement(By.xpath(PropertiesFile.getElements("inputEmail")));
		inputEmail.sendKeys(email);
		Thread.sleep(2000);
		
	}
	
	public void enterPassword(String password) throws IOException, InterruptedException {
		
		WebElement inputPassword = driver.findElement(By.xpath(PropertiesFile.getElements("inputPassword")));
		inputPassword.sendKeys(password);
		Thread.sleep(2000);
	}
	
	public void clickLoginButton () throws IOException, InterruptedException {
		
		WebElement btnLogin = driver.findElement(By.xpath(PropertiesFile.getElements("btnLogIn")));
		btnLogin.click();;
		Thread.sleep(2000);
	}
	
}
