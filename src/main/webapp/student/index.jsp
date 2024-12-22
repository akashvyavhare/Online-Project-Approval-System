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
	Student student = (Student) session.getAttribute("studentObj");
	if (student == null) {
		response.sendRedirect("../studentLogin.jsp");
		return;
	}
	String msg = (String) session.getAttribute("newProjectMessage");
	if (msg != null) {
		out.print(msg);
		session.removeAttribute("newProjectMessage");
	}
	%>
	<p>Student dashboard</p>
	<a style="float: right" href="../studentLogout">Logout</a>
	<a style="float: right; margin-right: 10px;" href="./newProject.jsp">Add New Project</a>
	<br>
	<br>
	<hr>

	<%="Student Name = " + student.getName()%>
</body>
</html>