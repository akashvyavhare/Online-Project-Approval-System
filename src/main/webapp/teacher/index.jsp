<%@page import="com.project_approval.entity.Teacher"%>
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
	Teacher teacher = (Teacher)session.getAttribute("teacherObj");
	if(teacher==null)
	{
		response.sendRedirect("../teacherLogin.jsp");
		return;
	}
%>
<p>Teacher dashboard </p>
<a style = "float:right" href="../teacherLogout" >Logout</a>
<br>
<br>
<hr>

<%= "Teacher Name = " + teacher.getTeacher_name() %>
</body>
</html>