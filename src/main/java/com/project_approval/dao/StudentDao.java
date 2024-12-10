package com.project_approval.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.mysql.cj.xdevapi.PreparableStatement;
import com.project_approval.db.DBconnection;
import com.project_approval.entity.Student;

public class StudentDao {

	Connection connection;
	
	public int studentRegister(Student student)
	{
		connection = DBconnection.getDbConnection();
		
		String query = "Insert into student_dtl (student_name , crn_no , dept , academic_year , password) values (?,?,?,?,?)";
		
		try {
			PreparedStatement ps  = connection.prepareStatement(query);
			ps.setString(1, student.getName());
			ps.setString(2, student.getCrn());
			ps.setString(3, student.getDept());
			ps.setString(4, student.getSem_year());
			ps.setString(5, student.getPassword());
			
			ps.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}
	
}
