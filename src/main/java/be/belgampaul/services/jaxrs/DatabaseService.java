package be.belgampaul.services.jaxrs;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@Path("/db")
@Consumes({"application/json"})
@Produces({"application/json"})
public class DatabaseService {

  @GET
  @Path("/properties")
  public Map<String, String> getProperties() {
    Properties properties = System.getProperties();
    Set<Map.Entry<Object, Object>> entries = properties.entrySet();
    Map<String, String> props = new HashMap<>();

    entries.stream().parallel().forEach(e -> props.put(e.getKey().toString(), e.getValue().toString()));
    return props;
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
