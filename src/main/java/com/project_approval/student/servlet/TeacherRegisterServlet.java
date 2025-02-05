package com.project_approval.student.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project_approval.entity.Teacher;
import com.project_approval.service.TeacherService;


@WebServlet("/teacher_register")
public class TeacherRegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String teacher_name = req.getParameter("teacher_name");
		String teacher_id = req.getParameter("teacher_id");
		String password = req.getParameter("password");
		String department = req.getParameter("department");
		

		String status = null;
		HttpSession session = req.getSession();

		Teacher teacher = new Teacher();
		teacher.setTeacher_id(teacher_id);
		teacher.setTeacher_name(teacher_name);
		teacher.setPassword(password);
		teacher.setDepartment(department);
		

		TeacherService service = new TeacherService();
		status = service.registerTeacher(teacher);

		session.setAttribute("status", status);

		resp.sendRedirect("teacherRegister.jsp");

	}

}
