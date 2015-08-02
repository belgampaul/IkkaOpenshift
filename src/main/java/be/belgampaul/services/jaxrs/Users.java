package be.belgampaul.services.jaxrs;

import be.belgampaul.config.DBProperty;
import be.belgampaul.core.db.DBUtils;
import be.belgampaul.core.db.exceptions.InvalidConnectionStringSyntaxException;
import be.belgampaul.core.db.rdbms.postgresql.PostgreSqlJdbcUrl;
import be.belgampaul.db.DB;
import be.belgampaul.entities.User;

import javax.ws.rs.*;
import java.net.PasswordAuthentication;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author ikka
 * @date: 28.07.2015.
 */
@Path("/users")
@Consumes({"application/json"})
@Produces({"application/json"})
public class Users {

  @GET
  @Path("/list")
  public Collection<User> getUsers() {
    ArrayList<User> users = new ArrayList<>();

    try {
      try (Connection con = DB.getConnection()) {
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT id, username FROM users");
        while (resultSet.next()) {
          User user = new User();
          users.add(user);
          String username1 = resultSet.getString("username");
          long id = resultSet.getLong("id");
          user.setUsername(username1);
          user.setId(id);
        }
      }
    } catch (InvalidConnectionStringSyntaxException | SQLException e) {
      e.printStackTrace();
    }
    return users;
  }

  //  @GET
  //  @Path("/book/{isbn}")
  //  public Book getBook(@PathParam("isbn") String id) {
  //    return Book.newBook(id, "er", "er");
  //  }
  //
  //  @PUT
  //  @Path("/book/{isbn}")
  //  public Book addBook(@PathParam("isbn") String id, @QueryParam("title") String title) {
  //    return Book.newBook(id, id, title);
  //  }
  //
  //  @POST
  //  @Path("/book/{isbn}")
  //  public Book updateBook(@PathParam("isbn") String id, String title) {
  //    return Book.newBook(id, "er", "er");
  //  }
  //
  //  @DELETE
  //  @Path("/book/{isbn}")
  //  public Book removeBook(@PathParam("isbn") String id) {
  //    return Book.newBook(id, "er", "er");
  //  }
}
