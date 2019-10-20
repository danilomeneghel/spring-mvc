<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
 <form name="loginForm" action='<c:url value="j_spring_security_check" />' method="post" >
  <table>
   <tr>
    <td colspan="2">Login</td>
   </tr>
   <tr>
    <td colspan="2">${msg }</td>
   </tr>
   <tr>
    <td>Username: </td>
    <td>
     <input type="text" name="username" />
    </td>
   </tr>
   <tr>
    <td>Password: </td>
    <td>
     <input type="password" name="password" />
    </td>
   </tr>
   <tr>
    <td>Remember Me: </td>
    <td>
     <input type="checkbox" name="remember-me" />
    </td>
   </tr>
   <tr>
    <td></td>
    <td>
     <button type="submit">Login</button>
    </td>
   </tr>
   <tr>
    <td></td>
    <td>
     <a href='<c:url value="/user/signup" />'>Sign up</a>
    </td>
   </tr>
  </table>
 </form>
</body>
</html>