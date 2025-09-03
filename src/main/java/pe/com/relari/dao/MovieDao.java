package pe.com.relari.dao;

import pe.com.relari.dao.repository.MovieEntity;

import java.util.List;
import java.util.Optional;

public interface MovieDao {

    List<MovieEntity> getMovies();

    Optional<MovieEntity> getMovie(Integer id);

    void saveMovie(MovieEntity movie);

}
