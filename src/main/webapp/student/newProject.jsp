<%@page import="com.project_approval.entity.Project"%>
<%@page import="com.project_approval.service.StudentService"%>
<%@page import="com.project_approval.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.form {
	text-align: center;
}

.el {
	
}
</style>
</head>
<body>
	<%
	Student student = (Student) session.getAttribute("studentObj");
	if (student == null) {
		response.sendRedirect("../studentLogin.jsp");
		return;
	}
	String project_id = request.getParameter("id");
	%>
	<%="Student Name = " + student.getName()%>
	<a style="float: right" href="../studentLogout">Logout</a>

	<a style="float: right; padding-right: 10px;" href="index.jsp">Dashboard</a>
	<%
	if (project_id == null) {
	%>
	<div style="text-align: center;">
		<h1>Add New Project</h1>
	</div>
	<br>
	<hr>

	<div class="form">

		<form action="../newproject" method="post"
			enctype="multipart/form-data">
			<div class="element">
				<br> <br> <br> <label>Project Name</label> <input
					type="text" name="projectname">
			</div>

			<div class="element el">
				<br> <br> <br> <label>Project Description</label> <input
					type="text" name="projectdesc">
			</div>

			<div class="element">
				<br> <br> <br> <label>Acadmic year</label> <input
					type="text" name="acadmicyear">
			</div>


			<div class="element">
				<br> <br> <br> <label>Project Tech</label> <select
					name="project_tech">
					<option value="ML">ML</option>
					<option value="WEB-Technology">WEB Technology</option>
					<option value="Robotics">Robotics</option>
				</select>
			</div>

			<div class="element">
				<br> <br> <br> <label>Upload File</label> <input
					type="file" name="file">
			</div>

			<br> <br> <br>
			<button type="submit">Propose</button>

		</form>
	</div>

	<%
	} else {

	Project project = new StudentService().getProjectById(project_id);
	out.print(project.getProject_id());
	%>

	<div style="text-align: center;">
		<h1>Edit Project</h1>
	</div>
	<br>
	<hr>

	<div class="form">

		<form action="../updateproject" method="post"
			enctype="multipart/form-data">
			<input type="hidden" name="pid" value="<%=project_id%>">
			<div class="element">
				<br> <br> <br> <label>Project Name</label> <input
					type="text" name="projectname"
					value="<%=project.getProject_name()%>">
			</div>

			<div class="element el">
				<br> <br> <br> <label>Project Description</label> <input
					type="text" name="projectdesc"
					value="<%=project.getProject_desc()%>">
			</div>

			<div class="element">
				<br> <br> <br> <label>Acadmic year</label> <input
					type="text" name="acadmicyear"
					value="<%=project.getAcadmic_year()%>">
			</div>


			<div class="element">
				<br> <br> <br> <label>Project Tech</label> <select
					name="project_tech">
					<option value="ML">ML</option>
					<option value="WEB-Technology">WEB Technology</option>
					<option value="Robotics">Robotics</option>
				</select>
			</div>

			<div class="element">
				<br> <br> <br> <label>Upload File</label> <input
					type="file" name="file">
			</div>
			<br> <br> <br>
			<button type="submit">Update</button>

		</form>
	</div>
	<%
	}
	%>

</body>
</html>