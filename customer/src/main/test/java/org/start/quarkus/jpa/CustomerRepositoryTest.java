package org.start.quarkus.jpa;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class CustomerRepositoryTest {
    @Inject
    CustomerRepository customerRepository;

    @Test
    public void shouldCreateAndFindACustomer(){
        Customer customer = new Customer("name","last name", "email");
        customerRepository.persist(customer);
        assertNotNull(customer.getId());

        Customer customer1 = customerRepository.findById(customer.getId());
        assertEquals("last name", customer1.getLastName());
    }

}
