package org.start.quarkus.panache.resource;

import io.quarkus.panache.common.Sort;
import org.start.quarkus.panache.pojo.Artist;
import org.start.quarkus.panache.repository.ArtistRepository;

import javax.inject.Inject;
import javax.print.attribute.standard.MediaName;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Path("/api/artists")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ArtistResource {
    @Inject
    ArtistRepository artistRepository;

    @GET
    @Path("{id}")
    public Artist findArtistById(@PathParam("id") Long id){
        return artistRepository.findByIdOptional(id).orElseThrow(NotFoundException::new);
    }

    @GET
    public List<Artist> findAllArtist(){
        return artistRepository.listAll(Sort.ascending("name"));
    }

    @POST
    @Transactional(Transactional.TxType.REQUIRED)
    public Response persistArtist(Artist artist, @Context UriInfo uriInfo) {
        artistRepository.persist(artist);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(Long.toString(artist.getId()));
        return Response.created(builder.build()).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void deleteArtist(@PathParam("id") Long id){
        artistRepository.deleteById(id);
    }


}
