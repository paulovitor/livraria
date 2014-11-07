package br.com.paulovitor.livraria.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.paulovitor.livraria.servico.Acervo;

@Controller
public class HomeController {

	private Acervo acervo;
	private Result result;

	@Inject
	public HomeController(Acervo acervo, Result result) {
		this.acervo = acervo;
		this.result = result;
	}

	@Deprecated
	HomeController() {
	}

	public void inicio() {
		result.include("livros", acervo.todosOsLivros());
	}

}
