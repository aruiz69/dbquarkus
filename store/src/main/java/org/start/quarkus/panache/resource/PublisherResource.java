package org.start.quarkus.panache.resource;

import io.quarkus.panache.common.Sort;
import org.start.quarkus.panache.model.Publisher;
import org.start.quarkus.panache.pojo.Artist;
import org.start.quarkus.panache.repository.ArtistRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Path("/api/publisher")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PublisherResource {


    @GET
    @Path("{id}")
    public Publisher findPublisherId(@PathParam("id") Long id){
        return (Publisher) Publisher.findByIdOptional(id).orElseThrow(NotFoundException::new);
    }

    @GET
    public List<Publisher> findAllPublisher(){
        return Publisher.listAll();
    }

    @POST
    @Transactional(Transactional.TxType.REQUIRED)
    public Response persistPublisher(Artist artist, @Context UriInfo uriInfo) {
        Publisher.persist(artist);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(Long.toString(artist.getId()));
        return Response.created(builder.build()).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void deletePublisher(@PathParam("id") Long id){
        Publisher.deleteById(id);
    }

}
