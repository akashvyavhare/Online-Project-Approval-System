package com.project_approval.utility;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.Part;

import com.project_approval.dao.UtilityDao;
import com.project_approval.entity.Project;
import com.project_approval.entity.ProjectGroup;

public class ProjectApprovalUitility {

	public static byte[] getFileStream(Part part) {
		InputStream in = null;
		byte[] filedata = null;
		try {

			in = part.getInputStream();
			filedata = new byte[in.available()];
			in.read(filedata);

		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return filedata;
	}

	public static String getFilePath() {

		String docDirectoryPath = "";
		try {

			File[] fileRoot = File.listRoots();

			docDirectoryPath = fileRoot[0] + "Online-Project-Approval-System" + File.separator + "ProjectUploadFiles"
					+ File.separator;

			File file = new File(docDirectoryPath);
			if (!file.exists()) {
				file.mkdirs();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return docDirectoryPath;
	}

	public boolean uploadFile(Project project, String studentGroupId) {
		
		boolean uploadStatus = false;
		File file = new File(ProjectApprovalUitility.getFilePath() + File.separator + project.getFile_Name());
		try (OutputStream os =new FileOutputStream(file)){
				os.write(project.getFile_data());
				uploadStatus=true;

		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
		return uploadStatus;
	}
	
	
	public ProjectGroup getProjectGroupById(String id)
	{
		int ProjectGroupId = Integer.parseInt(id==null?"0":id);
		ProjectGroup projectGroup = new UtilityDao().getProjectGroupById(ProjectGroupId);
		
		return projectGroup;
	}
	
	

}
