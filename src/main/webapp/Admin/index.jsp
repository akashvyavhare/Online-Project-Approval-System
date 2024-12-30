
<%@page import="com.project_approval.entity.Project"%>
<%@page import="com.project_approval.entity.Student"%>
<%@page import="com.project_approval.entity.Teacher"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.project_approval.service.AdminService"%>
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
	Admin admin = (Admin) session.getAttribute("adminObj");
	if (admin == null) {
		response.sendRedirect("../adminLogin.jsp");
		return;
	}
	AdminService adminService =new AdminService();
	List<Teacher> teacher =new ArrayList<Teacher>();
	List<Student>  student = new ArrayList<Student>();
	List<Project> project = new ArrayList<Project>();
	teacher = adminService.getAllTeacher();
	student = adminService.getAllNewRegisterStudentList();
	project = adminService.getAllNewProposeProject();
	%>
	<p>Admin dashboard</p>
	<%="Admin Name = " + admin.getUser_name()%>
	<div class="nav">

		<a style="float: " href="ViewStatus.jsp">ViewStatus</a> 
		<a style="float: " href="CreateProjectGroup.jsp">CreateProjectGroup</a> 
		<a style="float: " href="AssignProjectGuide.jsp">AssignProjectGuide</a>
		 <select name = "teacherList"  id= "teacher list">Teacher List
		 <option>Maral</option>
		 </select>
		  <select name = "StudentList"  id= "student list">Student List
		 <option> Shendge</option>
		 </select>
		<a style="float: right" href="">Logout</a>
	</div>

	<br>
	<br>
	<hr>
</head>
<body>
	<br>


	<table>
		<thead>
			<tr>
				<th>Project Title</th>
				<th>Project File</th>
				<th>Project Year</th>
				<th>Project Guide</th>
				<th>Project Status</th>

				<th>Project Tech</th>
				<th>Project Group</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<% for (Project p:project){%>
			<tr>
				<td><%= p.getProject_name() %></td>
				<td><%= p.getFile_Name() %></td>
				<td><%= p.getAcadmic_year() %></td>
				<td><%= p.getProject_guide() %></td>
				<td><%= p.getProject_status() %></td>

				<td><%= p.getProject_Technology() %></td>
				<td><%= p.getProject_Group() %></td>
				<td><a href="delete_project">DeleteProject</a></td>
			</tr>

			<% } %>

		</tbody>
	</table>
</body>
</html>


</body>
</html>