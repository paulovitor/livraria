package br.com.paulovitor.livraria.modelo;

import java.util.List;

public interface Estante {

	void guarda(Livro livro);
	
	List<Livro> todosOsLivros();

	Livro buscaPorIsbn(String isbn);
}
