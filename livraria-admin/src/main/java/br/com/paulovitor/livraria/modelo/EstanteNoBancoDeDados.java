package br.com.paulovitor.livraria.modelo;

import java.util.List;

import javax.inject.Inject;

import br.com.paulovitor.livraria.persistencia.LivroDAO;

// @Component ?
public class EstanteNoBancoDeDados implements Estante {

	private final LivroDAO dao;

	@Inject
	public EstanteNoBancoDeDados(LivroDAO dao) {
		this.dao = dao;
	}

	/**
	 * @deprecated para o CDI
	 */
	EstanteNoBancoDeDados() {
		this(null);
	}

	@Override
	public void guarda(Livro livro) {
		this.dao.adiciona(livro);
	}

	@Override
	public List<Livro> todosOsLivros() {
		return this.dao.todos();
	}

	@Override
	public Livro buscaPorIsbn(String isbn) {
		return this.dao.buscaPorIsbn(isbn);
	}

	@Override
	public boolean existeLivroComTitulo(String titulo) {
		return this.dao.buscaLivroPorTitulo(titulo) != null;
	}

}
