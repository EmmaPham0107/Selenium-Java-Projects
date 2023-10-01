package Lab6.Lab6_Practice;

import java.util.concurrent.TimeUnit;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Lab6_Selenium {

	private WebDriver driver;
	
	@BeforeMethod
	public void initBrowser() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		
	}
	
	@Test
	public void TC_MyOderSearchValid() {

		//Mở URL. Quá trình tải trang không vượt quá 15s
		driver.get("https://automationexercise.com/products");
		Actions act = new Actions(driver);
		try {
		WebDriverWait wait15s = new WebDriverWait(driver,15);
		WebElement search = wait15s.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_product")));
		Assert.assertEquals(true, search.isDisplayed(),"Page load failed");
		act.click(search);
		}
		catch(Exception e) {
			System.out.println("Page load failed");
		}
		//tìm kiếm từ khóa. Quá trình tìm kiếm không vượt quá 5s.
		WebDriverWait wait5s = new WebDriverWait(driver,5);
		act.sendKeys("Stylish Dress").click(driver.findElement(By.id("submit_search"))).build().perform();
		wait5s.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class = 'title text-center']")));
		Assert.assertEquals(true, driver.findElement(By.xpath("//a[text() = 'View Product']")).isDisplayed(),"Search failed");
		
		//Kiểm tra kết quả đảm bảo chỉ 1 Item được tìm thấy??
		Assert.assertEquals(driver.findElements(By.xpath("//div[@class = 'single-products']")).size(),1,"The number of items differ from 1 item");
		
		//Kiểm tra hình ảnh Item có được hiển thị hay không, đảm bảo item được hiển thị cùng tên tìm kiếm và chứa thông tin giá bán
		Assert.assertEquals(true,driver.findElement(By.xpath("//img[@src='/get_product_picture/4']")).isDisplayed(),"The item's image is not displayed");
		Assert.assertEquals(driver.findElement(By.xpath("//p[text() = 'Stylish Dress']")).getText(),"Stylish Dress","The item's name differs from the searched name ");
		Assert.assertEquals(true, driver.findElement(By.xpath("//h2[text()='Rs. 1500']")).isDisplayed(),"Item's price is not displayed");
		
		//Đảm bảo button “Add to cart” được hiển thị trên Item
		Assert.assertEquals(true, driver.findElement(By.xpath("//a[text()='Add to cart']")).isDisplayed(),"'Add to cart' buton is not displayed");
		
		//Thực hiện click vào button “Add to cart”. Quá trình thêm giỏ hàng không quá 5s. Kiểm tra thêm giỏ hàng thành công hay thất bại.
		act.keyDown(Keys.ALT).sendKeys(Keys.ARROW_DOWN).keyUp(Keys.ALT)
			.build()
			.perform();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		act.click(driver.findElement(By.xpath("//a[@class ='btn btn-default add-to-cart']")))
			.build()
			.perform();	
		WebElement msg = wait5s.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[text()='Your product has been added to cart.']"))));
		Assert.assertEquals(msg.getText(), "Your product has been added to cart.","The item has been added to cart successfully");
	
	
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
	
}
