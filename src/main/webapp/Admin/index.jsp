<%@page import="com.project_approval.entity.Admin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	Admin admin = (Admin)session.getAttribute("adminObj");
	if(admin==null)
	{
		response.sendRedirect("../adminLogin.jsp");
		return;
	}
%>
<p>Admin dashboard </p>
<a style = "float:right" href="../adminLogout" >Logout</a>
<br>
<br>
<hr>

<%= "Admin Name = " + admin.getUser_name() %>
</body>
</html>