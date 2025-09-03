package pe.com.relari.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;
import pe.com.relari.config.ErrorProperties;
import pe.com.relari.dao.ws.JsonPlaceHolderApi;
import pe.com.relari.dao.ws.model.UserResponse;
import pe.com.relari.handler.ApiException;

import java.util.List;

@Path("/v1/users")
public class UserResource {

    private static final Logger log = Logger.getLogger(UserResource.class);

    ErrorProperties errorProperties;
    JsonPlaceHolderApi jsonPlaceHolderApi;

    @ConfigProperty(name = "greeting.message")
    String message;

    @Inject
    public UserResource(
            ErrorProperties errorProperties,
            @RestClient JsonPlaceHolderApi jsonPlaceHolderApi) {
        this.errorProperties = errorProperties;
        this.jsonPlaceHolderApi = jsonPlaceHolderApi;
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserResponse getUser(@PathParam("id") Integer id) {
        return jsonPlaceHolderApi.users()
                .stream()
                .filter(userResponse -> userResponse.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ApiException("User not found"));
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserResponse> users() {
        return jsonPlaceHolderApi.users();
    }
}
