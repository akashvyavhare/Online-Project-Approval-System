package com.project_approval.student.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.project_approval.entity.Project;
import com.project_approval.entity.Student;
import com.project_approval.service.StudentService;
import com.project_approval.utility.ProjectApprovalUitility;

@WebServlet("/updateproject")
@MultipartConfig
public class StudentEditProject extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			HttpSession session = req.getSession();

			String project_name = req.getParameter("projectname");
			String project_desc = req.getParameter("projectdesc");
			String acadmic_year = req.getParameter("acadmicyear");
			String project_tech = req.getParameter("project_tech");
			int project_id = Integer.parseInt(req.getParameter("pid"));
			Part project_file = req.getPart("file");
			String file_Name = project_file.getSubmittedFileName();

			byte[] filedata = ProjectApprovalUitility.getFileStream(project_file);

			Project project = new Project();
			project.setProject_name(project_name);
			project.setProject_desc(project_desc);
			project.setAcadmic_year(acadmic_year);
			project.setFile_Name(file_Name);
			project.setFile_data(filedata);
			project.setProject_id(project_id);
			project.setProject_Technology(project_tech);

			StudentService service = new StudentService();
			String statusMsg = service.updateProjectDetails(project);
			
			session.setAttribute("statusMsg", statusMsg);
			
			resp.sendRedirect("./student/index.jsp");

		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
			e.printStackTrace();
		}
		
		

	}
	
}
