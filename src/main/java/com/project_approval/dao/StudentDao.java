package com.project_approval.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project_approval.db.DBconnection;
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
			ps.setString(3, student.getDept());
			ps.setString(4, student.getSem_year());
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
				student.setDept(rs.getString("department"));
				student.setSem_year(rs.getString("academic_year"));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		System.out.println(student);

		return student;
	}

}
