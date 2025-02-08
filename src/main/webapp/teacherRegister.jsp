<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.lang.*"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style/navbar.css">

<style>
body {
	background-color: rgb(189, 189, 194);
	justify-items: center;
}

#container {
	background-color: #c3faab;
	height: 50%;
	width: 30%;
	text-align: center;
	border-radius: 20px;
	margin: 10%;
	padding: 1%;
}

.field {
	margin: 5px 5px;
	padding: .5%;
}
</style>
<%@ include file="component/bootstrap-cdn.jsp"%>
</head>

<body>
	<%@include file="component/navbar.jsp"%>
	<div id="container">
		<h2>Teacher Registration</h2>
		<% 
		String status=(String)session.getAttribute("status");
		if(status != null)
		{
			out.print(status);
			session.removeAttribute("status");
		}
		%>
		<form action="teacher_register" method="post">
			<div class="field">
				<input type="text" placeholder="teacher_name" name="teacher_name"
					pattern="[A-Za-z\s]{3,50}"
					title="Only letters allowed. Min: 3, Max: 50 characters." required>
			</div>
			<div class="field">
				<input style="" type="text" placeholder="teacher_id"
					name="teacher_id" pattern="T[A-Z0-9]{9}"
					title="Must start with 'T' followed by exactly 9 digits (e.g., T12345)."
					required>
			</div>
			<div class="field">
				<input type="text" placeholder="password" name="password"
					pattern="(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}"
					title="Password must be at least 8 characters long and include 1 uppercase letter, 1 lowercase letter, 1 number, and 1 special character. No spaces allowed."
					required>
			</div>
			<div class="field">
				<input type="text" placeholder="department" name="department"
					pattern="[A-Za-z\s]{3,}"
					title="Only letters allowed. Min: 3 characters." required>
			</div>


			<div class="field">
				<button type="submit">Register</button>
			</div>
		</form>
	</div>
</body>

</html>