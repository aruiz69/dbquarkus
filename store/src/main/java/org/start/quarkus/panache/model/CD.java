package org.start.quarkus.panache.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CD extends Item{
    @Column(name = "music_company")
    public String musicCompany;
    @Column(length = 100)
    public String genre;
    @OneToMany(mappedBy = "cd", cascade = {CascadeType.REMOVE, CascadeType.PERSIST}, orphanRemoval = true)
    public List<Track> tracks = new ArrayList<>();

    // ======================================
    // =            Constructors            =
    // ======================================

    public CD() {
    }

    public CD(String title, String description, BigDecimal price, String genre) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.genre = genre;
    }
    public void addTrack(Track track) {
        tracks.add(track);
        track.cd = this;
    }

    public void removeTrack(Track track) {
        tracks.remove(track);
        track.cd = null;
    }
}
