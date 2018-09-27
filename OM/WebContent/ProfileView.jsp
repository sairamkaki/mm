<%@page import="com.om.dbconnection.DatabaseConnection" %>
<%@page import="java.util.*"  %>
<%@page import="java.io.*" %>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="javax.servlet.RequestDispatcher" %>
<%@page import="javax.servlet.ServletException" %>
<%@page import="javax.servlet.RequestDispatcher" %>
<%@page import="javax.servlet.RequestDispatcher" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page session = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%! String username=new String();
	String email=new String();
 	Connection con;
	PreparedStatement ps;
	ResultSet rs;


%>
<h1>Account Details</h1>
<% 
HttpSession s1=request.getSession();
email=(String)s1.getAttribute("email"); 
con=DatabaseConnection.getCon();
ps=con.prepareStatement("select * from authors where email=?");
ps.setString(1,email);
rs=ps.executeQuery();

while(rs.next())
{
	
%>
<table>
<tr>
<td>Profile Picture</td>
</tr>
<tr>
<td><img src="D://images//<%=username %>.jpg"/></td>
</tr>
<tr>
<form action=UploadServlet" method="post" enctype="multipart/form-data">  
<td>Upload profile picture</td>
<td><input type="file" name="f"></td>
</tr>
<tr>
<td><input type="submit" value="Upload"></td>
</tr>
<tr>
<td>Full Name:</td>
<td><%=rs.getString("fullname") %>
</tr>
<tr>
<td>User Name:</td>
<td><%=rs.getString("username") %>
</tr>
<tr>
<td>Email:</td>
<td><%=rs.getString("email") %>
</tr>
<tr>
<td>Mobile:</td>
<td><%=rs.getString("mobile") %>
</tr>
</table>
<%
}
%>


</body>
</html>