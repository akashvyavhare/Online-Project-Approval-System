<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
		<h3>Create Project Group</h3>
		<div class="form-group">
			<label>Student List:</label><br> <input type="checkbox"
				id="student1" name="students" value="Student 1"> <label
				for="student1"> Student 1</label><br> <input type="checkbox"
				id="student2" name="students" value="Student 2"> <label
				for="student2"> Student 2</label><br> <input type="checkbox"
				id="student3" name="students" value="Student 3"> <label
				for="student3"> Student 3</label>
		</div>

		<div class="form-group">
			<label for="groupName">Group Name:</label> <input type="text"
				id="groupName" name="groupName" placeholder="Enter group name">
		</div>

		<button type="button" onclick="createGroup()">Create Group</button>
	</div>

</body>
</html>