package br.com.paulovitor.livraria.persistencia;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import br.com.paulovitor.livraria.modelo.Usuario;

@Transactional
public class JPAUsuarioDAO implements UsuarioDAO {

	private EntityManager manager;

	@Inject
	public JPAUsuarioDAO(EntityManager manager) {
		this.manager = manager;
	}

	@Deprecated
	JPAUsuarioDAO() {
		this(null);
	}

	@Override
	public Usuario buscaPorLoginESenha(String login, String senha) {
		try {
			return this.manager
					.createQuery(
							"select u from Usuario u where u.login = :login and u.senha = :senha",
							Usuario.class).setParameter("login", login)
					.setParameter("senha", senha).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
