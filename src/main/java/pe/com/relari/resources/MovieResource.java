package pe.com.relari.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import pe.com.relari.model.api.Movie;
import pe.com.relari.model.common.DefaultResponse;
import pe.com.relari.service.MovieService;

@Path("/v1/movies")
public class MovieResource {

    private final MovieService service;

    @Inject
    public MovieResource(MovieService service) {
        this.service = service;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMovies() {
        return Response.ok(DefaultResponse.okResponse(service.getMovies())).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMovie(@PathParam("id") Integer id) {
        return Response.ok(DefaultResponse.okResponse(service.getMovie(id))).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addMovie(Movie movie) {
        service.saveMovie(movie);
        return Response.status(Response.Status.CREATED).build();
    }

}