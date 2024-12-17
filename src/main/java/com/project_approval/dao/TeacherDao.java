package com.project_approval.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.mysql.cj.xdevapi.PreparableStatement;
import com.project_approval.db.DBconnection;
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
	
}
