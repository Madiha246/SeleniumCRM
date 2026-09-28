package practice.testng;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseExecuteNonSQLQueryTest {

	public static void main(String[] args) throws SQLException {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
		// step 2 : connect to database
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		System.out.println("done");
		
		// step 3 : create Sql statement
		Statement stat=conn.createStatement();
		
		int result=stat.executeUpdate("insert into project values('TY_PROJ_2001','Madiha','04/24/2024','Fb_24', 'Ongoing','100')");
		System.out.println(result);//1 executed poperly, 0=not executed

		
		// step 5 : close the connection
		conn.close();
	

	}

}
