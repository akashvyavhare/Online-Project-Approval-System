package com.project_approval.student.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project_approval.dao.AdminDao;
import com.project_approval.dao.StudentDao;
import com.project_approval.service.AdminService;

@WebServlet("/createProjectGroup")
public class AdminCreateProjectGroupServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession httpSession = req.getSession();
		String studentList[] =req.getParameterValues("students_list");
		String groupName = req.getParameter("groupName");
		
		String statusMsg=new AdminService().createProjectGroup(studentList, groupName);
		httpSession.setAttribute("statusMsg", statusMsg);
		resp.sendRedirect("Admin/CreateProjectGroup.jsp");
		
	}
	
}
