package org.start.quarkus.panache.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_compact_disk")
public class CD extends Item{
    @Column(name = "music_company")
    public String musicCompany;
    @Column(length = 100)
    public String genre;
}
