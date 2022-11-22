package org.start.quarkus.jpa;



import io.quarkus.hibernate.orm.PersistenceUnit;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

@ApplicationScoped
public class CustomerRepository {
    @Inject
    Logger logger;
    @Inject
    EntityManager em;
    @Transactional
    public void persist(Customer customer){
       em.persist(customer);
        logger.info("Find Customer Id ->" + customer.getId());
    }

    public Customer findById(Long id){
        logger.info("Find Customer" + em.find(Customer.class, id));
        return em.find(Customer.class, id);
    }

}
