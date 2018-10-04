<%@page import="com.om.dbconnection.DatabaseConnection" %>
<%@page import="java.util.*"  %>
<%@page import="java.io.*" %>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.Blob" %>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="javax.servlet.RequestDispatcher" %>
<%@page import="javax.servlet.ServletException" %>
<%@page import="javax.servlet.RequestDispatcher" %>
<%@page import="javax.servlet.RequestDispatcher" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<h1>Update your profile details</h1>
<table><tr><td><form action="UpdateProfile" method="post">
<%
try{
HttpSession s1=request.getSession();
email=(String)s1.getAttribute("email"); 
}
catch(Exception e)
{
	RequestDispatcher rd=request.getRequestDispatcher("Login.html");
	rd.forward(request,response);
}
con=DatabaseConnection.getCon();
String profile[]=request.getParameterValues("profile");
for(int i=0;i<profile.length;i++)
{
	if(profile[i].equals("username")||profile[i].equals("fullname")||profile[i].equals("password")||profile[i].equals("mobile"))
	{
		%>
		<p><%=profile[i] %><br>
		<input type="text" name="<%=profile[i] %>"/></p></br>
<%
	}
}
%>
<input type="submit" value="update">
</form>
</td></tr></table>
</body>
</html>