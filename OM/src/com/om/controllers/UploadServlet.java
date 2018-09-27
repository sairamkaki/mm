package com.om.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.om.dbconnection.DatabaseConnection;
import com.oreilly.servlet.MultipartRequest;  
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UploadServlet
 */
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").1append(request.getContextPath());
		response.setContentType("text/html");  
		String username = null;
		String email;
		try
		{
	 	Connection con=DatabaseConnection.getCon();
		PreparedStatement ps=con.prepareStatement("select username from authors where email=?");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			username=rs.getString("username");
		}
		PrintWriter out = response.getWriter();  
		          
		MultipartRequest m=new MultipartRequest(request,"d://images//"+username+".jpg");  
		System.out.print("successfully uploaded");  
		}
		catch(Exception e)
		{
			e.printStackTrace();
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
