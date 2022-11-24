package org.start.quarkus.panache.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Instant;
import java.util.Optional;

@Entity
@Table(name = "t_publishers")
public class Publisher extends PanacheEntity {
    @Column(length = 50, nullable = false)
    public String name;
    @Column(name = "create_date", nullable = false)
    public Instant createdDate = Instant.now();

    public Publisher() {
    }

    public Publisher(String name) {
        this.name = name;
    }
    //Custom queries
    public static Optional<Publisher> findByName(String name){
        return Publisher.find("name", name).firstResultOptional();
    }
}
