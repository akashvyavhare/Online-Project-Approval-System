package com.project_approval.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project_approval.db.DBconnection;
import com.project_approval.entity.Project;
import com.project_approval.entity.Student;

public class UtilityDao {
	
	Connection connection;
	
	public List<Student> getProjecGroupDetails(String id)
	{
		connection = DBconnection.getDbConnection();
		List<Student> groupMember = new ArrayList<Student>();
		Student student;
		
		String query = "select * from student_dtl where project_group_id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				student = new Student();
				student.setName(rs.getString("student_name"));
				student.setCrn(rs.getString("crn_no"));
				
				groupMember.add(student);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return groupMember;
		
	}
	
	public String getDownloadFileName(String project_id, String Project_group_id)
	{
		return null;
	}
	

}