<%@page import="com.project_approval.dao.UtilityDao"%>
<%@page import="com.project_approval.entity.Project"%>
<%@page import="java.util.List"%>
<%@page import="com.project_approval.service.StudentService"%>
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

	StudentService service = new StudentService();
	List<Project> projectSList = service.getProposedProject(student);
	%>
	<p>Student dashboard</p>
	<a style="float: right" href="../studentLogout">Logout</a>
	<%
	if (student.getProject_group_id()!= null) {
	%>
	<a style="float: right; margin-right: 10px;" href="./newProject.jsp">Add
		New Project</a>
	<a style="float: right; margin-right: 10px;"
		href="index.jsp?project_group_id=<%=student.getProject_group_id()%>">Project
		Group Details</a>
	<%
	}
	%>

	<br>

	<%="Student Name = " + student.getName()%>
	<br>
	<hr>
	<br>
	<%
	if (!projectSList.isEmpty()) {
	%>

	<p>Proposed projects</p>

	<table>
		<thead>
			<tr>
				<th>Project Title</th>
				<th>Project Description</th>
				<th>Project Tech</th>
				<th>Project Acadmic Year</th>
				<th>Project Guide</th>
				<th>Project Status</th>
				<!-- <th>Project Comment</th> -->
				<th>Project Group</th>
				<th>Project File</th>
				<th>Action</th>
			</tr>
		</thead>

		<tbody>

			<%
			for (Project project : projectSList) {
			%>
			<tr>
				<td><%=project.getProject_name()%></td>
				<td><%=project.getProject_desc()%></td>
				<td><%=project.getProject_Technology()%></td>
				<td><%=project.getAcadmic_year()%></td>
				<td><%=project.getProject_guide()%></td>
				<td><%=project.getProject_status()%></td>
				<td><%=project.getProject_Group()%></td>
				<td><%=project.getFile_Name()%></td>
				<td><a
					href="../downloadFile?project_id=<%=project.getProject_id()%>&project_group_id=<%=project.getProject_Group()%>&project_file_name=<%=project.getFile_Name()%>">Download</a>
				</td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<%
	}
	%>

	<%
	String id = request.getParameter("project_group_id");
	if (id != null) {
		UtilityDao dao = new UtilityDao();
		List<Student> gruoupMember = dao.getProjecGroupDetails(id);
	%>
	<h4>Project Group Details</h4>
	<table>
		<thead>
			<tr>
				<th>CRN NO</th>
				<th>Name</th>
			</tr>
		</thead>

		<tbody>
			<%
			for (Student member : gruoupMember) {
			%>
			<tr>
				<td><%=member.getCrn()%></td>
				<td><%=member.getName()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<a href="index.jsp">Ok</a>
	<%
	}
	%>

</body>
</html>