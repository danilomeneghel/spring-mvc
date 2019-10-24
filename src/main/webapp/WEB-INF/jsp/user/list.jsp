<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Usuários</title>
</head>
<body>
<a href='<c:url value="../logout" />'>Logout</a>
 <br/>
 <spring:url value="/user/add" var="addURL" />
 <a href="${addURL }">Adicionar Usuário</a>
 <br/>
 
 <h2>Lista de Usuários</h2>
 <table width="100%" border="1">
  <tr>
   <th>ID</th>
   <th>Nome</th>
   <th>E-mail</th>
   <th>Endereço</th>
   <th>Usuário</th>
   <th colspan="3">Ação</th>
  </tr>
  <c:forEach items="${listUser }" var="user" >
   <tr>
    <td>${user.id }</td>
    <td>${user.name }</td>
    <td>${user.email }</td>
    <td>${user.address }</td>
    <td>${user.username }</td>
    <td>
     <spring:url value="/user/changePass" var="changePassURL" />
     <a href="${changePassURL }/${user.username }">Alterar Senha</a>
    </td>
    <td>
     <spring:url value="/user/update/${user.id }" var="updateURL" />
     <a href="${updateURL }">Atualizar</a>
    </td>
    <td>
     <spring:url value="/user/delete/${user.id }" var="deleteURL" />
     <a href="${deleteURL }">Excluir</a>
    </td>
   </tr>    
  </c:forEach>
 </table>
 
</body>
</html>