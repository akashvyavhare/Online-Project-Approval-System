package com.project_approval.student.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project_approval.service.TeacherService;

@WebServlet("/approveReject")
public class TeacherProjectApproveRejectServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession httpSession = req.getSession();
		String project_status = req.getParameter("status");
		String project_id =req.getParameter("project_id");
		String comment =req.getParameter("comment");
		
		String msg = new TeacherService().setProjectApproveReject(project_id, project_status, comment);
		httpSession.setAttribute("status", msg);
		req.getRequestDispatcher("/teacher/index.jsp").forward(req, resp);


	}

}
