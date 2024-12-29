package com.project_approval.student.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project_approval.utility.ProjectApprovalUitility;

@WebServlet("/downloadFile")
public class StudentServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String project_id = req.getParameter("project_id");
//		String project_group_id= req.getParameter("project_group_id");
		String Project_file_name= req.getParameter("project_file_name");
		
		File file = new File(ProjectApprovalUitility.getFilePath()+File.separator+Project_file_name);

		resp.setContentType("application/octate-stream");
		resp.setHeader("Content-Disposition","inline; filename=\"" + file.getName() + "\"");
		InputStream in = new FileInputStream(file);
		byte[] data = new byte[in.available()];
		in.read(data);
		OutputStream os= resp.getOutputStream();
		for(byte b : data)
		{
			os.write(b);
		}
		in.close();
		os.close();
		//System.out.println(file);
		
		
	}
	
}
