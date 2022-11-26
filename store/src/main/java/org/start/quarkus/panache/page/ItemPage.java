package org.start.quarkus.panache.page;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import io.quarkus.panache.common.Sort;
import io.quarkus.qute.TemplateInstance;
import io.quarkus.qute.CheckedTemplate;
import org.start.quarkus.panache.model.Book;
import org.start.quarkus.panache.model.CD;

import java.util.List;


@Path("/page/items")
@Produces(MediaType.TEXT_HTML)
@ApplicationScoped
public class ItemPage {
    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance book(Book book);

        public static native TemplateInstance books(List<Book> books);

        public static native TemplateInstance cd(CD cd);

        public static native TemplateInstance cds(List<CD> cds);
    }

    @GET
    @Path("/books/{id}")
    public TemplateInstance showBookById(@PathParam("id") Long id) {
        return Templates.book(Book.findById(id));
    }

    @GET
    @Path("/books")
    public TemplateInstance showBookById(@QueryParam("query") String query,
                                         @QueryParam("sort") @DefaultValue("id") String sort,
                                         @QueryParam("page") @DefaultValue("0") Integer pageIndex,
                                         @QueryParam("size") @DefaultValue("1000") Integer pageSize) {

        return Templates.books(Book.find(query, Sort.by(sort)).page(pageIndex, pageSize).list());
        //http://localhost:8080/page/items/books?query=nbOfPages>100&sort=tite&size=10&page=2
    }

    @GET
    @Path("/cds/{id}")
    public TemplateInstance showCdById(@PathParam("id") Long id) {
        return Templates.cd(CD.findById(id));
    }

    @GET
    @Path("/cds")
    public TemplateInstance showCdById() {
        return Templates.cds(CD.listAll());
    }
}
