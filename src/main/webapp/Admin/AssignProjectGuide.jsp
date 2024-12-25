<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	 <table>
        <thead>
            <tr>
                <th>Project Title</th> 
                <th>Project Year</th>
                <th>Project Guide</th>
                <th>Project Status</th>
                <th>Project Comment</th>
                <th>Project Tech</th>
                <th>Project Group</th>
                <th>Project File</th>
                 <th>Guide Name</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>Schilder</td>
                
                <td>2008</td>
                <td>Zakir Afridi</td>
                <td>
                    <select>
                        <option>Start Working ASAP</option>
                        <option>Leave Remarks</option>
                    </select>
                </td>
                <td><input type="text" placeholder="Enter remarks"></td>
                <td>UX/UI</td>
                <td>2</td>
                <td><button class="download-button">Download</button></td>
                <td>
                    <select>
                        <option>Rohini</option>
                        <option>Kiran</option>
                    </select>
                </td>
                
                <td><button class="submit-button">Assign</button></td>
            </tr>
           
        </tbody>
    </table>

</body>
</html>