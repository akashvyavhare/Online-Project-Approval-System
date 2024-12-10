package com.project_approval.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project_approval.entity.Student;
import com.project_approval.service.StudentService;

@WebServlet("/student_register")
public class StudentRegisterServlet extends HttpServlet{
	
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		 String username = req.getParameter("username");
		 String crn_no = req.getParameter("CRN_NO");
		 String password = req.getParameter("password");
		 String department = req.getParameter("department");
		 String sem_year = req.getParameter("semister_year");
		 
		 Student student = new Student();
		 student.setName(username);
		 student.setCrn(crn_no);
		 student.setPassword(password);
		 student.setDept(department);
		 student.setSem_year(sem_year);
		 
		 StudentService service= new StudentService();
		 service.registerStudent(student);
		 
		 
	}	
	

}
