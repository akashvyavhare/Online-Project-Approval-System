package com.project_approval.service;

import com.project_approval.dao.TeacherDao;
import com.project_approval.entity.Teacher;

public class TeacherService {

	public boolean TeacherLogin(String username, String password) {
		boolean login = false;

		return login;
	}

	public String registerTeacher(Teacher teacher) {
		String massage = null;
		TeacherDao dao = new TeacherDao();
		int status = dao.teacherRegister(teacher);
		if (status == 1) {
			massage = "Register successfully";
		}
		else {
			massage = "Something wrong on server";
		}
		return massage;
	}

}
