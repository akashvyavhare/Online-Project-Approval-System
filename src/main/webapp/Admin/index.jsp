
<%@page import="com.project_approval.utility.ProjectApprovalUitility"%>
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
	student = adminService.getAllStudentList();
	project = adminService.getAllNewProposeProject();
	ProjectApprovalUitility projectApprovalUitility= new ProjectApprovalUitility();
	%>
	<p>Admin dashboard</p>
	<%="Admin Name = " + admin.getUser_name()%>
	<div class="nav">

		<a style="float:" href="ViewStatus.jsp">ViewStatus</a> <a
			style="float:" href="CreateProjectGroup.jsp">CreateProjectGroup</a> <a
			style="float:" href="AssignProjectGuide.jsp">AssignProjectGuide</a>
			
			 <select name="teacherList" id="teacher list">
			<option value="Teacher List" >Teacher List:</option>
			
				<%
			if(!teacher.isEmpty()){
				
			
			for(Teacher tchr: teacher){ %>
			
			<option value="<%=  tchr.getTeacher_name()%>">
					<%=  tchr.getTeacher_name()%>
					</option> 
			<%}
			}
			%>
			</option>

		</select>
		
		
		 <select name="StudentList" id="student list">
			<option value="Student List" >Student List:</option>
			<%if(!student.isEmpty()){
				for(Student std: student){%>
				<option value="<%=  std.getName() %>">
				<%=  std.getName() %>
				 </option>
		<% 	}
			}
			%>
			</option>
           </select>
		
		 <a style="float: right" href="../adminLogout">Logout</a>
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
			<form action="index" method="post">
			<tr>
				<td><%= p.getProject_name() %></td>
				
				<td><a
					href="../downloadFile?project_file_name=<%=p.getFile_Name()%>">Download</a>
				</td>
				<td><%= p.getAcadmic_year() %></td>
				<td><%= p.getProject_guide() %></td>
				<td><%= p.getProject_status() %></td>
				<td><%= p.getProject_Technology() %></td>
				<td><%= projectApprovalUitility.getProjectGroupById(p.getProject_Group())==null ? "No Group":projectApprovalUitility.getProjectGroupById(p.getProject_Group()).getGroupCode() %></td>
				<td><a href="delete_project">DeleteProject</a></td>
			</tr>
		</form>
			<%
			} 
			%>

		</tbody>
	</table>
</body>
</html>


