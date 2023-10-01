package com.automation.testcase;

import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import com.automation.base.DriverInstance;
import com.automation.pom.LoginPage;
import com.automation.utils.CaptureScreenshot;
import com.automation.utils.PropertiesFile;
import org.testng.Assert;

public class TC_LoginTest extends DriverInstance {

	@Test (dataProvider = "Excel")
	public void TC_LoginAccount(String email, String password) throws IOException, InterruptedException {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openLoginTab();
		loginPage.enterEmail(email);
		loginPage.enterPassword(password);
		loginPage.clickLoginButton();
		
		//Lấy định danh iconLogOut từ properties,
	    //Kiểm tra iconLogOut có hiển thị ko, nếu hiển thị thì click
		WebDriverWait wait = new WebDriverWait(driver,30);
		boolean isLogOutIconDisplayed = false;
		try{
			WebElement iconLogOut = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PropertiesFile.getElements("iconLogOut"))));
			isLogOutIconDisplayed = iconLogOut.isDisplayed();
			iconLogOut.click();
		}
		//Attach screenshot của các testcase fail vào reportNG
		catch(Exception e) {
				int index = email.indexOf("@");
				String accountName = email.substring(0,index);
				CaptureScreenshot.takeScreenshot(driver, accountName);
			}
	Assert.assertEquals(true,isLogOutIconDisplayed , "Login unsuccessfully!");
		
	Thread.sleep(2000);
}
	
	//đọc dữ liệu đầu vào từ file excel	
	@DataProvider (name = "Excel")
	public Object[][] getDataFromExcel() throws IOException{
		
		FileInputStream fis = new FileInputStream("./Data/assignment2_data_test.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet loginSheet = workbook.getSheet("Login");
		int numberOfRow = loginSheet.getPhysicalNumberOfRows();
		
		Object [][] data = new Object [numberOfRow][2];
		
		for (int i=0; i<numberOfRow; i++) {
			
			XSSFRow row = loginSheet.getRow(i);
			XSSFCell username = row.getCell(0);
			XSSFCell password = row.getCell(1);
			data[i][0] = username.getStringCellValue();
			data[i][1] = password.getStringCellValue();
		}
		workbook.close();
		fis.close();
		return data;
	} 
}
