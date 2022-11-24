package org.start.quarkus.panache.repository;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.start.quarkus.panache.model.Publisher;

import javax.persistence.EntityExistsException;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class PublisherRepositoryTest {
    @Test
    @TestTransaction
    public void shoultCreateAndFindPublisher(){
        long count = Publisher.count();
        int listAll = Publisher.listAll().size();

        Publisher publisher = new Publisher("name");
        Publisher.persist(publisher);
        assertNotNull(publisher.id);

        assertEquals(count+1, Publisher.count());

        publisher = Publisher.findById(publisher.id);

        publisher = Publisher.findByName("name").orElseThrow(EntityExistsException::new);

        assertEquals("name", publisher.name);

        Publisher.deleteById(publisher.id);
        assertEquals(count, Publisher.count());

    }
}
