<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar Senha</title>
</head>
<body>
<a href='../list'>Voltar</a>
 <br/>
 
<h2>Alterar Senha</h2>
 <spring:url value="/user/save" var="saveURL" />
 <form:form method="post" modelAttribute="user" action="${saveURL }">
  <form:hidden path="id"/>
  <form:hidden path="name"/>
  <form:hidden path="email"/>
  <form:hidden path="address"/>
  <form:hidden path="username"/>
  <table border="0">
   <tr>
    <td colspan="2">${msg }</td>
   </tr>
   <tr>
    <td>Usuário: </td>
    <td>${user.username }</td>
   </tr>
   <tr>
    <td>Senha: </td>
    <td><form:password path="password" /></td>
   </tr>
   <tr>
    <td></td>
    <td>
     <button type="submit" >Alterar a senha</button>
    </td>
   </tr>
  </table>
 </form:form>
 
</body>
</html>