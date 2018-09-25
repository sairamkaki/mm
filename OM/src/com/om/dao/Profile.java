package com.om.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.om.dbconnection.DatabaseConnection;

public class Profile {

	public String[] profileView(String email) throws SQLException
	{
		Connection con=DatabaseConnection.getCon();
		PreparedStatement ps=con.prepareStatement("select * from Authors where email=?");
		ps.setString(1, email);
		ResultSet rs=ps.executeQuery();
		String s1[]=new String[4];
		while(rs.next())
		{
			int i=0;
			s1[i]=rs.getString("username");
			System.out.println(s1[i]);
			i++;
			s1[i]=rs.getString("fullname");
			System.out.println(s1[i]);
			i++;
			s1[i]=rs.getString("email");
			System.out.println(s1[i]);
			i++;
			s1[i]=rs.getString("mobile");
			System.out.println(s1[i]);
		}
			
		return s1;
		
	}
}
