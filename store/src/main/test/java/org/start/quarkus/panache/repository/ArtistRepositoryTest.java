package org.start.quarkus.panache.repository;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.start.quarkus.panache.pojo.Artist;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class ArtistRepositoryTest {
    @Inject
    ArtistRepository artistRepository;

    @Test
    @TestTransaction
    public void shouldCreateAndFindAnArtist() {
        Artist artist = new Artist();
        artist.setName("name");
        artist.setBio("bio");

        artistRepository.persist(artist);
        assertNotNull(artist.getId());

        artist = artistRepository.findById(artist.getId());
        assertEquals("name", artist.getName());

    }
}
