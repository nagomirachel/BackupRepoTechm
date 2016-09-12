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
	      
	    <div align="center"><h1>Add Family</h1></div>

 <form:form  method="GET" action="/adms-spring-web/insert/${familyCode}/${familyName}/${createUserId}/${familyEligibiltyCode}/${eligibilityFlag}" 
 modelAttribute="family"> 
 <div align="center">
  <table border="2" bgcolor="C63340"> 
     <tr>  
      <td>Family Code :</td>  
      <td><form:input path="familyCode"/></td>  
     </tr>
       
     <tr>  
      <td>Family Name :</td>  
      <td><form:input path="familyName" /></td>  
     </tr>
       
     <tr>  
      <td>Associated PE ID:</td>  
      <td><form:input path="createUserId" /></td>  
     </tr>
     
     
     <tr>  
      <td>Family Eligibility Code:</td>  
      <td><form:input path="familyEligibiltyCode" /></td>  
     </tr>
     
      <tr>  
      <td>Eligibility Flag:</td>  
      <td><form:input path="eligibilityFlag" /></td>  
     </tr>
   
     
     
      
     <%-- <tr>
     <td>
     Eligibility Check Flag<form:checkbox path="eligibility_flag"/>
     </td>
     </tr> 
     
      <tr>
     <td>
     Default Engineer Flag<form:checkbox path="engineer_flag"/>
     </td>
     </tr> --%>
     
     </table>
     <br/>
     
    <center><input type="submit" value="Save" /></center>  
       
       
     
    </div>
   </form:form>  


<br/>


</body>
</html>