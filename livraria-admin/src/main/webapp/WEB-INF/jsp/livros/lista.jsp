<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>livraria-admin</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	$("#livros .remove").on("click", function(event) {
		event.preventDefault();

		var livro = $(this).closest(".livro");

		$.ajax({
			url: $(this).attr("href"),
			type: 'POST',
			data: { _method: "DELETE" }
		}).done(function(data, textStatus, jqXHR) {
			livro.fadeOut();
		}).fail(function(jqXHR, textStatus, errorThrow) {
			alert("O livro não foi removido!");
		});
	});
});
</script>
</head>
<body>
	<c:if test="not empty mensagem">
		<p class="mensagem">${mensagem}</p>
	</c:if>
	<h3>Lista de Livros</h3>
	<ul id="livros">
		<c:forEach items="${livroList}" var="livro">
			<li class="livro"><img
				src="${linkTo[LivrosController].capa(livro.isbn)}" width="70"
				height="100"> ${livro.titulo}- ${livro.descricao} <a
				href="${linkTo[LivrosController].edita(livro.isbn)}">Modificar</a> -
				<a class="remove"
				href="${linkTo[LivrosController].remove(livro.isbn)}">Remover</a></li>
		</c:forEach>
	</ul>
</body>
</html>