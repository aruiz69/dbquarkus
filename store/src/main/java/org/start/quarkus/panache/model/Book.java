package org.start.quarkus.panache.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "t_book")
public class Book extends Item{
    @Column(length = 15)
    public String isbn;
    @Column(name = "nb_of_pages")
    public Integer nbOfPages;
    @Column(name = "publication_date")
    public LocalDate publicationDate;
    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    public Language language;
    @ManyToOne
    @JoinColumn(name = "publisher_fk")
    public Publisher publisher;
}
