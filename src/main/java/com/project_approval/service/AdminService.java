package com.project_approval.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project_approval.dao.AdminDao;
import com.project_approval.entity.Admin;
import com.project_approval.entity.Project;
import com.project_approval.entity.Student;
import com.project_approval.entity.Teacher;

public class AdminService {

	public Admin adminLogin(String username, String password) {
		Admin admin = null ;
		AdminDao dao = new AdminDao();
		admin = dao.loginAdmin(username, password);

		return admin;
		
	}
	
	public List<Student> getAllNewRegisterStudentList() {
		List<Student> student =new ArrayList<Student>();
		AdminDao adminDao =new AdminDao();
		student = adminDao.getAllNewRegisterStudent();
		 return student;	 
		
	}
	public List<Student> getAllStudentList() {
		List<Student> student =new ArrayList<Student>();
		AdminDao adminDao =new AdminDao();
		student = adminDao.getAllStudentList();
		 return student;	 
		
	}
	
	public List<Teacher> getAllTeacher(){
		List<Teacher> teacher =new ArrayList<Teacher>();
		AdminDao adminDao =new AdminDao();
		teacher = adminDao.getAllNewRegisterTeacher();
		return teacher;
		}
	
	
	public List<Project> getAllCompleteProject(){
		List<Project> project = new ArrayList<Project>();
		AdminDao adminDao =new AdminDao();
		project = adminDao.getAllCompleteProject();
		//System.out.println(project);
		return project;
	}
	
	public List<Project> getAllNewProposeProject(){
		List<Project> project = new ArrayList<Project>();
		AdminDao adminDao =new AdminDao();
		project = adminDao.getAllNewProposeProject();
		//System.out.println(project);
		return project;
	}
	
	
	public String createProjectGroup(String []student_list, String groupName){
		String msg="Fail to create Group";
		
		boolean isCreated = new AdminDao().createNewProjectGroup(student_list, groupName);
		
		if(isCreated)
		{
			msg="Student Group Is Created";
		}
		
		return msg;
	}
	
	public String assignProjectGuide(String tchrId, String project_id){
		String msg="Fail to Assign guide";
		System.out.println(2);
		boolean isAssign = false;
		isAssign = new AdminDao().assignProjectGuide(tchrId, project_id);
		
		if(isAssign)
		{
			msg="Project Guide Is Assign Successfully";
			System.out.println(4);
		}
		
		return msg;
	}
	
}
