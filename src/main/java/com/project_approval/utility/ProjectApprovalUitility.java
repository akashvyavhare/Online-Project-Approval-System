package com.project_approval.utility;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.Part;

public class ProjectApprovalUitility {

	public byte[] getFileStream(Part part) {
		return null;
	}

	public static String getFilePath() {
		
		String docDirectoryPath= "";
		try {

			File[] fileRoot = File.listRoots();
			
		 docDirectoryPath = fileRoot[0]  + "Online-Project-Approval-System" + File.separator + "ProjectUploadFiles"+File.separator;
	
			File file = new File(docDirectoryPath);
			if (!file.exists()) {
				file.mkdirs();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return docDirectoryPath;
	}

	public static void main(String[] args) {

//		System.out.println(getFilePath());
//		
//		File file = new File(getFilePath());
//		
//		System.out.println(!file.exists());
//

		
	}
}
