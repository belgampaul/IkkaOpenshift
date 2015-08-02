package be.belgampaul.config;

/**
 * @author ikka
 * @date: 29.07.2015.
 */
public enum PropertyFiles {
  DB_PROPERTIES("db.properties");

  private final String fileName;

  PropertyFiles(String fileName) {
    this.fileName = fileName;
  }

  public String getFileName() {
    return fileName;
  }
}
