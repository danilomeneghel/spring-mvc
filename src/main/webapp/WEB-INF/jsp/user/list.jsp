<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users List</title>
</head>
<body>
 <a href='<c:url value="/logout" />'>Logout</a>
 <br/>
 
 <h2>Lista de Usuários</h2>
 <table border="1">
  <tr>
   <td>Username</td>
   <td>Action</td>
  </tr>
  <c:forEach items="${list }" var="user">
   <tr>
    <td>${user.username }</td>
    <td>
     <spring:url value="/user/changePass" var="changePassURL" />
     <a href="${changePassURL }/${user.username }">Change Pass</a> 
    </td>
   </tr>
  </c:forEach>
 </table>
 
</body>
</html>