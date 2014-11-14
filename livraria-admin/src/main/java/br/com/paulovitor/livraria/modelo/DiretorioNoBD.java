package br.com.paulovitor.livraria.modelo;

import java.net.URI;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.jboss.weld.exceptions.IllegalArgumentException;

public class DiretorioNoBD implements Diretorio {

	private EntityManager manager;

	@Inject
	public DiretorioNoBD(EntityManager manager) {
		this.manager = manager;
	}

	@Deprecated
	DiretorioNoBD() {
	}

	@Transactional
	@Override
	public URI grava(Arquivo arquivo) {
		manager.persist(arquivo);
		return URI.create("bd://" + arquivo.getId());
	}

	@Override
	public Arquivo recupera(URI chave) {
		if (chave == null)
			return null;

		if (!chave.getScheme().equals("bd")) {
			throw new IllegalArgumentException(chave
					+ " não é uma URI de banco de dados");
		}

		Long id = Long.valueOf(chave.getAuthority());
		return manager.find(Arquivo.class, id);
	}

}
