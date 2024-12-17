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

@WebServlet("/student_register")
public class StudentRegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("username");
		String crn_no = req.getParameter("CRN_NO");
		String password = req.getParameter("password");
		String department = req.getParameter("department");
		String academic_year = req.getParameter("academic_year");

		String status = null;
		HttpSession session = req.getSession();

		Student student = new Student();
		student.setName(username);
		student.setCrn(crn_no);
		student.setPassword(password);
		student.setDepartment(department);
		student.setAcademic_year(academic_year);

		StudentService service = new StudentService();
		status = service.registerStudent(student);

		session.setAttribute("status", status);

		resp.sendRedirect("studentRegister.jsp");

	}

}
