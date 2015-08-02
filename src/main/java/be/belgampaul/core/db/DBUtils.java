package be.belgampaul.core.db;

import java.net.PasswordAuthentication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author ikka
 * @date: 15.07.2015.
 */
public class DBUtils {
  public static Connection getConnection(String url, String username, String password) throws SQLException {
    return DriverManager.getConnection(url, username, password);
  }

  public static Connection getConnection(String url, PasswordAuthentication passwordAuthentication) throws SQLException {
    return getConnection(url, passwordAuthentication.getUserName(), new String(passwordAuthentication.getPassword()));
  }
}
