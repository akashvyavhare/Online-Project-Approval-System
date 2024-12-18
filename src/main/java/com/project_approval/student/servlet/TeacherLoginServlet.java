package com.project_approval.student.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project_approval.entity.Student;
import com.project_approval.entity.Teacher;
import com.project_approval.service.StudentService;
import com.project_approval.service.TeacherService;


@WebServlet("/teacherlogin")
public class TeacherLoginServlet  extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//this is httpServlet method for handling post request
		
		HttpSession session = req.getSession();

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		

		TeacherService teacherService = new TeacherService();
		Teacher teacher = teacherService.teacherLogin(username, password);
		if(teacher!=null)
		{
			session.setAttribute("teacherObj", teacher);
			resp.sendRedirect("teacher/index.jsp");
		}
		else {
			session.setAttribute("msg", "Invalid username & password");
			resp.sendRedirect("teacherLogin.jsp");
			
		}
		
	
		
	}

}
