package com.om.controllers;


import java.io.IOException;
import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.om.bo.AuthorBo;
import com.om.domain.Author;
import com.om.mail.EmailSender;

/**
 * Servlet implementation class AuthorRegister
 */
public class AuthorRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		// read data
		
		String username,fullname,password,email,mobile;
		
		
		username=request.getParameter("uname");
		
		fullname=request.getParameter("fname");
		password=request.getParameter("password");
		email=request.getParameter("email");
		mobile=request.getParameter("mobile");
		Author author=new Author(username, fullname, password, email, mobile);
		
		
		AuthorBo authorbo=new AuthorBo();
		boolean validate;
		try {
			validate=authorbo.createAuthor(author);

			String message="Succcess Dude     "+username.toUpperCase();
			
			String failuremessage="Ooops..............Dsude,    Check Details";

		
		if(validate==true)
		{
		
			try {
				EmailSender.sendMail(email, "Dear "+fullname+",<br> Your registration is successfully accepted <br> Please wait for some time for Activation");
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			RequestDispatcher rd=request.getRequestDispatcher("Home1.html");
			rd.forward(request, response);
			
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("Home.html");
			rd.forward(request, response);
			
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		
		
		
		
		
		
		
		
		
		
	}

}
