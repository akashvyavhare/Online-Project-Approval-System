package com.project_approval.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.project_approval.db.DBconnection;
import com.project_approval.entity.Project;
import com.project_approval.entity.Student;

public class StudentDao {

	Connection connection;

	public int studentRegister(Student student) {
		connection = DBconnection.getDbConnection();
		int insertStatus = 0;

		String query = "Insert into student_dtl (student_name , crn_no , department , academic_year , password) values (?,?,?,?,?)";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, student.getName());
			ps.setString(2, student.getCrn());
			ps.setString(3, student.getDepartment());
			ps.setString(4, student.getAcademic_year());
			ps.setString(5, student.getPassword());

			insertStatus = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return insertStatus;
	}

	public Student loginStudent(String username, String password) {
		Student student = null;

		connection = DBconnection.getDbConnection();

		String query = "Select *  from student_dtl where crn_no = ? and Password = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("student_name"));
				student.setCrn(rs.getString("crn_no"));
				student.setPassword(rs.getString("Password"));
				student.setDepartment(rs.getString("department"));
				student.setAcademic_year(rs.getString("academic_year"));
				student.setProject_group_id(rs.getString("project_group_id"));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		System.out.println(student);

		return student;
	}

	public boolean addNewProject(Project project) {
		connection = DBconnection.getDbConnection();

		boolean status = false;

		
		String query ="Insert into project_dtl (project_name, project_desc, file_name, acadmic_year, project_group_id,project_technology) values (?,?,?,?,?,?)";
		

		try {

			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, project.getProject_name());
			ps.setString(2, project.getProject_desc());
			ps.setString(3, project.getFile_Name());
			ps.setString(4, project.getAcadmic_year());
			ps.setString(5, project.getProject_Group());
			ps.setString(6, project.getProject_Technology());

			
			int insert = ps.executeUpdate();

			if (insert >= 1) {
				status = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} 
		return status;
	}

	public ResultSet getAllProposedProjectByStudent(String  projectGroupId) {
		ResultSet rs = null;

		try {
			connection = DBconnection.getDbConnection();

			String query = "Select * from project_dtl where project_group_id=?";

			PreparedStatement ps = connection.prepareStatement(query);

			ps.setString(1, projectGroupId);

			rs = ps.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return rs;
	}

	public int updateProjectDetails(Project project) {
		connection = DBconnection.getDbConnection();
		String query = "update project_dtl set project_name=?, file_name=?, project_desc=?, acadmic_year=?, project_technology=? where id=?";
		int update = 0;
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, project.getProject_name());
			ps.setString(2, project.getFile_Name());
			ps.setString(3, project.getProject_desc());
			ps.setString(4, project.getAcadmic_year());
			ps.setString(5, project.getProject_Technology());
			ps.setInt(6, project.getProject_id());

			update = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return update;
	}

	public Project getProjectDetailsById(int id) {
		connection = DBconnection.getDbConnection();
		Project project = null;
		String query = "select * from project_dtl where id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				project = new Project();
				project.setProject_id(rs.getInt("id"));
				project.setProject_name(rs.getString("project_name"));
				project.setProject_desc(rs.getString("project_desc"));
				project.setAcadmic_year(rs.getString("acadmic_year"));
				project.setProject_Technology(rs.getString("project_technology"));

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return project;
	}
	
	
	public int getStudentGroupId(int Student_id)
	{
		connection = DBconnection.getDbConnection();
		int studentGroupId = 0;
		String query = "Select project_group_id from student_dtl where id=?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, Student_id);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				studentGroupId = rs.getInt("project_group_id"); 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return studentGroupId;
	}

}
