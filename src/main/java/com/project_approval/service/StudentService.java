package com.project_approval.service;

import com.project_approval.dao.StudentDao;
import com.project_approval.entity.Student;

public class StudentService {

	public Student studentLogin(String username, String password) {
		Student student = null ;
		StudentDao dao = new StudentDao();
		student = dao.loginStudent(username, password);

		return student;
	}
	

	public String registerStudent(Student student) {
		String massage = null;
		StudentDao dao = new StudentDao();
		int status = dao.studentRegister(student);
		if (status == 1) {
			massage = "Register successfully";
		}
		else {
			massage = "Something wrong on server";
		}
		return massage;
	}

}
