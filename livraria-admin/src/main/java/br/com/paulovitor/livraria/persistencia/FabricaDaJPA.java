package br.com.paulovitor.livraria.persistencia;

//import javax.enterprise.context.ApplicationScoped;
//import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;

public class FabricaDaJPA {
	
// Gerenciando pelo Wildfly	
	@PersistenceContext
	private EntityManager manager;

	@Produces
	public EntityManager getManager() {
		return manager;
	}

// Gerenciando pelo CDI
//	@Produces
//	@ApplicationScoped
//	public EntityManagerFactory criaEntityManagerFactory() {
//		return Persistence.createEntityManagerFactory("default");
//	}
//
//	@Produces
//	public EntityManager criaEntityManager(EntityManagerFactory factory) {
//		return factory.createEntityManager();
//	}
//
//	public void fechaManager(@Disposes EntityManager manager) {
//		manager.close();
//	}
//
//	public void fechaFactory(@Disposes EntityManagerFactory factory) {
//		factory.close();
//	}

}
