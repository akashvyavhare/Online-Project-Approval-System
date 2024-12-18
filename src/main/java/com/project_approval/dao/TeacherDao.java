package com.project_approval.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.PreparableStatement;
import com.project_approval.db.DBconnection;
import com.project_approval.entity.Student;
import com.project_approval.entity.Teacher;


public class TeacherDao {

	Connection connection;
	
	public int teacherRegister(Teacher teacher)
	{
		connection = DBconnection.getDbConnection();
		int insertStatus = 0 ;
		
		String query = "Insert into teacher_dtl (teacher_name , teacher_id   , password, department) values (?,?,?,?)";
		
		try {
			PreparedStatement ts  = connection.prepareStatement(query);
			ts.setString(1, teacher.getTeacher_name());
			ts.setString(2, teacher.getTeacher_id());
			ts.setString(3, teacher.getPassword());
			ts.setString(4, teacher.getDepartment());
			
			insertStatus =ts. executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return insertStatus;
	}

	public Teacher loginTeacher(String username, String password) {
		Teacher teacher = null;

		connection = DBconnection.getDbConnection();

		String query = "Select *  from teacher_dtl where teacher_id = ? and Password = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				teacher = new Teacher();
				teacher.setId(rs.getInt("id"));
				teacher.setTeacher_name(rs.getString("teacher_name"));
				teacher.setTeacher_id(rs.getString("teacher_id"));
				teacher.setPassword(rs.getString("Password"));
				teacher.setDepartment(rs.getString("department"));
				
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		System.out.println(teacher);

		return teacher;
	}

}
