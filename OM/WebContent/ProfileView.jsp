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
 <%@ page session = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

ul {
   list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden; 
    background-color: #E8E1E1;
}


li {
    float: left;
    color:black;

}


li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
    color: black;
    
}

li a:hover {
    background-color: #837EC1;
    
}

input {
	font-size: 15px;
	font-family: verdana;
	font-style: bold;
}


table {
    width: 50%;
    padding: 20px 30px;
    margin: 50px 100px 150px 440px;
    box-sizing: border-box;
    border: none;
    background-color: #E8E1E1;
    color: black;
}


</style>

</head>
<body>

<ul>
  <li><a class="active" href="Home1.html">Home</a></li>
  <li><a href="#">Account Details</a></li>
  <li><a href="#about">About</a></li>
</ul>

</head>
<body>
<%! String username=new String();
	String email=new String();
 	Connection con;
	PreparedStatement ps;
	ResultSet rs;
%>
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
ps=con.prepareStatement("select * from authors where email=?");
ps.setString(1,email);
rs=ps.executeQuery();
int i=0;
while(rs.next())
{

%>
<table align="center">
<tr>
<td><h3>Profile Picture</h3></td>
</tr>
<tr>
<td style="height: 50 px; width: 20 px;">
<%
try
{
	
	Blob b=rs.getBlob("profilepic");  
	byte barr[]=b.getBytes(1,(int)b.length());  
	//response.setContentType("image/jpg");             
	FileOutputStream fout=new FileOutputStream("C:\\Users\\Admin\\git\\Magzine\\OM\\"+rs.getString("email")+".jpg");  
	//OutputStream fout = response.getOutputStream();
	fout.write(barr);  
	    
	fout.close();  


%>
<picture>
  <source media="(min-width: 650px)" srcset="<%=rs.getString("email")%>">
  <source media="(min-width: 465px)" srcset="<%=rs.getString("email")%>">
  <img src="<%=rs.getString("email")%>" style="width:auto;">
</picture>
</td>
</tr>
<for
action="UploadServlet" method="post" enctype="multipart/form-data" >  
<tr>
<td>Upload profile picture</td>
<td><input type="file" name="f"></td>
</tr>
<tr>
<td align="center"><input type="submit" value="Upload"></td>
</form>
</tr>
</table>
<h1 align="center">Profile</h1>
<table align="center">
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
catch(Exception e)
{
	e.printStackTrace();
	%>
	<table align="center">
	<form action="UploadServlet" method="post" enctype="multipart/form-data" >  
<tr>
<td>Upload profile picture</td>
<td><input type="file" name="f"></td>
</tr>
<tr>
<td><input type="submit" value="Upload"></td>
</form>
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
}
%>
<table align="center">
<h1 align="center">Update profile</h1>

<%




%>



<tr><td>
<form action="ProfileUpdate.jsp" method="post">
  <input type="checkbox" name="profile" value="fullname"> Full Name
  <input type="checkbox" name="profile" value="username" > User Name
  <input type="checkbox" name="profile" value="password" > Password
  <input type="checkbox" name="profile" value="mobile" >Mobile No<br><br>
  <center><input type="submit" value="Update"></center>
</form>
</td></tr>
</table>
</body>
</html>