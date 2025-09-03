package pe.com.relari.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;
import pe.com.relari.config.ErrorProperties;

@Path("/v1")
public class DemoResource {
    
    private static final Logger log = Logger.getLogger(DemoResource.class);

    ErrorProperties errorProperties;

    @ConfigProperty(name = "greeting.message")
    String message;

    @Inject
    public DemoResource(ErrorProperties errorProperties) {
        this.errorProperties = errorProperties;
    }

    @GET
    @Path("/greeting")
    @Produces(MediaType.TEXT_PLAIN)
    public String greeting(
            @Context HttpHeaders headers) {
        log.info(headers.getHeaderString("Authorization"));
        log.info(String.format("errorMessage=%s, status=%s", errorProperties.defaultMessage(), errorProperties.status()));
        return message;
    }

}
