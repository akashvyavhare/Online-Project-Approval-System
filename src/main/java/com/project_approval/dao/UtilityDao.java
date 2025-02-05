package com.project_approval.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project_approval.db.DBconnection;
import com.project_approval.entity.Project;
import com.project_approval.entity.ProjectGroup;
import com.project_approval.entity.Student;
import com.project_approval.entity.Teacher;

public class UtilityDao {

	Connection connection;

	public List<Student> getProjecGroupMemberDetails(String id) {
		connection = DBconnection.getDbConnection();
		List<Student> groupMember = new ArrayList<Student>();
		Student student;

		String query = "select * from student_dtl where project_group_id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
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

	public String getDownloadFileName(String project_id, String Project_group_id) {
		return null;
	}

	public String getGuideDetailsById(String id) {

		connection = DBconnection.getDbConnection();
		String teacher = "";
		if (id != null) {
			String query = "select * from teacher_dtl where id =?";
			try {
				PreparedStatement ps = connection.prepareStatement(query);
				ps.setInt(1, Integer.parseInt(id));
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					teacher = rs.getString("teacher_name");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			teacher = "Not Assign";
		}
		return teacher;
	}

	public ProjectGroup getProjectGroupById(int id)
	{
		ProjectGroup projectGroup = null;
		
		connection= DBconnection.getDbConnection();
		String query ="select * from project_group_dtl where id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				projectGroup = new ProjectGroup();
				projectGroup.setGroupId(rs.getInt(1));
				projectGroup.setGroupCode(rs.getString(2));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return projectGroup;
	}

}
