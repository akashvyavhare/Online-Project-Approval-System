<%@page import="com.project_approval.entity.Project"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.project_approval.service.AdminService"%>
<%@page import="com.project_approval.entity.Teacher"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 <h3><p>Assign Project Guide</p></h3>
 
 </body>
 <body>
<div>
	 <a style="float: right" href="index.jsp">Back to Admin Desktop</a>
</div><br><br>

<hr>
<%
AdminService adminService =new AdminService();
List<Project> project = new ArrayList<Project>();
List<Teacher> teacher =new ArrayList<Teacher>();
teacher = adminService.getAllTeacher();
project = adminService.getAllNewProposeProject();  %>
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
                 <th>Guide Name</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
        <% for (Project p:project){%>
            <tr>
                <td><%= p.getProject_name() %></td>
                
                <td><%= p.getAcadmic_year() %></td>
                <td><%= p.getProject_guide() %></td>
                <td><%= p.getProject_status() %></td>
                <td><input type="text" placeholder="Enter remarks"></td>
                <td><%= p.getProject_Technology() %></td>
                <td>2</td>
                <td><a
					href="../downloadFile?project_file_name=<%=p.getFile_Name()%>">Download</a></td>
                <td>
                     <select name="teacherList" id="teacher list">
			<option value="Teacher List" >Teacher List:</option>
			
				<%
			if(!teacher.isEmpty()){
				
			
			for(Teacher tchr: teacher){ %>
			
			<option value="<%=  tchr.getTeacher_name()%>">
					<%=  tchr.getTeacher_name()%>
					</option> 
			<%}
			}
			%>
			</option>

		</select>
                </td>
                
                <td><button class="submit-button">Assign</button></td>
            </tr>
            <% } %>
        </tbody>
    </table>

</body>
</html>