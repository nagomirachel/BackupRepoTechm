<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Family Plant</title>
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
<form:form  method="post" action="/adms-spring-web/insertfamilyplant" modelAttribute="familyPlantCode">
<%--<table>
 <tr>
<td>
Family Plant Code :
</td>
<td>
<form:input path="familyPlantCode"/>
</td>
</tr>


<tr>
<td>
Family Code :
</td>
<td>
<form:input path="familyCode"/>
</td>
</tr>

<tr>
<td>
Plant Code :
</td>
<td>
<form:input path="plantCode"/>
</td>
</tr>


<tr>  
<td>
<input type="submit" value="Save" />
</td>  
</tr> 
</table>
</form:form>

</body>
</html> --%>

<br/>
<br/>
<br/>
<br/>

<table border="1" align="center" bgcolor="C63340">

<tr>
<td>Plant Code :</td>
<td><form:input path="plantCode"/></td>
</tr>

<tr>
<td>Family Code :</td>
<td><form:input path="familyCode"/></td>
</tr>

<tr>
<td>Family Plant Code :</td>
<td><form:input path="familyPlantCode"/></td>
</tr>

<tr>
<td>Family Plant Name :</td>
<td><form:input path="familyPlantName"/></td>
</tr>

<tr>
<td>APN Code :</td>
<td><form:input path="APNCode"/></td>
</tr>

<tr>
<td>APN Character :</td>
<td><form:input path="APNCharacter"/></td>
</tr>

<tr>
<td>Family Plant Eligibility Code :</td>
<td><form:input path="familyplanteligibilityCode"/></td>
</tr>

<tr>
<td>Eligibility Check Flag :</td>
<td><form:input path="eligibilityFlag"/></td>
</tr>

<tr>
<td>
Associated Project Engineer ID :
</td>
<td>
<form:input path="associatedPEId"/>
</td>
</tr>

<tr> <td><input type="submit" value="Save" /> </td>  
     </tr>  


</table>
</form:form>


