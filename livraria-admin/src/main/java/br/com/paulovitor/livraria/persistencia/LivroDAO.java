package br.com.paulovitor.livraria.persistencia;

import java.util.List;

import br.com.paulovitor.livraria.modelo.Livro;

public interface LivroDAO {

	void adiciona(Livro livro);

	List<Livro> todos();

	Livro buscaPorIsbn(String isbn);

	Livro buscaLivroPorTitulo(String titulo);

}
