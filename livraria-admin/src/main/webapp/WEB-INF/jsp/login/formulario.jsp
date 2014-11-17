<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>livraria-admin</title>
</head>
<body>
	<form action="${linkTo[LoginController].login}" method="post">
		<h2>Formulário de login</h2>
		<ul>
			<li>Login: <br /> <input type="text" name="login" /></li>
			<li>Senha: <br /> <input type="password" name="senha" /></li>
		</ul>
		<input type="submit" value="Login" />
	</form>
</body>
</html>