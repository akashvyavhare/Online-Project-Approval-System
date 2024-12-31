package com.project_approval.entity;

public class Student {

	private int id ;
	private String crn;
	private String name;
	private String password;
	private String academic_year;
	private String department;
	private String project_group_id;

	
	

	public Student() {
		super();
	}
	
	
	public Student(int id, String crn, String name, String password, String academic_year, String department,
			String project_group_id) {
		super();
		this.id = id;
		this.crn = crn;
		this.name = name;
		this.password = password;
		this.academic_year = academic_year;
		this.department = department;
		this.project_group_id = project_group_id;
	}


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

	public String getProject_group_id() {
		return project_group_id;
	}


	public void setProject_group_id(String project_group_id) {
		this.project_group_id = project_group_id;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", crn=" + crn + ", name=" + name + ", password=" + password + ", academic_year="
				+ academic_year + ", department=" + department + ", project_group_id=" + project_group_id + "]";

	}

	
	
	
	
	
}
