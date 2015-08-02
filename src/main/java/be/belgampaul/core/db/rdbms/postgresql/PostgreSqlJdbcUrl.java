package be.belgampaul.core.db.rdbms.postgresql;

import be.belgampaul.core.db.rdbms.api.JdbcUrl;

/**
 * Default implemetation of JdbcUrl for PostgreSQL RDBMS
 * src:https://jdbc.postgresql.org/documentation/80/connect.html
 * <p>
 * /**
 * Connecting to the Database
 * <p>
 * With JDBC, a database is represented by a URL (Uniform Resource Locator). With PostgreSQL™, this takes one of the following forms:
 * <p>
 * jdbc:postgresql:database
 * jdbc:postgresql://host/database
 * jdbc:postgresql://host:port/database
 * The parameters have the following meanings:
 * host
 * The host name of the server. Defaults to localhost. To specify an IPv6 address your must enclose the host parameter with square brackets, for example:
 * <p>
 * jdbc:postgresql://[::1]:5740/accounting
 * port
 * The port number the server is listening on. Defaults to the PostgreSQL™ standard port number (5432).
 * <p>
 * database
 * The database name.
 * <p>
 * To connect, you need to get a Connection instance from JDBC. To do this, you use the DriverManager.getConnection() method:
 * <p>
 * Connection db = DriverManager.getConnection(url, username, password);
 * <p>
 * Connection Parameters
 * <p>
 * In addition to the standard connection parameters the driver supports a number of additional properties which can be used to specify additional driver behavior specific to PostgreSQL™. These properties may be specified in either the connection URL or an additional Properties object parameter to DriverManager.getConnection. The following examples illustrate the use of both methods to establish a SSL connection.
 * <p>
 * String url = "jdbc:postgresql://localhost/test";
 * Properties props = new Properties();
 * props.setProperty("user","fred");
 * props.setProperty("password","secret");
 * props.setProperty("ssl","true");
 * Connection conn = DriverManager.getConnection(url, props);
 * String url = "jdbc:postgresql://localhost/test?user=fred&password=secret&ssl=true";
 * Connection conn = DriverManager.getConnection(url);
 *
 * @author ikka
 * @date: 17.07.2015.
 */

public interface PostgreSqlJdbcUrl extends JdbcUrl {

  /**
   * The port number the server is listening on. Defaults to the PostgreSQL™ standard port number (5432)
   */
  int DEFAULT_PORT = 5432;

  String DEFAULT_PREFIX = "jdbc:postgresql:";


  @Override
  default Integer getDefaultPort() {
    return DEFAULT_PORT;
  }

  @Override
  default String getDefaultPrefix() {
    return DEFAULT_PREFIX;
  }
}
