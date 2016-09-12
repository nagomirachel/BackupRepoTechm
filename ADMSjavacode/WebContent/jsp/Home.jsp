<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WHALE</title>
</head>
<img src="/adms-spring-web/images/logo.jpg" alt=""/>
<body>
<br/>
<br/>
<br/>
<br/>
<form:form method="GET" action="/adms-spring-web/redirect" >
    <div align="center">
    <table>
    <tr>
    <td>
    <input type="submit" value ="Add Family">
    </td>
    </tr>
    </table>
      </div>
    </form:form>
    
    
    
<form:form method="GET" action="/adms-spring-web/view" >
      <div align="center">
    <table>
    <tr>
    <td>
    <input type="submit" value ="View / Edit Family">
    </td>
    </tr>
    
    </table>
  </div>
    </form:form>
    
    
    <form:form method="GET" action="/adms-spring-web/redirect_to_add_family_plant" >
    <div align="center">
    <table>
    <tr>
    <td>
    <input type="submit" value ="Add Family Plant">
    </td>
    </tr>
    </table>
    </div>
    </form:form>
    
    
    
<form:form method="GET" action="/adms-spring-web/view_family_plant" >
        <div align="center">
    <table>
    <tr>
    <td>
    <input type="submit" value ="View/ Edit Family plants">
    </td>
    </tr>
    </table>
    </div>
    </form:form>
    
 
</body>
</html>