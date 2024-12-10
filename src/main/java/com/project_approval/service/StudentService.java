package com.project_approval.service;

import com.project_approval.dao.StudentDao;
import com.project_approval.entity.Student;

public class StudentService {
	
	public boolean studentLogin(String username , String password) {
		boolean login =false;
		
		
		
		
		
		return login;
	}
	
	
	
	public int registerStudent(Student student)
	{
		int status = 0;
		StudentDao dao = new StudentDao();
		dao.studentRegister(student);
		
		
		return status;
	}

}
