package com.project_approval.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.PreparableStatement;
import com.project_approval.db.DBconnection;
import com.project_approval.entity.Project;
import com.project_approval.entity.Student;
import com.project_approval.entity.Teacher;

public class TeacherDao {

	Connection connection;

	public int teacherRegister(Teacher teacher) {
		connection = DBconnection.getDbConnection();
		int insertStatus = 0;

		String query = "Insert into teacher_dtl (teacher_name , teacher_id   , password, department) values (?,?,?,?)";

		try {
			PreparedStatement ts = connection.prepareStatement(query);
			ts.setString(1, teacher.getTeacher_name());
			ts.setString(2, teacher.getTeacher_id());
			ts.setString(3, teacher.getPassword());
			ts.setString(4, teacher.getDepartment());

			insertStatus = ts.executeUpdate();

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

	public List<Project> getAllAssigneProject(String id) {
		List<Project> projectList = new ArrayList<Project>();
		Project project;
		connection = DBconnection.getDbConnection();
		String query = "select * from project_dtl where project_guide_id=?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				project = new Project();
				project.setProject_id(rs.getInt("id"));
				project.setProject_name(rs.getString("project_name"));
				project.setFile_Name(rs.getString("file_name"));
				project.setProject_desc(rs.getString("project_desc"));
				project.setAcadmic_year(rs.getString("acadmic_year"));
				project.setProject_Group(rs.getString("project_group_id"));
				project.setProject_guide(rs.getString("project_guide_id"));
				project.setProject_status(rs.getString("project_status"));
				project.setProject_Technology(rs.getString("project_technology"));
				projectList.add(project);

			}

		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return projectList;
	}

	
	public int setProjectApproveReject(int project_id, String status, String comment)
	{
		connection = DBconnection.getDbConnection();
		String query = "Update project_dtl set project_status =? where id = ?";
		int updateStatus=0;
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, status);
			ps.setInt(2, project_id);
			updateStatus = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updateStatus;
		
	}
	
}
