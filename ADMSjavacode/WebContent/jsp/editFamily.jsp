<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Family</title>
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
	        <div align="center"></div>
	        <h1>Edit Family</h1>

<form:form method="GET" action="/adms-spring-web/editinsert" modelAttribute="family" >
   <div align="center">
    <table  border="2" bgcolor="C63340">  
     <tr>  
      <td>Family Code :</td>  
      <td><input value="${familyList.familyCode}" name="familyCode" readonly="readonly" /></td>  
     </tr>
       
     <tr>  
      <td>Family Name :</td>  
      <td><input value="${familyList.familyName}" name="familyName" /></td>  
     </tr>
       
     <tr>  
      <td>Associated PE ID:</td>  
      <td><input value="${familyList.createUserId}" name="createUserId"/></td>  
     </tr>
     
     
     <tr>  
      <td>Family Eligibility Code:</td>  
      <td><input value="${familyList.familyEligibiltyCode }" name="familyEligibiltyCode"/></td>
     </tr>
     
      <tr>  
      <td>Eligibility Flag:</td>  
      <td><input value="${familyList.eligibilityFlag}" name="eligibilityFlag"/></td>  
     </tr> 
     
     
     
     <tr>  
      <td><input type="submit" value="Save" /></td>  
     </tr> 
     
     
    </table>  
   </div>
</form:form>


</body>
</html> 




<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	        <h1>Family List</h1>
        	<table border="1">
	        	<th>Family Code</th>
	        	<th>Family Name</th>
	        	<th>Created User Id</th>
	        	<th>Created date</th>
	        	<th>Eligibility Flag</th>
	        	
	        	
	        	
	
	        	<tr>
	        		<td>${familyList.familyCode}</td>
					<td>${familyList.familyName}</td>
					<td>${familyList.createUserId}</td>
					<td>${familyList.dateCreated}</td>
					<td>${familyList.eligibilityFlag}</td>
					<td>
					</tr>
					
	        	
        	</table>
        </div>


</body>
</html> --%>