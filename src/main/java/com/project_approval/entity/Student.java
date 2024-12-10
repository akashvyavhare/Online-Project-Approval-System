package com.project_approval.entity;

public class Student {

	private int id ;
	private String crn;
	private String name;
	private String password;
	private String sem_year;
	private String dept;
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCrn() {
		return crn;
	}
	public void setCrn(String crn) {
		this.crn = crn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSem_year() {
		return sem_year;
	}
	public void setSem_year(String sem_year) {
		this.sem_year = sem_year;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", crn=" + crn + ", name=" + name + ", password=" + password + ", sem_year="
				+ sem_year + ", dept=" + dept + "]";
	}
	
	
}
