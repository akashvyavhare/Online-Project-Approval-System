<%@page import="com.project_approval.utility.ProjectApprovalUitility"%>
<%@page import="com.project_approval.dao.UtilityDao"%>
<%@page import="com.project_approval.service.TeacherService"%>
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
	Teacher teacher = (Teacher) session.getAttribute("teacherObj");
	if (teacher == null) {
		response.sendRedirect("../teacherLogin.jsp");
		return;
	}


	String status = (String) session.getAttribute("status");
	if (status != null) {
		out.print(status);
		session.removeAttribute("status");
	}
	
	ProjectApprovalUitility projectApprovalUitility= new ProjectApprovalUitility();
	%>
	<h1>Teacher Dashboard</h1>

	<%="Teacher Name = " + teacher.getTeacher_name()%>

	<a style="float: right" href="../teacherLogout">Logout</a>

	<%
	List<Project> project = new ArrayList<Project>();
	project = new TeacherService().getAllAssignProject(teacher.getId());
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
			<%
			for (Project p : project) {
			%>

			<tr>
				<form action="../approveReject" method="post">
				<td><%=p.getProject_name()%></td>
				<td><a
					href="../downloadFile?project_file_name=<%=p.getFile_Name()%>">Download</a></td>
				<td><%=p.getAcadmic_year()%></td>
				<td><%=new UtilityDao().getGuideDetailsById(p.getProject_guide())%></td>
				<td><select name="status">
						<option value="approved">Approved</option>
						<option value="rejected">rejected</option>
						<option value="changesSuggested">Changes suggested</option>

				</select></td>
				<td><input type="text" name="comment"
					placeholder="Enter remarks"></td>
				<td><%=p.getProject_Technology()%></td>
				<td><%=projectApprovalUitility.getProjectGroupById(p.getProject_Group())==null ? "No Group":projectApprovalUitility.getProjectGroupById(p.getProject_Group()).getGroupCode()
						%></td>
				<input type="hidden" name="project_id"
					value="<%=p.getProject_id()%>">
				<td><button type="submit">Submit</button></td>
				</form>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>

</body>
</html>


