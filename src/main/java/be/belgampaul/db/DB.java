package be.belgampaul.db;

import be.belgampaul.config.DBProperty;
import be.belgampaul.core.db.DBUtils;
import be.belgampaul.core.db.exceptions.InvalidConnectionStringSyntaxException;
import be.belgampaul.core.db.rdbms.api.JdbcUrl;
import be.belgampaul.core.db.rdbms.postgresql.PostgreSqlJdbcUrl;

import java.net.PasswordAuthentication;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author ikka
 * @date: 29.07.2015.
 */
public class DB {
  private static JdbcUrl jdbcUrl = (PostgreSqlJdbcUrl) () -> System.getProperty(DBProperty.DATABASE.propertyName());
  private static PasswordAuthentication passwordAuthentication = new PasswordAuthentication(System.getProperty(DBProperty.USERNAME.propertyName()), System.getProperty(DBProperty.PASSWORD.propertyName()).toCharArray());

  public static Connection getConnection() throws InvalidConnectionStringSyntaxException, SQLException {
    return DBUtils.getConnection(jdbcUrl.getConnectionString(), passwordAuthentication);
  }
}
