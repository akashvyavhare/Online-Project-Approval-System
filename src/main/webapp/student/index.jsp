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
	<a style="float: right; margin-right: 10px;" href="./newProject.jsp">Add
		New Project</a>
	<br>

	<%="Student Name = " + student.getName()%>
	<br>
	<hr>
	<br>
	<p>Proposed projects</p>

	<table>
		<thead>
			<tr>
				<th>Project Title</th>
				<th>Project Year</th>
				<th>Project Guide</th>
				<th>Project Status</th>
				<th>Project Comment</th>
				<th>Project Tech</th>
				<th>Project Group</th>
				<th>Project File</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>

			<%
			if (projectSList != null) {
				for (Project project : projectSList) {
			%>
			<tr>
				<td><%=project.getProject_name()%></td>
				<td><%=project.getAcadmic_year()%></td>
				<td><%=project.getProject_guide()%></td>
				<td><select>
						<option>Start Working ASAP</option>
						<option>Leave Remarks</option>
				</select></td>
				<td><input type="text" placeholder="Enter remarks"></td>
				<td><%=project.getProject_guide()%></td>
				<td><%=project.getProject_guide()%></td>
				<td><button class="download-button">Download</button></td>
				<td><button class="submit-button">Submit</button></td>
			</tr>
			<%
			}
			}
			%>
		</tbody>
	</table>

</body>
</html>