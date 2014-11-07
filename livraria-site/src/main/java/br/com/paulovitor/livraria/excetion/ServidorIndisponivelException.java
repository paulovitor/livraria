package br.com.paulovitor.livraria.excetion;

import java.io.IOException;

public class ServidorIndisponivelException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ServidorIndisponivelException(String url, IOException e) {
		super("Erro ao fazer requisição ao servidor na url" + url, e);
	}

}
