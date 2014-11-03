package br.com.paulovitor.livraria.controller;

import java.util.List;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.paulovitor.livraria.modelo.Estante;
import br.com.paulovitor.livraria.modelo.Livro;
import br.com.paulovitor.livraria.modelo.UmaEstanteQualquer;

@Controller
public class LivrosController {

	public void formulario() {
	}

	public void salva(Livro livro, Result result) {
		Estante estante = new UmaEstanteQualquer();
		estante.guarda(livro);
		
		result.include("mensagem", "Livro salvo com sucesso!");
		result.redirectTo(this).lista();
	}

	public List<Livro> lista() {
		Estante estante = new UmaEstanteQualquer();
		return estante.todosOsLivros();
	}
	
	public void edita(String isbn, Result result) {
		Estante estante = new UmaEstanteQualquer();
		Livro livroEncontrado = estante.buscaPorIsbn(isbn);
		result.include(livroEncontrado);
		result.of(this).formulario();
	}
}
