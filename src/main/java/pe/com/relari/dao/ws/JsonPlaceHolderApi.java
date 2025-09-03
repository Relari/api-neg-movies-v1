package pe.com.relari.dao.ws;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import pe.com.relari.config.RequestUUIDHeaderFactory;
import pe.com.relari.dao.ws.model.UserResponse;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/users")
@ApplicationScoped
@RegisterRestClient(configKey = "json-place-holder-api")
@RegisterClientHeaders(RequestUUIDHeaderFactory.class)
public interface JsonPlaceHolderApi {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<UserResponse> users();

}
