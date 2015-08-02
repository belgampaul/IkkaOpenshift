package be.belgampaul.config;

/**
 * @author ikka
 * @date: 29.07.2015.
 */
public enum DBProperty implements Property{
  HOST,
  PORT,
  DATABASE,
  USERNAME,
  PASSWORD;

  private static final String PROPERTY_PREFIX = "db";


  public String propertyName() {
    return PROPERTY_PREFIX + PROPERTY_SEPARATOR +  name().toLowerCase();
  }
}
