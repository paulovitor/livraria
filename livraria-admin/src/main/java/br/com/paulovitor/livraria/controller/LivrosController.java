package br.com.paulovitor.livraria.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
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

	public void formulario() {
	}

	public void salva(Livro livro) {
		validator.validate(livro);
		validator.onErrorRedirectTo(this).formulario();

		estante.guarda(livro);

		result.include("mensagem", "Livro salvo com sucesso!");
		result.redirectTo(this).lista();
	}

	public List<Livro> lista() {
		return estante.todosOsLivros();
	}

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
