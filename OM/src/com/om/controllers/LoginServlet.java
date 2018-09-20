package com.om.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		
		
		    String username=request.getParameter("uname");
		    String password=request.getParameter("password");
		    
		    
		    PrintWriter out=response.getWriter();
		    
		    
		    if((username.equals("aparna")&&password.equals("aparna")) ||(username.equals("manasa")&&password.equals("manasa")))
		    {
		    
		    	
		    	RequestDispatcher rd=request.getRequestDispatcher("AuthorHome.jsp");
		    	rd.forward(request, response);
		    }
		    else
		    {
		    	
		    	out.println("<h1> Invalid UserName or Password</h1>");
		    
		    	RequestDispatcher rd=request.getRequestDispatcher("Login.html");
		    }
		
		
		
		
	}

}
