<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	height: 30%;
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
		<h2>Student Login</h2>
		<%
		String msg = (String) session.getAttribute("msg");
		if (msg != null) {
			out.print(msg);
			session.removeAttribute("msg");
		}
		%>
		<form action="studentLogin" method="post">
			<div class="field">
				<input type="text" placeholder="CRN No" name="username" required>
			</div>
			<div class="field">
				<input style="" type="text" placeholder="password" name="password"
					pattern="(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}"
					title="Password must be at least 8 characters long and include 1 uppercase letter, 1 lowercase letter, 1 number, and 1 special character. No spaces allowed."
					required>
			</div>
			<div class="field">
				<button type="submit">Login</button>
			</div>
			<p>
				Create account <a href="studentRegister.jsp">click here</a>
			</p>
		</form>
	</div>
</body>

</html>