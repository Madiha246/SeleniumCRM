package practice.testng;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.mysql.jdbc.Driver;

public class DBCreatePjctAndVerifyDataInDBWitGUI {

	public static void main(String[] args) throws SQLException {
		
		String projectname="hrm";
		Connection conn=null;
		
		//create projct in GUI using Selenium
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8084");
        driver.findElement(By.id("username")).sendKeys("rmgyantra");
        driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
        driver.findElement(By.xpath("//button[text()='Sign in']")).click();
        driver.findElement(By.linkText("Projects")).click();
	    driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.name("projectName")).sendKeys(projectname);
		driver.findElement(By.name("createdBy")).sendKeys("madiha");
		Select sel=new Select(driver.findElement(By.name("status")));
		sel.selectByVisibleText("On Going");
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		
		
		//verify prjct in BACKEND Using JDBC
		boolean flag=false;
		try {
			Driver driverRef=new Driver();
			DriverManager.registerDriver(driverRef);
		    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
			System.out.println("done");
			Statement stat=conn.createStatement();
			ResultSet resultset=stat.executeQuery("select * from project");
			
			while(resultset.next()) {
			   String actProjectName= resultset.getString(4);
			   System.out.println(actProjectName);
			   if(projectname.equals(actProjectName)) {
				   flag =true;
				   System.out.println(projectname+"  is available==PASS");
			    }
			}
			if(flag==false) System.out.println(projectname+"  is not available==Fail");
			Assert.fail();
			}catch(Exception e) {
				System.out.println("handle exception");
			}finally {
			// step 5 : close the connection
			conn.close();
			System.out.println("conn clse");
	        }
	}

}
