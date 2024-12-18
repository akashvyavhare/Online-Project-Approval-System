package com.project_approval.service;

import com.project_approval.dao.AdminDao;
import com.project_approval.entity.Admin;

public class AdminService {

	public Admin adminLogin(String username, String password) {
		Admin admin = null ;
		AdminDao dao = new AdminDao();
		admin = dao.loginAdmin(username, password);

		return admin;
	}
	

}
