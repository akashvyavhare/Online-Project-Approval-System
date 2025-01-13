package com.project_approval.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project_approval.db.DBconnection;
import com.project_approval.entity.Admin;
import com.project_approval.entity.Project;
import com.project_approval.entity.Student;
import com.project_approval.entity.Teacher;

public class AdminDao {

	Connection connection;

	public Admin loginAdmin(String username, String password) {
		Admin admin = null;

		connection = DBconnection.getDbConnection();

		String query = "Select *  from admin_dtl where user_name = ? and Password = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				admin = new Admin();
				admin.setId(rs.getInt("id"));
				admin.setCollege_id(rs.getInt("college_id"));
				admin.setUser_name(rs.getString("user_name"));
				admin.setPassword(rs.getString("Password"));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		System.out.println(admin);

		return admin;

	}

	public List<Student> getAllNewRegisterStudent() {
		List<Student> studentList = new ArrayList<Student>();
		Student student;
		connection = DBconnection.getDbConnection();

		String query = "select * from student_dtl where project_group_id IS NULL";
		try {
			PreparedStatement ps = connection.prepareStatement(query);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				student = new Student();

				student.setId(rs.getInt("id"));
				student.setName(rs.getString("student_name"));
				student.setCrn(rs.getString("crn_no"));
				student.setPassword(rs.getString("password"));
				student.setAcademic_year(rs.getString("academic_year"));
				student.setDepartment(rs.getString("department"));
				student.setProject_group_id(rs.getString("project_group_id"));

				studentList.add(student);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentList;
	}

	public List<Student> getAllStudentList() {
		List<Student> studentList = new ArrayList<Student>();
		Student student;
		connection = DBconnection.getDbConnection();

		String query = "select * from student_dtl ";
		try {
			PreparedStatement ps = connection.prepareStatement(query);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				student = new Student();

				student.setId(rs.getInt("id"));
				student.setName(rs.getString("student_name"));
				student.setCrn(rs.getString("crn_no"));
				student.setPassword(rs.getString("password"));
				student.setAcademic_year(rs.getString("academic_year"));
				student.setDepartment(rs.getString("department"));
				student.setProject_group_id(rs.getString("project_group_id"));

				studentList.add(student);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentList;
	}
	
	public List<Teacher> getAllNewRegisterTeacher() {
		List<Teacher> teacherList = new ArrayList<Teacher>();
		Teacher teacher;
		connection = DBconnection.getDbConnection();

		String query = "select * from teacher_dtl ";
		try {
			PreparedStatement ps = connection.prepareStatement(query);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				teacher = new Teacher();

				teacher.setId(rs.getInt("id"));
				teacher.setTeacher_name(rs.getString("teacher_name"));
				teacher.setPassword(rs.getString("password"));
				teacher.setDepartment(rs.getString("department"));
				teacher.setTeacher_id(rs.getString("teacher_id"));

				teacherList.add(teacher);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return teacherList;

	}

	public List<Project> getAllCompleteProject() {
		List<Project> projectList = new ArrayList<Project>();
		Project project;
		connection = DBconnection.getDbConnection();
		String query = "select * from project_dtl where project_status = 'complete'";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				project = new Project();
				project.setProject_name(rs.getString("project_name"));
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
		System.out.println(query);
		System.out.println(projectList);
		return projectList;
	}


	public List<Project> getAllNewProposeProject() {
		List<Project> projectList = new ArrayList<Project>();
		Project project;
		connection = DBconnection.getDbConnection();
		String query = "select * from project_dtl where project_status !='complete'";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
			project=new Project();
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


	public boolean createNewProjectGroup(String[] student_list, String projectGroupName) {

		connection = DBconnection.getDbConnection();
		boolean isGroupCreated  =false;
		String noOfStudent = "";
		PreparedStatement ps;
		int groupCreated=0;
		int studentgroupUpdated =0;
		int projectGroupId = 0;

		String query = "Insert into project_group_dtl(group_code) values(?)";
		try {
			ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			System.out.println(ps);
			ps.setString(1, projectGroupName);
			groupCreated = ps.executeUpdate();
			System.out.println("groupCreated"+groupCreated);
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) {
				 projectGroupId=rs.getInt(1);
			}
			
			for (String s : student_list) {
				noOfStudent=noOfStudent+"?,";
			}
			noOfStudent= noOfStudent.substring(0, noOfStudent.length()-1);

			if (groupCreated == 1) {
				String updateQuery = "update student_dtl set project_group_id = ? where crn_no in ("+noOfStudent+")";
				ps=connection.prepareStatement(updateQuery);
				System.out.println(ps);
				ps.setString(1,  String.valueOf(projectGroupId));
				for(int j=2,i =0;i<student_list.length;i++,j++)
				{
				ps.setString(j, student_list[i]);
				}
				studentgroupUpdated =ps.executeUpdate();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if(studentgroupUpdated>0)
		{
			return isGroupCreated=true;
		}
		return isGroupCreated;
	}



	public boolean assignProjectGuide(String tchrId, String projectid) {
		connection = DBconnection.getDbConnection();
		PreparedStatement ps;
		boolean isAssign = false;
		int guideAssign = 0;
		int projectGuideId=0;
		int projectGuideUpdated=0;
		
		System.out.println(5);
		try {
			
				
				String updateQuery ="UPDATE project_dtl SET project_guide_id = ? where id=?";
				ps=connection.prepareStatement(updateQuery);
					
			   
				ps.setString(1, tchrId);
				 ps.setInt(2, Integer.parseInt(projectid));
			        
				projectGuideUpdated =ps.executeUpdate();
				
				System.out.println(6);
				
			
		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		if(projectGuideUpdated>0)
		{
			return isAssign=true;
		}
		
		return isAssign;
	}
	
	}

