package br.com.paulovitor.livraria.interceptor;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;

import br.com.caelum.vraptor.BeforeCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.paulovitor.livraria.modelo.Usuario;

@Intercepts
public class AuditoriaInterceptor {

	private @Inject Logger logger;
	private @Inject Usuario usuario;
	private @Inject HttpServletRequest request;

	@BeforeCall
	public void loga() {
		logger.info("O usuário {} acessou {}", usuario.getLogin(),
				request.getRequestURI());
	}

}
