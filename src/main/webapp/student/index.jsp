<%@page import="com.project_approval.utility.ProjectApprovalUitility"%>
<%@page import="com.project_approval.dao.UtilityDao"%>
<%@page import="com.project_approval.entity.Project"%>
<%@page import="java.util.List"%>
<%@page import="com.project_approval.service.StudentService"%>
<%@page import="com.project_approval.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        table {
            width: 100%;
            border-collapse: collapse;
            font-size: 12px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 4px;
            text-align: left;
            white-space: nowrap;
        }
        th {
            background-color: #f2f2f2;
        }
        input[type="file"] {
            width: 120px;
            font-size: 10px;
        }
        .file-label {
            font-size: 10px;
            color: #333;
            display: block;
            margin-top: 2px;
        }
        button {
            padding: 2px 5px;
            font-size: 10px;
        }
    </style>
</head>
<body>


	<%
	Student student = (Student) session.getAttribute("studentObj");
	if (student == null) {
		response.sendRedirect("../studentLogin.jsp");
		return;
	}
	String msg = (String) session.getAttribute("statusMsg");
	if (msg != null) {
		out.print(msg);
		session.removeAttribute("statusMsg");
	}

	StudentService service = new StudentService();
	List<Project> projectSList = service.getProposedProject(student);
	ProjectApprovalUitility projectApprovalUitility= new ProjectApprovalUitility();
	%>
	<p>Student dashboard</p>
	<a style="float: right" href="../studentLogout">Logout</a>
	<%
	if (student.getProject_group_id()!= null) {
	%>
	<a style="float: right; margin-right: 10px;" href="./newProject.jsp">Add
		New Project</a>
	<a style="float: right; margin-right: 10px;"
		href="index.jsp?project_group_id=<%=student.getProject_group_id()%>">Project
		Group Details</a>
	<%
	}
	%>

	<br>

	<%="Student Name = " + student.getName()%>
	<br>
	<hr>
	<br>
	<%
	if (!projectSList.isEmpty()) {
	%>

	<p>Proposed projects</p>

	<table>
		<thead>
			<tr>
				<th>Project Title</th>
				<th>Project Description</th>
				<th>Project Tech</th>
				<th>Project Acadmic Year</th>
				<th>Project Guide</th>
				<th>Project Status</th>

				<th>Project Group</th>
				<th>Project File</th>
				<th>Action</th>
			</tr>
		</thead>

		<tbody>

			<%
			for (Project project : projectSList) {
			%>
			<tr>
				<td><%=project.getProject_name()%></td>
				<td><%=project.getProject_desc()%></td>
				<td><%=project.getProject_Technology()%></td>
				<td><%=project.getAcadmic_year()%></td>
				<td><%=new UtilityDao().getGuideDetailsById(project.getProject_guide())%></td>
				<td><%=project.getProject_status()%></td>
				<td><%= projectApprovalUitility.getProjectGroupById(project.getProject_Group())==null ? "No Group":projectApprovalUitility.getProjectGroupById(project.getProject_Group()).getGroupCode()%></td>
				<td><%=project.getFile_Name()%></td>
				<td><a
					href="../downloadFile?project_id=<%=project.getProject_id()%>&project_group_id=<%=project.getProject_Group()%>&project_file_name=<%=project.getFile_Name()%> ">Download</a>
				</td>
				<td><a href="newProject.jsp?id=<%=project.getProject_id()%>">Edit</a>
				</td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<%
	}
	%>

	<hr>

	<p># Phase 2</p>

	<table>
		<thead>
			<tr>
				<th>Project Title</th>
				<th>Project Description</th>
				<th>Project Tech</th>
				<th>Project Acadmic Year</th>
				<th>Project Guide</th>
				<th>Project Status</th>

				<th>Project Group</th>

				<th>Project Report</th>
				<th>Action</th>

				<th>Project PPT</th>
				<th>Action</th>

				<th>Research Paper</th>
				<th>Action</th>
			</tr>
		</thead>

		<tbody>

			<%
			for (Project project : projectSList) {
			%>
			<tr>
				<td><%=project.getProject_name()%></td>
				<td><%=project.getProject_desc()%></td>
				<td><%=project.getProject_Technology()%></td>
				<td><%=project.getAcadmic_year()%></td>
				<td><%=new UtilityDao().getGuideDetailsById(project.getProject_guide())%></td>
				<td><%=project.getProject_status()%></td>
				<td><%=project.getProject_Group()%></td>
				<td><%=project.getFile_Name()%></td>
				<td><a
					href="../downloadFile?project_id=<%=project.getProject_id()%>&project_group_id=<%=project.getProject_Group()%>&project_file_name=<%=project.getFile_Name()%> ">Download</a>
				</td>
				<td><%=project.getFile_Name()%></td>
				<td><a
					href="../downloadFile?project_id=<%=project.getProject_id()%>&project_group_id=<%=project.getProject_Group()%>&project_file_name=<%=project.getFile_Name()%> ">Download</a>
				</td>
				<td><%=project.getFile_Name()%></td>
				<td><a
					href="../downloadFile?project_id=<%=project.getProject_id()%>&project_group_id=<%=project.getProject_Group()%>&project_file_name=<%=project.getFile_Name()%> ">Download</a>
				</td>
				<td><a href="newProject.jsp?id=<%=project.getProject_id()%>">Edit</a>
				</td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>

	<hr>

	<p>#Upload File</p>


	<table>
		<thead>
			<tr>
				<th>Project Title</th>
				<th>Project Description</th>
				<th>Project Tech</th>
				<th>Project Acadmic Year</th>
				<th>Project Guide</th>
				<th>Project Status</th>

				<th>Project Group</th>
				<th>Project Report</th>
				<th>Upload File</th>

				<th>Project PPT</th>
				<th>Upload File</th>

				<th>Research Paper</th>
				<th>Upload File</th>
			</tr>
		</thead>

		<tbody>

			<%
			for (Project project : projectSList) {
			%>
			<tr>
				<td><%=project.getProject_name()%></td>
				<td><%=project.getProject_desc()%></td>
				<td><%=project.getProject_Technology()%></td>
				<td><%=project.getAcadmic_year()%></td>
				<td><%=new UtilityDao().getGuideDetailsById(project.getProject_guide())%></td>
				<td><%=project.getProject_status()%></td>
				<td><%=project.getProject_Group()%></td>
				<td><%=project.getFile_Name()%></td>
				<td><input type="file" name="file"></td>
				<td><%=project.getFile_Name()%></td>
				<td><input type="file" name="file"></td>
				<td><%=project.getFile_Name()%></td>
				<td><input type="file" name="file" ></td>
				<td><button type="submit">Submit</button></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>

	<hr>


	<p># Phase 3</p>

	<table>
		<thead>
			<tr>
				<th>Project Title</th>
				<th>Project Description</th>
				<th>Project Tech</th>
				<th>Project Acadmic Year</th>
				<th>Project Guide</th>
				<th>Project Status</th>
				<!-- <th>Project Comment</th> -->
				<th>Project Group</th>
				<th>Project Report</th>
				<th>Action</th>

				<th>Project PPT</th>
				<th>Action</th>

				<th>Research Paper</th>
				<th>Action</th>
			</tr>
		</thead>

		<tbody>

			<%
			for (Project project : projectSList) {
			%>
			<tr>
				<td><%=project.getProject_name()%></td>
				<td><%=project.getProject_desc()%></td>
				<td><%=project.getProject_Technology()%></td>
				<td><%=project.getAcadmic_year()%></td>
				<td><%=new UtilityDao().getGuideDetailsById(project.getProject_guide())%></td>
				<td><%=project.getProject_status()%></td>
				<td><%=project.getProject_Group()%></td>
				<td><%=project.getFile_Name()%></td>
				<td><a
					href="../downloadFile?project_id=<%=project.getProject_id()%>&project_group_id=<%=project.getProject_Group()%>&project_file_name=<%=project.getFile_Name()%> ">Download</a>
				</td>
				<td><%=project.getFile_Name()%></td>
				<td><a
					href="../downloadFile?project_id=<%=project.getProject_id()%>&project_group_id=<%=project.getProject_Group()%>&project_file_name=<%=project.getFile_Name()%> ">Download</a>
				</td>
				<td><%=project.getFile_Name()%></td>
				<td><a
					href="../downloadFile?project_id=<%=project.getProject_id()%>&project_group_id=<%=project.getProject_Group()%>&project_file_name=<%=project.getFile_Name()%> ">Download</a>
				</td>
				<td><button type="submit">Update</button></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>


	<%
	String id = request.getParameter("project_group_id");
	if (id != null) {
		UtilityDao dao = new UtilityDao();
		List<Student> gruoupMember = dao.getProjecGroupMemberDetails(id);
	%>
	<h4>Project Group Details</h4>

	<h4>Group:- <%=projectApprovalUitility.getProjectGroupById(id)==null ? "No Group":projectApprovalUitility.getProjectGroupById(id).getGroupCode() %></h4>

	<table>
		<thead>
			<tr>
				<th>CRN</th>
				<th>Name</th>
			</tr>
		</thead>

		<tbody>
			<%
			for (Student member : gruoupMember) {
			%>
			<tr>
				<td><%=member.getCrn()%></td>
				<td><%=member.getName()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<a href="index.jsp">Ok</a>
	<%
	}
	%>

</body>
</html>