package pe.com.relari.resources;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import pe.com.relari.model.api.Movie;
import pe.com.relari.service.MovieService;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class MovieResourceTest {

    @Mock
    private MovieService service;

    @InjectMocks
    private MovieResource resource;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void useCaseGetAllMovie() {

        Movie movie = new Movie();
        movie.setId(1);
        movie.setTitle("Movie 1");
        movie.setDirector("Director 1");
        movie.setYear(2024);

        Mockito.when(service.getMovies())
                .thenReturn(Collections.singletonList(movie));

        var response = resource.getMovies();

        assertNotNull(response);
    }

    @Test
    void useCaseGetMovie() {

        Movie movie = new Movie();
        movie.setId(1);
        movie.setTitle("Movie 1");
        movie.setDirector("Director 1");
        movie.setYear(2024);

        Mockito.when(service.getMovie(Mockito.anyInt()))
                .thenReturn(movie);

        var response = resource.getMovie(1);

        assertNotNull(response);
    }
}