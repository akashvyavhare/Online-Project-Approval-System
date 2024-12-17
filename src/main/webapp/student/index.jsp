<%@page import="com.project_approval.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Student student = (Student)session.getAttribute("studentObj");
	if(student==null)
	{
		response.sendRedirect("../studentLogin.jsp");
		return;
	}
%>
<p>Student dashboard </p>
<a style = "float:right" href="../studentLogout" >Logout</a>
<br>
<br>
<hr>

<%= "Student Name = " + student.getName() %>
</body>
</html>