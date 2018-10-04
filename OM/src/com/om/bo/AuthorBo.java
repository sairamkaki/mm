package com.om.bo; 

import java.sql.SQLException;

import com.om.dao.AuthorDAO;
import com.om.domain.Author;

public class AuthorBo {
	
	
	


public boolean createAuthor(Author a) throws SQLException
	{
	
		
		
		
		
		
		return AuthorDAO.registerAuthor(a);
	}
	
	
}
