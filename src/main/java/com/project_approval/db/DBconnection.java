package com.project_approval.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {

	private static Connection connection;

	public static Connection getDbConnection() {

		if (connection == null) {

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_approval", "root", "root");
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}

		return connection;
	}
}
