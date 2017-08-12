package br.com.cominotti.olympics_api.server.infrastructure.configuration;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.TransactionScoped;

@ApplicationScoped
public class PersistenceConfiguration {

    @PersistenceUnit(unitName = "OlympicsPU")
    private EntityManagerFactory entityManagerFactory;


    @Produces
    @TransactionScoped
    public EntityManager create() {
        return entityManagerFactory.createEntityManager();
    }

    public void close(@Disposes final EntityManager em) {
        if (em.isOpen()) {
            em.close();
        }
    }
}
