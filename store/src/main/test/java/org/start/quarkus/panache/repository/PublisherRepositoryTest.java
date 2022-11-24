package org.start.quarkus.panache.repository;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.start.quarkus.panache.model.Publisher;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class PublisherRepositoryTest {
    @Test
    @TestTransaction
    public void shoultCreateAndFindPublisher(){
        Publisher publisher = new Publisher("name");
        Publisher.persist(publisher);
        assertNotNull(publisher.id);

        publisher = Publisher.findById(publisher.id);

        assertEquals("name", publisher.name);
    }
}
