package pe.com.relari.service;

import java.util.List;

import pe.com.relari.model.api.Movie;

public interface MovieService {

    List<Movie> getMovies();

    Movie getMovie(Integer id);

    void saveMovie(Movie movie);

}
