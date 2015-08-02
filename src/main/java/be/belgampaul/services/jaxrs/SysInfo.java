package be.belgampaul.services.jaxrs;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import java.util.*;

@Path("/sysinfo")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class SysInfo {

  @GET
  @Path("/properties")
  @RolesAllowed({"admin", "a"})
  public Map<String, String> getProperties() {
    Properties properties = System.getProperties();
    Set<Map.Entry<Object, Object>> entries = properties.entrySet();
    Map<String, String> props = new HashMap<>();

    entries.stream().parallel().forEach(e -> props.put(e.getKey().toString(), e.getValue().toString()) );
    return props;
  }
}
