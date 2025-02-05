package com.project_approval.entity;

public class Admin {

	private int id ;
	private int college_id;
	private String user_name;
	private String password;
	
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCollege_id() {
		return college_id;
	}
	public void setCollege_id(int college_id) {
		this.college_id = college_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Override
	public String toString() {
		return "Admin [id=" + id + ", college_id=" + college_id + ", user_name=" + user_name + ", password=" + password + "]";
	}
	
	
}
