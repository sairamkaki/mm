package com.om.controllers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.om.dbconnection.DatabaseConnection;

/**
 * Servlet implementation class UploadServlet
 */
@MultipartConfig(maxFileSize = 16177215)
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	private String dbURL = "jdbc:mysql://localhost:3306/om";
    private String dbUser = "root";
    private String dbPass = "root";
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession();
		String email=(String) session.getAttribute("email");
		
		InputStream inputstream=null;
		
		
		 Part filePart = request.getPart("f");
		 
		 if(filePart!=null)
		 {
			 
			 
			 System.out.println(filePart.getName());
			 System.out.println(filePart.getSize());
			 
			 System.out.println(filePart.getContentType());
			 
			 
			 inputstream=filePart.getInputStream();
			 
//			OutputStream os=new FileOutputStream("images/"+firstName+".jpeg");
//			
//			byte[] image=new byte[inputstream.available()];
//			
//			os.write(image);
//			os.flush();
//			
//			os.close();
		 }
		 
		 
		 Connection con = null; // connection to the database
	        String message = null;  // message will be sent back to client
	         
	        try {
	        
	            // connects to the database
	        	 con=DatabaseConnection.getCon();
	 
	            // constructs SQL statement
	            String sql = "update authors set profilepic=? where email=?";
	            PreparedStatement statement = con.prepareStatement(sql);
	            if (inputstream != null) {
	                // fetches input stream of the upload file for the blob column
	                //statement.setBlob(1, inputstream);
	                statement.setBlob(1, inputstream);
	                statement.setString(2, email);
	                
	            }
	 
	            // sends the statement to the database server
	            int row = statement.executeUpdate();
	            if (row > 0) {
	            
	            	RequestDispatcher rd=request.getRequestDispatcher("ProfileView.jsp");
	            	 rd.forward(request, response);
	            }
	           
	        } catch (SQLException ex) {
	            message = "ERROR: " + ex.getMessage();
	            ex.printStackTrace();
	        } finally {
	            if (con != null) {
	                // closes the database connection
	                try {
	                    con.close();
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                }
	            }
		 
		 
		
		
		
		
		
	}

	        
	        
	        
	        
	        
	        PrintWriter out=response.getWriter();
	        
	        out.println(message);
	        out.close();
	        
	}}
