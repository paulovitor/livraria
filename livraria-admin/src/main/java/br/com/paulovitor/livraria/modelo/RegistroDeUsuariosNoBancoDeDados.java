package br.com.paulovitor.livraria.modelo;

import javax.inject.Inject;

import br.com.paulovitor.livraria.persistencia.UsuarioDAO;

public class RegistroDeUsuariosNoBancoDeDados implements RegistroDeUsuarios {

	private UsuarioDAO dao;

	@Inject
	public RegistroDeUsuariosNoBancoDeDados(UsuarioDAO dao) {
		this.dao = dao;
	}

	@Deprecated
	RegistroDeUsuariosNoBancoDeDados() {
	}

	@Override
	public Usuario comLoginESenha(String login, String senha) {
		return dao.buscaPorLoginESenha(login, senha);
	}

}
