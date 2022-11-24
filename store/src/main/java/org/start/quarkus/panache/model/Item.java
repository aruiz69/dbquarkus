package org.start.quarkus.panache.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.start.quarkus.panache.pojo.Artist;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "t_items")
@Inheritance(strategy = InheritanceType.JOINED)
public class Item extends PanacheEntity {
    @Column(length = 100, nullable = false)
    public String title;
    @Column(length = 300)
    public String description;
    @Column(nullable = false)
    public BigDecimal price;
    @Column(name = "created_date")
    public Instant createdDate = Instant.now();
    @ManyToOne
    @JoinColumn(name="artis_fk")
    public Artist artist;
}
