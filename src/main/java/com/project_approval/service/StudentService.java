package com.project_approval.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.project_approval.dao.StudentDao;
import com.project_approval.entity.Project;
import com.project_approval.entity.Student;
import com.project_approval.utility.ProjectApprovalUitility;

public class StudentService {

	public Student studentLogin(String username, String password) {
		Student student = null;
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
		} else {
			massage = "Something wrong on server";
		}
		return massage;
	}

	public int proposeNewProject(Project project) {

		StudentDao studentDao = new StudentDao();
		boolean fileuploadStatus = false;
		boolean newProjectAddStatus = false;
		int projectStatus = 0;

		try {
			byte[] fiel_data = project.getFile_data();

			File newFile = new File(ProjectApprovalUitility.getFilePath() + project.getFile_Name());
			if (!newFile.exists()) {
				newFile.createNewFile();
			}

			OutputStream os = new FileOutputStream(newFile);

			for (byte data : fiel_data) {
				os.write(data);

			}
			os.close();
			fileuploadStatus = true;
			projectStatus = 1;

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (fileuploadStatus) {
			newProjectAddStatus = studentDao.addNewProject(project);

			if (newProjectAddStatus) {
				projectStatus = 2;
			}

		}

		return projectStatus;
	}

	public List<Project> getProposedProject(Student student)
	{
		List<Project> projectsList = new ArrayList<Project>() ;

		Project project;
		
		ResultSet rs;
		
		try
		{	
		StudentDao dao = new StudentDao();
		
		rs = dao.getAllProposedProjectByStudent(student.getProject_group_id());
		
		while(rs.next())
		{
			project = new Project();
			
			project.setProject_id(rs.getInt("id"));
			project.setProject_name(rs.getString("project_name"));
			project.setProject_desc(rs.getString("project_desc"));
			project.setProject_guide(rs.getString("project_guide_id"));
			project.setAcadmic_year(rs.getString("acadmic_year"));
			project.setFile_Name(rs.getString("file_name"));
			project.setProject_status(rs.getString("project_status"));
			project.setProject_Technology(rs.getString("project_technology"));
			project.setProject_Group(rs.getString("project_group_id"));
			
			
			
			projectsList.add(project);
		}
		}
		catch
		(Exception e)
		{
			e.printStackTrace();
		}
		
		return projectsList;
	}

	public String updateProjectDetails(Project project)
	{
		int updateStatus =0;
		String statusMsg = "Fail To Update Details";
		StudentDao dao = new StudentDao();
		ProjectApprovalUitility projectApprovalUitility = new ProjectApprovalUitility();
		boolean fileUploadStatus = projectApprovalUitility.uploadFile(project, null);
		if(fileUploadStatus)
		{
				updateStatus= dao.updateProjectDetails(project);
				statusMsg="Project File Update Details, Issue in other details";
		}
		
		if(updateStatus==1) {
			
			statusMsg="Project Updated";
		}
		return statusMsg;
	}

	public Project getProjectById(String id)
	{
		
		Project project= new StudentDao().getProjectDetailsById(Integer.parseInt(id));
		
		return project;
	}
	
	
	public void getStudentGroupId(int student_id) {
		
		
		
		
	}
	
}
