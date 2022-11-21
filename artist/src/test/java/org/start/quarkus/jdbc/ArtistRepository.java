package org.start.quarkus.jdbc;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.*;
import java.util.Random;

@ApplicationScoped
public class ArtistRepository {

    @Inject
    DataSource dataSource;

    public void persist(Artist artist) throws SQLException{
        Connection conn = dataSource.getConnection();
        String sql = "INSERT INTO t_artists (id, name, bio, created_date) VALUES (?, ?, ?, ?)";
        artist.setId(Math.abs(new Random().nextLong()));
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setLong(1, artist.getId());
            ps.setString(2, artist.getName());
            ps.setString(3, artist.getBio());
            ps.setTimestamp(4, Timestamp.from(artist.getCreatedDate()));
            ps.execute();
        }
    }

    public Artist findByIf (Long id) throws SQLException {
        Connection conn = dataSource.getConnection();
        String sql = "SELECT id, name, bio, created_date FROM t_artists WHERE id = ?";
        Artist artist = null;
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setLong(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                artist = new Artist(rs.getLong("id"), rs.getString("name"),
                        rs.getString("bio"), rs.getTimestamp("created_date").toInstant());

            }
        }
        return artist;
    }
}
