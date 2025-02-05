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
 <h3><p>Project Group Section</p></h3>
 </body>
<body>
  

<div>
	 <a style="float: right" href="index.jsp">Back to Admin Desktop</a>
</div><br><br>
<hr>

<%
	Admin admin = (Admin) session.getAttribute("adminObj");
	String ststusMsg =(String)session.getAttribute("statusMsg");
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
		<%if(ststusMsg!=null)
			{
			out.print(ststusMsg);
			session.removeAttribute("statusMsg");
			}
			%>
		<div class="form-group">
		<form action="../createProjectGroup" method="post">
		<div class="form-group">
			<label for="groupName">Group Name:</label> <input type="text"
			     name="groupName" placeholder="Enter group name">
		</div>
			<label>Student List:</label><br> 
			
			<%
			if(!student.isEmpty()){
				
			
			for(Student std: student){
				%>	
				<input type="checkbox" name="students_list" value="<%=std.getCrn()%>"> <label
				for="student1"> <%= std.getName() %></label><br>
			<%
			}
			}
			%>
			<button type="submit">Create Group</button>
			</form>
		</div>

	</div>

</body>
</html>