package com.project_approval.student.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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

@WebServlet("/newproject")
@MultipartConfig
public class StudentNewProjectServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException {

		try {

			HttpSession session = req.getSession();
			Student student = (Student) session.getAttribute("studentObj");
			System.out.println("Student" + student);

			String project_name = req.getParameter("projectname");
			String project_desc = req.getParameter("projectdesc");
			String acadmic_year = req.getParameter("acadmicyear");
			String project_tech = req.getParameter("project_tech");
			Part project_file = req.getPart("file");
			String file_Name = project_file.getSubmittedFileName();

			InputStream in = project_file.getInputStream();
			byte[] filedata = new byte[in.available()];
			in.read(filedata);
			in.close();

			Project project = new Project();
			project.setProject_name(project_name);
			project.setProject_desc(project_desc);
			project.setAcadmic_year(acadmic_year);
			project.setProject_Technology(project_tech);
			project.setFile_Name(file_Name);
			project.setFile_data(filedata);
			project.setProject_Group(student.getProject_group_id());

			StudentService service = new StudentService();
			int status = service.proposeNewProject(project);

			switch (status) {
			case (0): {
				session.setAttribute("statusMsg", "Fail to Add New Project");
				break;
			}
			case (1): {
				session.setAttribute("statusMsg", "File Upploaded But Issue In Storing project details");
				break;
			}
			case (2): {
				session.setAttribute("statusMsg", "New Project Added Sucessfully");
				break;
			}
			}

			
			resp.sendRedirect("./student/index.jsp");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		

	}
	

}
