<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.project_approval.service.AdminService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.project_approval.entity.*"%>
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
	List<Student> student =new ArrayList<Student>();
	student = adminService.getAllNewRegisterStudentList();
		
	%>
<div class="container">
		<h3>Create Project Group</h3>
		<div class="form-group">
			<label>Student List:</label><br> 
			
			<%
			if(!student.isEmpty()){
				
			
			for(Student std: student){
				%>	
				<input type="checkbox"
				id="student1" name="students" value="Student 1"> <label
				for="student1"> <%= std.getName() %></label><br>
			<%
			}
			}
			%>
			
		</div>

		<div class="form-group">
			<label for="groupName">Group Name:</label> <input type="text"
				id="groupName" name="groupName" placeholder="Enter group name">
		</div>

		<button type="button" onclick="createGroup()">Create Group</button>
	</div>

</body>
</html>