package com.om.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.om.dbconnection.DatabaseConnection;

public class AuthorLoginDAO {
	
	public boolean validateLogin(String email,String password) throws SQLException
	{
		Connection con=DatabaseConnection.getCon();
		PreparedStatement ps=con.prepareStatement("select email,password from authors where email=?");
		ps.setString(1, email);
		ResultSet rs=ps.executeQuery();
		if(rs.getMetaData()==null)
		{
			return false;
		}
		else
		{
			while(rs.next())
			{
			if(rs.getString(1).equals(email)&&rs.getString(2).equals(password))
			{
				return true;
			}
			else
			{
				return false;
			}
			}
			return false;
		}
	}

}
