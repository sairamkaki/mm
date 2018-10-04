package com.om.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.om.dao.AuthorLoginDAO;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		    String email=request.getParameter("email");
		    String password=request.getParameter("password");
		    
		    System.out.println(email);
		    System.out.println(password);
		    PrintWriter out=response.getWriter();
		    HttpSession se =request.getSession();
		    AuthorLoginDAO a=new AuthorLoginDAO();
		    try {
				boolean b=a.validateLogin(email, password);
				if(b==true)
				{
					se.setAttribute("email", email);
					se.setAttribute("password", password);
					out.println("<h1>login successful</h1>");
					RequestDispatcher rd=request.getRequestDispatcher("Home1.html");
					rd.include(request, response);
				}
				else
				{
					out.println("<h1>username or password is wrong</h1>");
					RequestDispatcher rd=request.getRequestDispatcher("Login.html");
					rd.include(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    
		    
		
		
		
		
	}

}
