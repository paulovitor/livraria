package br.com.paulovitor.livraria.validador;

import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.paulovitor.livraria.modelo.Estante;
import br.com.paulovitor.livraria.modelo.Livro;

public class LivroValidator {

	private Validator validator;
	private Estante estante;

	public LivroValidator(Validator validator, Estante estante) {
		this.validator = validator;
		this.estante = estante;
	}

	public void validate(Livro livro) {
		validator.validate(livro);

		if (estante.existeLivroComTitulo(livro.getTitulo())) {
			validator.add(new I18nMessage("titulo", "ja.existe"));
		}
	}
	
	public <T> T onErrorRedirectTo(T controller) {
		return validator.onErrorRedirectTo(controller);
	}

}
