package org.start.quarkus.panache.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.start.quarkus.panache.pojo.Artist;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "t_items")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Item extends PanacheEntity {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Column(length = 100, nullable = false)
    public String title;

    @Column(length = 3000)
    public String description;

    @Column(nullable = false)
    public BigDecimal price;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "artist_fk")
    public Artist artist;

    @Column(name = "created_date", nullable = false)
    public Instant createdDate = Instant.now();
}