package org.start.quarkus.panache.repository;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.start.quarkus.panache.entitylegacy.Customer;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class CustomerRepositoryTest {
    @Inject
    CustomerRepository customerRepository;

    @Test
    @TestTransaction
    public void shouldCreateAndFindACustomer(){
        Customer customer = new Customer("name","last name", "email");
        customerRepository.persist(customer);
        assertNotNull(customer.getId());

        Customer customer1 = customerRepository.findById(customer.getId());
        assertEquals("last name", customer1.getLastName());
    }

}
