package be.belgampaul.init;

import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * @author ikka
 * @date: 29.07.2015.
 */
@SuppressWarnings("unused")
@Startup
@Singleton
public class Initialization {
  private static Logger log = Logger.getLogger(Initialization.class);

  @PostConstruct
  private void startup() {
    log.info("Initializing application");
    AppInitialization.initSystemProperties();
  }
}
