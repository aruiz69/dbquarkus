package org.start.quarkus.panache.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.start.quarkus.panache.pojo.Artist;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ArtistRepository implements PanacheRepository<Artist> {
}
