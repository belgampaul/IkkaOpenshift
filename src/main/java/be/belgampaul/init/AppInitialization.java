package be.belgampaul.init;

import be.belgampaul.config.PropertyFiles;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

/**
 * @author ikka
 * @date: 29.07.2015.
 */
public class AppInitialization {
  public static void initSystemProperties() {
    Properties properties = new Properties();
    try {
      properties.load(AppInitialization.class.getResourceAsStream("/" + PropertyFiles.DB_PROPERTIES.getFileName()));
      for (Map.Entry<Object, Object> property : properties.entrySet()) {
        System.setProperty(String.valueOf(property.getKey()), String.valueOf(property.getValue()));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
