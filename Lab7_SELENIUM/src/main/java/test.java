import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/webtables");
		
		WebElement firstName1 = driver.findElement(By.xpath("//div[text()='Cierra']"));
		WebElement firstName2 = driver.findElement(By.xpath("//div[text()='Alden']"));
		WebElement firstName3 = driver.findElement(By.xpath("//div[text()='Kierra']"));
		ArrayList <String> data = new ArrayList<>();
		data.add(firstName1.getText());
		data.add(firstName2.getText());
		data.add(firstName3.getText());
		for(int i=0;i<data.size();i++) {
			System.out.print(data.get(i).toString() + " ");
		
		}
	}

}
