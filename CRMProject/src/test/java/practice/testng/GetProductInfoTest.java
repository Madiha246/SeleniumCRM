package practice.testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetProductInfoTest {
	
	@Test(dataProvider="getData")
	public void getProductInfoTest(String brandName, String productName) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone13",Keys.ENTER);
		String price=driver.findElement(By.xpath("(//span[text()='iPhone 16 128 GB: 5G Mobile Phone with Camera Control, A18 Chip and a Big Boost in Battery Life. Works with AirPods; Ultramarine']/../../../../div[3]/descendant::span[@class='a-price-whole'])[1]")).getText();
		System.out.println(price);
		
		driver.quit();	
	}
	
	@DataProvider
	public Object[][] getData(){
		Object objArr[][]=new Object[3][2];
		
		objArr[0][0]="iphone13";
		objArr[0][1]="iPhone 16 128 GB: 5G Mobile Phone with Camera Control, A18 Chip and a Big Boost in Battery Life. Works with AirPods; Ultramarine";
		
		objArr[1][0]="iphone13";
		objArr[1][1]="iPhone 17 Pro Max 512 GB: 17.42 cm (6.9″) Display with Promotion, A19 Pro Chip, Best Battery Life in Any iPhone Ever, Pro Fusion Camera System, Center Stage Front Camera";
				
		objArr[0][0]="iphone13";
		objArr[2][1]="iPhone 17 256 GB: 15.93 cm (6.3″) Display with Promotion, A19 Chip, Center Stage Front Camera for Smarter Group Selfies, Improved Scratch Resistance, All-Day Battery Life";
				
		
		return objArr;
	}
	
	

}
