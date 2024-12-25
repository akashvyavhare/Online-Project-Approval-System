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

		String query = "Insert into project_dtl (project_name, project_desc, file_name, acadmic_year, student_id, project_guide, project_group_id) values (?,?,?,?,?,?,?)";

		try {

			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, project.getProject_name());
			ps.setString(2, project.getProject_desc());
			ps.setString(3, project.getFile_Name());
			ps.setString(4, project.getAcadmic_year());
			ps.setString(5, null);
			ps.setString(6, null);
			ps.setString(7, null);

			int insert = ps.executeUpdate();

			if (insert >= 1) {
				status = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// connection.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return status;
	}

	public ResultSet getAllProposedProjectByStudent(Student student)
	{
		ResultSet rs =null;

		
		try
		{
		connection = DBconnection.getDbConnection();
			
		String query = "Select * from project_dtl where student_id=?";
		
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setString(1, "1"/*String.valueOf(student.getId())*/);
		
		rs =ps.executeQuery();
		
		}
		catch
		(Exception e)
		{
			e.printStackTrace();
		}
		
		return  rs;
	}

}
