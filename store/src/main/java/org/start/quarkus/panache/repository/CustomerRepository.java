package org.start.quarkus.panache.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.start.quarkus.panache.entitylegacy.Customer;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CustomerRepository implements PanacheRepository<Customer> {
}
