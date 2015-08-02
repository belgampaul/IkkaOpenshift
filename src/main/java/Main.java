import be.belgampaul.config.DBProperty;
import be.belgampaul.config.PropertyFiles;
import be.belgampaul.core.db.DBUtils;
import be.belgampaul.core.db.exceptions.InvalidConnectionStringSyntaxException;
import be.belgampaul.core.db.rdbms.postgresql.PostgreSqlJdbcUrl;

import java.io.File;
import java.io.IOException;
import java.net.PasswordAuthentication;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author ikka
 * @date: 28.07.2015.
 */
public class Main {
  public static void main(String[] args) {
    //    processWildFlyDependencies();
    initSystemProperties();

    PostgreSqlJdbcUrl postgreSqlJdbcUrl = () -> System.getProperty(DBProperty.DATABASE.propertyName());

    try {
      String conString = postgreSqlJdbcUrl.getConnectionString();
      String username = DBProperty.USERNAME.propertyName();
      String password = System.getProperty(DBProperty.PASSWORD.propertyName());
      PasswordAuthentication passwordAuthentication = new PasswordAuthentication(System.getProperty(username), password.toCharArray());

      try (Connection con = DBUtils.getConnection(conString, passwordAuthentication)) {
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("select username from users");
        while (resultSet.next()) {
          System.out.println(resultSet.getString("username"));
        }
      }
    } catch (InvalidConnectionStringSyntaxException | SQLException e) {
      e.printStackTrace();
    }
  }

  private static void initSystemProperties() {
    Properties properties = new Properties();
    try {
      properties.load(Main.class.getResourceAsStream("/" + PropertyFiles.DB_PROPERTIES.getFileName()));
      for (Map.Entry<Object, Object> property : properties.entrySet()) {
        System.setProperty(String.valueOf(property.getKey()), String.valueOf(property.getValue()));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void processWildFlyDependencies() {
    File file = new File("D:/tmp/1.txt");
    try {
      ArrayList<String> outStrings = new ArrayList<>();
      List<String> strings = Files.readAllLines(file.toPath());

      for (String string : strings) {
        if (string.contains("<version>")) {
          continue;
        }
        outStrings.add(string);
      }

      Files.write(new File("D:/tmp/11.txt").toPath(), outStrings, StandardOpenOption.CREATE_NEW, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);


    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
