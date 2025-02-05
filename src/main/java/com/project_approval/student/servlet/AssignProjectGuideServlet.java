package com.project_approval.student.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project_approval.service.AdminService;


@WebServlet("/assignProjectGuide")
public class AssignProjectGuideServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpsession =req.getSession();
		String tchrId = req.getParameter("teacherid");
		String projectid= req.getParameter("project_id");
		System.out.println(tchrId);
		System.out.println(projectid);
		
		String statusMsg = new AdminService().assignProjectGuide(tchrId, projectid);
		httpsession.setAttribute("statusMsg", statusMsg);
		resp.sendRedirect("Admin/AssignProjectGuide.jsp");
		System.out.println(3);
	}
	

}
