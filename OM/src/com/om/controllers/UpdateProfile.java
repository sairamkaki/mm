package com.om.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.om.dao.ProfileUpdate;

/**
 * Servlet implementation class UpdateProfile
 */
public class UpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String email = null;
		RequestDispatcher rd;
		int rs1=0,rs2=0,rs3=0,rs4=0;
		try {
		HttpSession s=request.getSession();
		email=(String)s.getAttribute("email");
		}
		catch(Exception e)
		{
			rd=request.getRequestDispatcher("Login.html");
			rd.forward(request, response);
		}
		
		String username=request.getParameter("username");
		String fullname=request.getParameter("fullname");
		String password=request.getParameter("password");
		String mobile=request.getParameter("mobile");
		ProfileUpdate pu=new ProfileUpdate();
		try {
		if(!username.isEmpty())
		{
			 rs1=pu.update("username", username, email);
			
		}}
		catch(Exception e) {}
		try {
		if(!fullname.isEmpty())
		{
			 rs2=pu.update("fullname", fullname, email);
			
		}
		}catch(Exception e) {}
		try {
		if(!password.isEmpty())
		{
			 rs3=pu.update("passsword", password, email);	
		}
		}catch(Exception e) {}
		try {
		if(!mobile.isEmpty())
		{
			 rs4=pu.update("mobile", mobile, email);
			
		}
		}catch(Exception e) {}
		if(rs1==1||rs2==1||rs3==1||rs4==1)
		{
			rd=request.getRequestDispatcher("ProfileView.jsp");
			rd.forward(request, response);
					
		}
		}
		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
