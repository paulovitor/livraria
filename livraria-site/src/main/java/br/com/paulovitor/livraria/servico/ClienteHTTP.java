package br.com.paulovitor.livraria.servico;

import br.com.paulovitor.livraria.excetion.ServidorIndisponivelException;

public interface ClienteHTTP {

	String get(String url) throws ServidorIndisponivelException;
	
}
