package org.start.quarkus.jdbc;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;
@QuarkusTest
public class ArtistRepositoryTest {
    @Inject
    ArtistRepository artistRepository;

    @Test
    public void shouldCreateAndFindAnArtist()throws SQLException {
        Artist artist = new Artist();
        artist.setName("name");
        artist.setBio("bio");
        artistRepository.persist(artist);
        assertNotNull(artist.getId());

        artist = artistRepository.findByIf(artist.getId());
        assertEquals("name", artist.getName());
    }
}
