package org.start.quarkus.panache.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;
import org.start.quarkus.panache.entitylegacy.Customer;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class CustomerRepository implements PanacheRepository<Customer> {

    public List<Customer> listAllDans() {
        return list("name = 'Dan'", Sort.by("lastName"));
    }
}
