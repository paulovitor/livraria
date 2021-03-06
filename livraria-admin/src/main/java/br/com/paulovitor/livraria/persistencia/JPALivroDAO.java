package br.com.paulovitor.livraria.persistencia;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import br.com.paulovitor.livraria.modelo.Livro;

@Transactional
// Gerenciando pelo Wildfly
public class JPALivroDAO implements LivroDAO {

	private final EntityManager manager;

	@Inject
	public JPALivroDAO(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @deprecated para o CDI
	 */
	JPALivroDAO() {
		this(null);
	}

	@Override
	public void adiciona(Livro livro) {
		if (livro.getId() == null) {
			this.manager.persist(livro);
		} else {
			this.manager.merge(livro);
		}
	}

	@Override
	public List<Livro> todos() {
		return this.manager.createQuery("select l from Livro l", Livro.class)
				.getResultList();
	}

	@Override
	public Livro buscaPorIsbn(String isbn) {
		try {
			return this.manager
					.createQuery("select l from Livro l where l.isbn = :isbn",
							Livro.class).setParameter("isbn", isbn)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Livro buscaLivroPorTitulo(String titulo) {
		try {
			return this.manager
					.createQuery(
							"select l from Livro l where l.titulo = :titulo",
							Livro.class).setParameter("titulo", titulo)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public void remove(Livro livro) {
		this.manager.remove(this.manager.getReference(Livro.class,
				livro.getId()));
	}

}
