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
 <div style="width:260px; margin:60px auto 0px auto">
  <div style="text-align:center"><h2>Login</h2></div>
  <table>
   <tr>
    <td colspan="2">${msg }</td>
   </tr>
   <tr>
    <td>
     Usuário: <br>
     <input type="text" size="30" name="username" />
    </td>
   </tr>
   <tr>
    <td>
     Senha: <br>
     <input type="password" size="30" name="password" />
    </td>
   </tr>
   <tr>
    <td>
     Lembrar-me: <input type="checkbox" name="remember-me" />
    </td>
   </tr>
   <tr>
    <td>
     <button type="submit">Login</button>
    </td>
   </tr>
   <tr>
    <td>
     <br><a href='<c:url value="/user/signup" />'>Criar nova conta</a>
    </td>
   </tr>
  </table>
  </div>
 </form>
</body>
</html>