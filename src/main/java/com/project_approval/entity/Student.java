package com.project_approval.entity;

public class Student {

	private int id ;
	private String crn;
	private String name;
	private String password;
	private String academic_year;
	private String department;
	

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
	public String getAcademic_year() {
		return academic_year;
	}
	public void setAcademic_year(String academic_year) {
		this.academic_year = academic_year;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String dept) {
		this.department = dept;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", crn=" + crn + ", name=" + name + ", password=" + password + ", academic_year="
				+ academic_year + ", department=" + department + "]";
	}
	
	
}
