package practice.testng;


import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class HomePageVerificationTest {

		@Test
		public void homePageVerificationTest(Method mtd) {
			
			System.out.println(mtd.getName()+ "  test start");
			String expectedPage="Home";
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();	
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("http://49.249.29.4:8888/");
			
			driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("admin");
			driver.findElement(By.id("submitButton")).click();
			
			String actTitle=driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
			//hard Assert
			Assert.assertEquals(actTitle, expectedPage);
			//if(actTitle.trim().equals(actTitle)) System.out.println(expectedPage+ " page is verified==PASS");
			//else System.out.println(expectedPage+ " page is verified==FAIL");
			
			System.out.println(mtd.getName()+ "  test end");
		}

		
		@Test
		public void logohomePageVerificationTest(Method mtd) {
			
			System.out.println(mtd.getName()+ "  test start");
			String expectedPage="Home";
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();	
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("http://49.249.29.4:8888/");
			
			driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("admin");
			driver.findElement(By.id("submitButton")).click();
			
			boolean status=driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isEnabled();
			//hard Assert
			//Assert.assertEquals(true, status);
			Assert.assertTrue(status);
			//if(status) System.out.println(" Logo is verified==PASS");
			//else System.out.println(" Logo is verified==FAIL");
			
			System.out.println(mtd.getName()+ "  test end");
		}

		
	}


