package com.project_approval.service;

import java.util.ArrayList;
import java.util.List;

import com.project_approval.dao.AdminDao;
import com.project_approval.dao.TeacherDao;
import com.project_approval.entity.Project;
import com.project_approval.entity.Teacher;

public class TeacherService {

	public Teacher teacherLogin(String username, String password) {
		Teacher teacher = null ;
		TeacherDao dao = new TeacherDao();
		teacher = dao.loginTeacher(username, password);

		return teacher;
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
	
	public List<Project> getAllAssignProject(int id){
		List<Project> project = new ArrayList<Project>();
		project = new TeacherDao().getAllAssigneProject(String.valueOf(id));
		//System.out.println(project);
		return project;
	}
	
	
	public String   setProjectApproveReject(String project_id, String status, String comment)
	{
		String msg = "Fail to Approve or Reject";
		int updateStatus= new TeacherDao().setProjectApproveReject(Integer.parseInt(project_id), status, comment);
		
		if(updateStatus>0)
		{
			switch (status) {
			case "approved":{
				msg ="Project is Approved";
				break;
			}
			case "rejected":{
				msg ="Project is Rejected";
				break;
			}
			case "changesSuggested":{
				msg ="Changes Suggested To Project";
				break;
			}
			}
		}
		
		return msg;
	}

}
