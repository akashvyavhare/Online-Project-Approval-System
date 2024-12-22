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
            <tr>
                <td>Schilder</td>
                <td><button class="download-button">Download</button></td>
                <td>2008</td>
                <td>Zakir Afridi</td>
                <td>
                    <select>
                        <option>Start Working ASAP</option>
                        <option>Leave Remarks</option>
                    </select>
                </td>
                <td><input type="text" placeholder="Enter remarks"></td>
                <td>UX/UI</td>
                <td>2</td>
                <td><button class="submit-button">Submit</button></td>
            </tr>
           
        </tbody>
    </table>
</body>
</html>
 


</body>
</html>