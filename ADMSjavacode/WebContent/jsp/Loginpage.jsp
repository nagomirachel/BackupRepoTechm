<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<img src="/adms-spring-web/images/logo.jpg" alt=""/>
<body>

<table border="2" bgcolor="C63340">
 <form:form method="GET" action="/adms-spring-web/newMethod" modelAttribute="login">
 
 <tr>
                        <td> Username  : </td>
                        <td> <form:input path="username"/>
                    </tr>
                    
                    <tr>
                        <td> Password  : </td><td> 
                        <form:password path="password"/> </td> 
                    </tr>
                    
                    <tr>
                    <td>
                    <input type="submit" value="login">
                    </td>
                    </tr>
                     </form:form>
                </table>
 
</body>
</html>