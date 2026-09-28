package practice.testng;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;

import com.mysql.jdbc.Driver;

public class DatabaseUnitTestCheckPrjctInBackend {

	public static void main(String[] args) throws SQLException {
		
		Connection conn=null;
		boolean flag=false;
		String expectedProjectName="FB_01";
		
		try {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
		// step 2 : connect to database
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		System.out.println("done");
		
		// step 3 : create Sql statement
		Statement stat=conn.createStatement();
		
		ResultSet resultset=stat.executeQuery("select * from project");
		
		while(resultset.next()) {
		   String actProjectName= resultset.getString(4);
		   System.out.println(actProjectName);
		   if(expectedProjectName.equals(actProjectName)) {
			   flag =true;
			   System.out.println(expectedProjectName+"  is available==PASS");
		    }
		}
		if(flag==false) System.out.println(expectedProjectName+"  is not available==Fail");
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
