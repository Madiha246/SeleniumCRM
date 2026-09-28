package practice.testng;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.cm.genericUtility.ExcelUtility;

public class getPoductInfoThroughExcelDP {

	public class GetProductInfoTest {
		
		@Test(dataProvider="getData")
		public void getProductInfoTest(String BrandName, String ProductName) {
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get("https://www.amazon.in/");
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys(BrandName,Keys.ENTER);
		//	(//span[text()='iPhone 16 128 GB: 5G Mobile Phone with Camera Control, A18 Chip and a Big Boost in Battery Life. Works with AirPods; Ultramarine']/../../../../descendant::span[@class='a-price-whole'])[1]
			
			String price=driver.findElement(By.xpath("(//span[text()='"+ProductName+"']/../../../../descendant::span[@class='a-price-whole'])[1]")).getText();
			System.out.println(price);
			
			driver.quit();	
		}
		
		@DataProvider
		public Object[][] getData() throws EncryptedDocumentException, IOException{
			
			ExcelUtility eu=new ExcelUtility();
			int rowcount=eu.getRowCount("Product");
			System.out.println(rowcount);
			
			Object objArr[][]=new Object[3][2];
			
			for(int i=0;i<rowcount;i++) {
				objArr[i][0]=eu.readExcelFile("Product", i+1, 0);
				objArr[i][1]=eu.readExcelFile("Product", i+1, 1);
			}
			
			
			
			return objArr;
		}
		
		

	}

}
