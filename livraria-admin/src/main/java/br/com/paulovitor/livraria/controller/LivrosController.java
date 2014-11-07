package br.com.paulovitor.livraria.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.paulovitor.livraria.modelo.Estante;
import br.com.paulovitor.livraria.modelo.Livro;

@Controller
public class LivrosController {

	private Estante estante;
	private Result result;
	private Validator validator;

	@Inject
	public LivrosController(Estante estante, Result result, Validator validator) {
		this.estante = estante;
		this.result = result;
		this.validator = validator;
	}

	/**
	 * @deprecated Apenas para o CDI. Não precisa ser público
	 */
	LivrosController() {
	}

	@Get
	@Path(value = "livros/formulario", priority = Path.HIGH)
	public void formulario() {
	}

	@Get("/livros")
	public List<Livro> lista() {
		return estante.todosOsLivros();
	}

	@Post("/livros")
	public void salva(Livro livro) {
		validator.validate(livro);
		validator.onErrorRedirectTo(this).formulario();

		estante.guarda(livro);

		result.include("mensagem", "Livro salvo com sucesso!");
		result.redirectTo(this).lista();
	}

	@Get
	@Path(value = "/livros/{isbn}", priority = Path.LOW)
	public void edita(String isbn) {
		Livro livroEncontrado = estante.buscaPorIsbn(isbn);
		if (livroEncontrado == null) {
			result.notFound();
		} else {
			result.include(livroEncontrado);
			result.of(this).formulario();
		}
	}
}
