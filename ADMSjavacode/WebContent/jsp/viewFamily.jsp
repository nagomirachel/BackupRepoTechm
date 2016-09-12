<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<img src="/adms-spring-web/images/logo.jpg" alt=""/>
<body>

<form method="GET" action="/adms-spring-web/jsp/Home.jsp">
    
    <table>
    <tr>
    <td>
    <input type="submit" value ="HOME" align="right">
    </td>
    </tr>
    </table>
    
    </form>
<div align="center">
	        <h1>Family List</h1>
        	<table border="2" bgcolor="C63340">
	        	<th>Family Code</th>
	        	<th>Family Name</th>
	        	<th>Created User Id</th>
	        	<th>Created date</th>
	        	<th>Eligibility Flag</th>
	        	<th>Action</th>
	        	<th>Action</th>
	        	
	        	
				<c:forEach var="family" items="${familyList}">
	        	<tr>
	        		<td>${family.familyCode}</td>
					<td>${family.familyName}</td>
					<td>${family.createUserId}</td>
					<td>${family.dateCreated}</td>
					<td>${family.eligibilityFlag}</td>
					<td>
					
					<form:form method="GET" action="/adms-spring-web/edit/${family.familyCode}">
    
    <table>
    <tr>
    <td>
    <input type="submit" value ="Edit">
    </td>
    </tr>
    </table>
    
    </form:form>
					</td>
					<td>
					
					<form:form method="GET" action="/adms-spring-web/delete/${family.familyCode}">
    
    <table>
    <tr>
    <td>
    <input type="submit" value ="Delete">
    </td>
    </tr>
    </table>
    
    </form:form>
					</td>
	
					
							
	        	</tr>
				</c:forEach>	        	
        	</table>
        </div>


</body>
</html>