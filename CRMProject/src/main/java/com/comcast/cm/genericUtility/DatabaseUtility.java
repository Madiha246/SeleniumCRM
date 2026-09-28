package com.comcast.cm.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {
	public Connection getDbConnection(String url,String un, String pwd) throws SQLException {
		Driver d=new Driver();
		DriverManager.registerDriver(d);
		return DriverManager.getConnection(url,un,pwd);
 }
	
	public boolean validateDataEnty(String tName, String cName, String data,String url, String un, String pwd) throws SQLException {
		Connection con=getDbConnection(url,un,pwd);
		Statement s=con.createStatement();
		
		return s.execute("select * from "+tName+" where "+cName+"='"+data+" ' ");
	}
	
	
}
