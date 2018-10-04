package com.om.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.om.dbconnection.DatabaseConnection;

public class ProfileUpdate {
	
	public static int update(String s,String s1,String e) throws SQLException
	{
		
		Connection con=DatabaseConnection.getCon();
		PreparedStatement ps;
		if(s.equals("username"))
		{
			ps=con.prepareStatement("update authors set username=? where email=?");
			ps.setString(1, s1);
			ps.setString(2, e);
			int rs=ps.executeUpdate();
			return rs;
		}
		else if(s.equals("fullname"))
		{
			ps=con.prepareStatement("update authors set fullname=? where email=?");
			ps.setString(1, s1);
			ps.setString(2, e);
			int rs=ps.executeUpdate();
			return rs;
		}

		else if(s.equals("password"))
		{
			ps=con.prepareStatement("update authors set password=? where email=?");
			ps.setString(1, s1);
			ps.setString(2, e);
			int rs=ps.executeUpdate();
			return rs;
		}
		else if(s.equals("mobile"))
		{
			ps=con.prepareStatement("update authors set mobile=? where email=?");
			ps.setString(1, s1);
			ps.setString(2, e);
			int rs=ps.executeUpdate();
			return rs;
		}
		else
		{
			return 0;
		}
		
	}

}
