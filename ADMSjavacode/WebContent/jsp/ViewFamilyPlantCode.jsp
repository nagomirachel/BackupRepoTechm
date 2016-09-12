<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Available Family Plant Code Details</title>
</head>
<img src="/adms-spring-web/images/logo.jpg" alt=""/>
<body>
<h1>Family Plant List</h1>
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
<table border="2" align="center" bgcolor="C63340">
<tr>
<th>
Family Plant Code
</th>
<th>
Family Code
</th>
<th>
Plant Code
</th>
</tr>

 <c:forEach var="familyplant" items="${familyplantList}">
<tr>
<td>${familyplant.familyPlantCode}</td>
<td>${familyplant.familyCode}</td>
<td>${familyplant.plantCode}</td>
<td>


<form:form method="GET" action="/adms-spring-web/editfamilyplantcode/${familyplant.familyPlantCode}">
    
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
					
	<form:form method="GET" action="/adms-spring-web/deletefamilyplant/${familyplant.familyPlantCode}">
    
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


<%-- <form:form method="GET" action="/adms-spring-web/">
    
    <table>
    <tr>
    <td>
    <input type="submit" value ="HOME" align="right">
    </td>
    </tr>
    </table>
    
    </form:form> --%>

</body>
</html>