package com.project_approval.student.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project_approval.entity.Student;
import com.project_approval.service.StudentService;

@WebServlet("/studentLogin")
public class StudentLoginServlet  extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		StudentService studentService = new StudentService();
		Student student = studentService.studentLogin(username, password);
		if(student!=null)
		{
			session.setAttribute("studentObj", student);
			resp.sendRedirect("student/index.jsp");
		}
		else {
			session.setAttribute("msg", "Invalid username & password");
			resp.sendRedirect("studentLogin.jsp");
			
		}
		
		
	}
	
}
