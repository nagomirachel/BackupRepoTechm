<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Edit Family Plant</title>
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
<br/>
<br/>
<br/>
<br/>

    <h1>Edit Family Plant</h1>

<form:form  method="get" action="/adms-spring-web/editinsertfamilyplant" modelAttribute="familyplant">

<table border="2" align="center" bgcolor="C63340" >

<%-- <tr>
<td>Family Plant Code :</td>
<td><input type="hidden" value="${familyplantList.plantCode}" name="familyPlantCode"/></td>
</tr> --%>

<tr>
<td>Family Plant Code :</td>
<td><input readonly="readonly" value="${familyplantList.familyPlantCode}" name="familyPlantCode"/></td>
</tr>

<tr>
<td>Plant Code :</td>
<td><input value="${familyplantList.plantCode}" name="plantCode"/></td>
</tr>

<tr>
<td>Family Code :</td>
<td><input value="${familyplantList.familyCode}" name="familyCode"/></td>
</tr>

<tr>
<td>Eligibility Check Flag :</td>
<td><input value="${familyplantList.eligibilityFlag}" name="eligibilityFlag"/></td>
</tr>



<tr> <td><input type="submit" value="Save" /> </td>  
     </tr>  


</table>
</form:form>



