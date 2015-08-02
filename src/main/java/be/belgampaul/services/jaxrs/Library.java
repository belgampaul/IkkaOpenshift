package be.belgampaul.services.jaxrs;

import javax.ws.rs.*;

import java.util.Collection;

@Path("/library")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class Library {

  @GET
  @Path("/books")
  public Collection<Book> getBooks() {
    return null;
  }

  @GET
  @Path("/book/{isbn}")
  public Book getBook(@PathParam("isbn") String id) {
    return Book.newBook(id, "er", "er");
  }

  @PUT
  @Path("/book/{isbn}")
  public Book addBook(@PathParam("isbn") String id, @QueryParam("title") String title) {
    return Book.newBook(id, id, title);
  }

  @POST
  @Path("/book/{isbn}")
  public Book updateBook(@PathParam("isbn") String id, String title) {
    return Book.newBook(id, "er", "er");
  }

  @DELETE
  @Path("/book/{isbn}")
  public Book removeBook(@PathParam("isbn") String id) {
    return Book.newBook(id, "er", "er");
  }
}
