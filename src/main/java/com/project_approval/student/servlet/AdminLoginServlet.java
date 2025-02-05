package com.project_approval.student.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project_approval.entity.Admin;
import com.project_approval.service.AdminService;

@WebServlet("/adminLogin")
public class AdminLoginServlet  extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		AdminService adminService = new AdminService();
		Admin admin = adminService.adminLogin(username, password);
		if(admin!=null)
		{
			session.setAttribute("adminObj", admin);
			resp.sendRedirect("Admin/index.jsp");
		}
		else {
			session.setAttribute("msg", "Invalid username & password");
			resp.sendRedirect("adminLogin.jsp");
			
		}
		
		
	}
	
}
