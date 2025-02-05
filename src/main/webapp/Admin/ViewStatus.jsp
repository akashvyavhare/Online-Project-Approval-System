<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.project_approval.service.AdminService"%>
<%@page import="com.project_approval.entity.Project"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h3>
		<p>Project Status</p>
	</h3>
</body>

<body>
	<div>
		<a style="float: right" href="index.jsp">Back to Admin Desktop</a>
	</div>
	<br>
	<br>
	<br>
	<hr>
	<% 
AdminService adminService =new AdminService();
List<Project> project = new ArrayList<Project>();
project = adminService.getAllCompleteProject();
%>
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
			<form action="../viewStatus" method="post">
			<tr>
				<td><%= p.getProject_name() %></td>
				<td><a
					href="../downloadFile?project_file_name=<%=p.getFile_Name()%>">Download</a></td>
				<td><%= p.getAcadmic_year() %></td>
				<td><%= p.getProject_guide() %></td>
				<td><%= p.getProject_status() %></td>
				<td><%= p.getProject_Technology() %></td>
				<td><%= p.getProject_Group() %></td>
				<td><button type="submit">RejectProject</button></td>
			</tr>
			</form>
			<% } %>
		</tbody>
	</table>
</body>
</html>