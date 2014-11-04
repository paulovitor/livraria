package br.com.paulovitor.livraria.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.paulovitor.livraria.modelo.Estante;
import br.com.paulovitor.livraria.modelo.Livro;

@Controller
public class LivrosController {

	private Estante estante;

	@Inject
	public LivrosController(Estante estante) {
		this.estante = estante;
	}

	/**
	 * @deprecated Apenas para o CDI. Não precisa ser público
	 */
	LivrosController() {
	}

	public void formulario() {
	}

	public void salva(Livro livro, Result result) {
		estante.guarda(livro);

		result.include("mensagem", "Livro salvo com sucesso!");
		result.redirectTo(this).lista();
	}

	public List<Livro> lista() {
		return estante.todosOsLivros();
	}

	public void edita(String isbn, Result result) {
		Livro livroEncontrado = estante.buscaPorIsbn(isbn);
		result.include(livroEncontrado);
		result.of(this).formulario();
	}
}
