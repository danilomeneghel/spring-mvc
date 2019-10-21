<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro</title>
</head>
<body>
 <spring:url value="/user/register" var="registerURL" />
 <form:form action="${registerURL}" modelAttribute="userForm" method="post" >
 <div style="width:360px; margin:60px auto 0px auto">
  <div style="text-align:center"><h2>Cadastro</h2></div>
  <label>Nome: </label>
  <form:input path="name" type="text" />
  <form:errors path="name" />
  <br/>
  <label>E-mail: </label>
  <form:input path="email" type="text" />
  <form:errors path="email" />
  <br/>
  <label>Endereço: </label>
  <form:input path="address" type="text" />
  <form:errors path="address" />
  <br/>
  <label>Usuário: </label>
  <form:input path="username" type="text" />
  <form:errors path="username" />
  <br/>
  <label>Senha: </label>
  <form:password path="password" />
  <form:errors path="password" />
  <br/>
  <label>Confirmar Senha: </label>
  <form:password path="confirmPassword" />
  <form:errors path="confirmPassword" />
  <br/>
  <button type="submit">Cadastrar</button>
  </div>
 </form:form>
 
</body>
</html>