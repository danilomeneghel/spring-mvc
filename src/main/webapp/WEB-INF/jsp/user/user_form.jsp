<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar Usuário</title>
</head>
<body>
<a href='<c:url value="/logout" />'>Logout</a>
 <br/>
 
 <h2>Cadastrar Usuário</h2>
 <spring:url value="/user/save" var="saveURL" />
 <form:form modelAttribute="userForm" method="post" action="${saveURL }" >
  <form:hidden path="id"/>
  <table>
   <tr>
    <td>Nome: </td>
    <td>
     <form:input path="name"/>
    </td>
   </tr>
   <tr>
    <td>E-mail: </td>
    <td>
     <form:input path="email"/>
    </td>
   </tr>
   <tr>
    <td>Endereço: </td>
    <td>
     <form:input path="address"/>
    </td>
   </tr>
   <tr>
    <td>Usuário: </td>
    <td>
     <form:input path="username"/>
    </td>
   </tr>
   <tr>
    <td>Senha: </td>
    <td>
     <form:password path="password" />
    </td>
   </tr>
   <tr>
    <td></td>
    <td>
     <button type="submit">Salvar</button>
    </td>
   </tr>
  </table>
  
 </form:form>
 
</body>
</html>