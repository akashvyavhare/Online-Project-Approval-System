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
<%@ include file="component/bootstrap-cdn.jsp" %>
</head>

<body>
<%@include file="component/navbar.jsp" %>
	<div id="container">
		<h2>Student Login</h2>
		<form action="#" method="post">
			<div class="field">
				<input type="text" placeholder="username" name="username">
			</div>
			<div class="field">
				<input style="" type="text" placeholder="password" name="password">
			</div>
			<div class="field">
				<button type="submit">Login</button>
			</div>
		</form>
	</div>
</body>

</html>