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
	<ul class="errors">
		<c:forEach items="${errors}" var="error">
			<li>${error.category}:${error.message}</li>
		</c:forEach>
	</ul>
	<form action="${linkTo[LivrosController].salva}" method="post">
		<input type="hidden" name="livro.id" value="${livro.id}" />
		<h2>Formulário de cadastro de livros</h2>
		<ul>
			<li>Título: <br /> <input type="text" name="livro.titulo"
				value="${livro.titulo}" /></li>
			<li>Descrição: <br /> <textarea name="livro.descricao">${livro.descricao}</textarea></li>
			<li>ISBN: <br /> <input type="text" name="livro.isbn"
				value="${livro.isbn}" /></li>
			<li>Preço: <br /> <input type="text" name="livro.preco"
				value="${livro.preco}" /></li>
			<li>Data de publicação: <br /> <input type="text"
				name="livro.dataPublicacao" value="${livro.dataPublicacao}" /></li>
		</ul>
		<input type="submit" value="Salvar" />
	</form>
</body>
</html>