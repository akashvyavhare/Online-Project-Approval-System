package com.project_approval.entity;

public class Teacher {

	private int id ;
	private String teacher_name;
	private String teacher_id;
	private String department;
	private String password;
	
	
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	public String getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String dept) {
		this.department = dept;
	}
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", teacher_name=" + teacher_name + ", teacher_id=" + teacher_id + ", password=" + password +  
				 " ,department=" + department + "]";
	}
	
	
}
