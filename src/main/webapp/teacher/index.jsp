<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.project_approval.service.AdminService"%>
<%@page import="com.project_approval.entity.Project"%>
<%@page import="com.project_approval.entity.Teacher"%>
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
	Teacher teacher = (Teacher)session.getAttribute("teacherObj");
	if(teacher==null)
	{
		response.sendRedirect("../teacherLogin.jsp");
		return;
	}
%>
    <h1>Teacher Dashboard</h1>
    
    <%= "Teacher Name = " + teacher.getTeacher_name() %>
    
    <a style = "float:right" href="../teacherLogout" >Logout</a>
    
    <%
AdminService adminService =new AdminService();
 List<Project> project = new ArrayList<Project>();
 project = adminService.getAllNewProposeProject();
%>	
<br>
<br>
<hr>
    
    <table>
        <thead>
      
            <tr>
                <th>Project Title</th>
                <th>Project File</th>
                <th>Project Year</th>
                <th>Project Guide</th>
                <th>Project Status</th>
                <th>Project Comment</th>
                <th>Project Tech</th>
                <th>Project Group</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
          <% for (Project p:project){%>
            <tr>
                <td><%= p.getProject_name() %></td>
                <td><a
					href="../downloadFile?project_file_name=<%=p.getFile_Name()%>">Download</a></td>
                <td><%= p.getAcadmic_year() %></td>
                <td><%= p.getProject_guide() %></td>
                <td>
                   <select>
                   	<option>Approved</option>
                   		<option>rejected</option>
                   	<option>Changes suggested</option>
                   	
                   </select>
                </td>
                <td><input type="text" placeholder="Enter remarks"></td>
                <td><%= p.getProject_Technology() %></td>
                <td><%= p.getProject_Group() %></td>
                <td><button class="submit-button">Submit</button></td>
            </tr>
           <% } %>
        </tbody>
    </table>
</body>
</html>
 

