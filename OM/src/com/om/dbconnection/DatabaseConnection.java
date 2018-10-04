package com.om.dbconnection;

import java.sql.*;
public class DatabaseConnection {

	public static Connection getCon()
	{
		Connection con=null;
		try
		{
			
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "System", "root");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return con;
	}
}
