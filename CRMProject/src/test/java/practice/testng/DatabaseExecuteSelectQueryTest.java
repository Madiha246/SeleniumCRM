package practice.testng;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseExecuteSelectQueryTest {

	public static void main(String[] args) throws SQLException {
		// step 1 :load/register the database driver
		// step 2 : connect to database
		// step 3 : create Sql statement
		// step 4 : execute select query & get result
		// step 5 : close the connection
		
		//syntax: jdbc:vendor:ip:portno:DBname
		//jdbc:mysql://localhost:3306/projects
		
		// step 1 :load/register the database driver
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
		// step 2 : connect to database
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		System.out.println("done");
		
		// step 3 : create Sql statement
		Statement stat=conn.createStatement();
		
		ResultSet resultset=stat.executeQuery("select * from project");
		
		//to print 1st data
		String data1=resultset.getString(1); System.out.println(data1);

		//to print whole set
		// for 1st columndata System.out.println(resultset.getString(1));, for other clumns we concatenate
		while(resultset.next()) {
			System.out.println(resultset.getString(1) +"\t"+ resultset.getString(2) +"\t"+ resultset.getString(3) +"\t"+ 
		    resultset.getString(4) +"\t"+ resultset.getInt(5));
		}
		
		// step 5 : close the connection
		conn.close();
	}

}
