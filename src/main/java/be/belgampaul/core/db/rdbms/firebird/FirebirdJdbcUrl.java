package be.belgampaul.core.db.rdbms.firebird;

import be.belgampaul.core.db.rdbms.api.JdbcUrl;

/**
 * src:
 * http://www.firebirdsql.org/file/documentation/drivers_documentation/java/faq.html#jdbc-urls-java.sql.drivermanager
 *
 * @author ikka
 * @date: 15.07.2015.
 */
public interface FirebirdJdbcUrl extends JdbcUrl {
  int DEFAULT_PORT = 3050;
  String DEFAULT_PREFIX = "jdbc:firebirdsql:";


  @Override
  default Integer getDefaultPort() {
    return DEFAULT_PORT;
  }

  @Override
  default String getDefaultPrefix() {
    return DEFAULT_PREFIX;
  }
}
