package org.start.quarkus.panache.repository;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.start.quarkus.panache.entitylegacy.Customer;
import org.start.quarkus.panache.model.*;
import org.start.quarkus.panache.pojo.Artist;

import javax.inject.Inject;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class PurchaseOrderRepositoryTest {
    @Inject
    CustomerRepository customerRepository;
    @Test
    @TestTransaction
    public void shouldCreateAndFindAPurchaseOrder() {
        // Create an artist
        Artist artist = new Artist("artist name", "artisti bio");
        //Create an Publisher
        Publisher publisher= new Publisher("publisher name");
        //Crate a Book
        Book book = new Book();
        book.title = "title of the book";
        book.nbOfPages = 500;
        book.language = Language.ENGLISH;
        book.price = BigDecimal.valueOf(12.50);
        book.isbn = "isbn";
        //Sets the relationship
        book.publisher = publisher;
        book.artist = artist;
        // Persits Book
        Book.persist(book);

        //Create a Customer
        Customer customer = new Customer("name", "lastName",  "customer@email.com");
        customerRepository.persist(customer);

        // Create an order linbe
        OrderLine orderLine = new OrderLine();
        orderLine.item = book;
        orderLine.quantity = 2;

        //Create a Purchase Order
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.customer = customer;
        purchaseOrder.addOrderLine(orderLine);
        orderLine.purchaseOrder = purchaseOrder;

        PurchaseOrder.persist(purchaseOrder);

    }

}
