package be.belgampaul.core.db.rdbms.api;

import be.belgampaul.core.db.exceptions.InvalidConnectionStringSyntaxException;

/**
 * @author ikka
 * @date: 15.07.2015.
 */
public interface JdbcUrl {
  String LOCALHOST = "localhost";

  /**
   * The host name of the server. Defaults to localhost
   *
   * @return {@link #LOCALHOST}
   */
  default String getHost() {
    return LOCALHOST;
  }

  /**
   * @return the port number the server is listening on.
   */
  default Integer getPort() {
    return getDefaultPort();
  }

  String getDefaultPrefix();

  String getDatabase();

  default String getConnectionString() throws InvalidConnectionStringSyntaxException {
    String host = getHost();
    Integer port = getPort();
    String database = getDatabase();
    if (host == null || port == null || database == null) {
      throw new InvalidConnectionStringSyntaxException();
    }
    return getDefaultPrefix() + "//" + host + ":" + port + "/" + database;
  }

  Integer getDefaultPort();

}
