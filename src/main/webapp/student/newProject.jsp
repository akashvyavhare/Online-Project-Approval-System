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
	%>
	<%="Student Name = " + student.getName()%>
	<a style="float: right" href="../studentLogout">Logout</a>

	<a style="float: right; padding-right: 10px;" href="index.jsp">Dashboard</a>
	<div style="text-align: center;">
		<h1>
			Add New Project
			<h1>
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

			<div class="element el">
				<br> <br> <br> <label>Choose Guide</label> <select
					name="guide">
					<option value="a">a</option>
					<option value="b">b</option>
				</select>

			</div>
			<div class="element">
				<br> <br> <br> <label>Project Tech</label> <select>
					<option>ML</option>
					<option>WEB Technology</option>
					<option>Robotics</option>
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

</body>
</html>