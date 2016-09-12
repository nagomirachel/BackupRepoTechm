<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rule Application</title>
</head>
<body>
<form name="details" action="JBPMServlet">
User Role<input type="text" name="userRole"><br><br>
<table>
					 
						<thead> 
							<tr>
								<th>Select</th>
								<th>Function Code</th>								
								<th>Give Away Tech</th>
								<th>Give Away Comm</th>
								<th>Harness Name</th>
								<th>Sub System 1</th>
								<th>Oncost</th>
								<th>Apply</th>
								<th>Sub System 2</th>
								<th>Oncost</th>
								<th>Apply</th>
							</tr>
							
						</thead>
						<tbody>

							<tr class="odd gradeA">
								<td><input type="checkbox"/></td>
								<td id="subId1">G24020</td>								
								<td><select><option value="yes">Yes</option><option value="No">No</option></select></td>
								<td><select><option value="yes">Yes</option><option value="No">No</option></select></td>
								<td>EG1_H</td>
								<td >AA10-AE</td>
								<td id="subId">$0.16</td>
								<td><select><option value="yes">Yes</option><option value="No">No</option></select></td>
								<td>AA11-AE</td>
								<td>$24</td>
								<td><select><option value="yes">Yes</option><option value="No">No</option></select></td>
							</tr>
							<tr class="odd gradeA">
								<td><input type="checkbox"/></td>
								<td>G24011</td>								
								<td><select><option value="yes">Yes</option><option value="No">No</option></select></td>
								<td><select><option value="yes">Yes</option><option value="No">No</option></select></td>
								<td>ENG-RM_H</td>
								<td>AA13-AG</td>
								<td>$0.12</td>
								<td><select><option value="yes">Yes</option><option value="No">No</option></select></td>
								<td>AB81-AA</td>
								<td>$17</td>
								<td><select><option value="yes">Yes</option><option value="No">No</option></select></td>
							</tr>
						</tbody>
						
					</table>
						
						<input type="submit" value="Submit" name="action">
						<input type="submit" value="Approve" name="action">
						<input type="submit" value="Reject" name="action">
						<input type="submit" value="Cancel" name="action">
</form>
</body>
</html>