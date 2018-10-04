package com.om.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.om.dbconnection.DatabaseConnection;
import com.om.domain.Author;

public class AuthorDAO {
	
	
	
	
	public static  boolean registerAuthor(Author a) throws SQLException
	{
		Connection con=DatabaseConnection.getCon();
		PreparedStatement ps=con.prepareStatement("insert into authors(fullname,username,password,email,mobile) values(?,?,?,?,?)");
		ps.setString(1, a.getUsername());
		ps.setString(2, a.getFullname());
		ps.setString(3, a.getPassword());
		ps.setString(4, a.getEmail());
		ps.setString(5, a.getMobile());
		
		int res=ps.executeUpdate();
		if(res>0)
		{
			return true;
		}
		else
		{
		return false;
		}
	}

}
