package com.project_approval.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project_approval.db.DBconnection;
import com.project_approval.entity.Admin;

public class AdminDao {

	Connection connection;

	

	public Admin loginAdmin(String username, String password) {
		Admin admin = null;

		connection = DBconnection.getDbConnection();

		String query = "Select *  from admin_dtl where user_name = ? and Password = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				admin = new Admin();
				admin.setId(rs.getInt("id"));
				admin.setCollege_id(rs.getInt("college_id"));
				admin.setUser_name(rs.getString("user_name"));
				admin.setPassword(rs.getString("Password"));
				
				
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		System.out.println(admin);

		return admin;
	
	}
	
}