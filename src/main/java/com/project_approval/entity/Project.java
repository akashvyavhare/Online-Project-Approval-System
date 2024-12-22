package com.project_approval.entity;

import java.io.File;

public class Project {
	
	private int project_id;
	
	private String project_name;
	
	private String project_desc;
	
	private String project_guide;
	
	private String acadmic_year;
	
	private String file_Name;
	
	private byte [] file_data;

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	

	public String getProject_desc() {
		return project_desc;
	}

	public void setProject_desc(String project_desc) {
		this.project_desc = project_desc;
	}

	public String getProject_guide() {
		return project_guide;
	}

	public void setProject_guide(String project_guide) {
		this.project_guide = project_guide;
	}

	public String getAcadmic_year() {
		return acadmic_year;
	}

	public void setAcadmic_year(String acadmic_year) {
		this.acadmic_year = acadmic_year;
	}
	
	public String getFile_Name() {
		return file_Name;
	}

	public void setFile_Name(String file_Name) {
		this.file_Name = file_Name;
	}

	public byte[] getFile_data() {
		return file_data;
	}

	public void setFile_data(byte[] file_data) {
		this.file_data = file_data;
	}


	

}
