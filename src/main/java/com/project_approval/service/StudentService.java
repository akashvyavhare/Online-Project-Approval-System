package com.project_approval.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

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

}
