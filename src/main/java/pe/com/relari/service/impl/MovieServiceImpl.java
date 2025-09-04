package pe.com.relari.service.impl;

import jakarta.inject.Singleton;
import org.jboss.logging.Logger;
import pe.com.relari.dao.MovieDao;
import pe.com.relari.dao.repository.MovieEntity;
import pe.com.relari.handler.ApiException;
import pe.com.relari.model.api.Movie;
import pe.com.relari.model.common.ErrorType;
import pe.com.relari.service.MovieService;

import java.util.List;

@Singleton
public class MovieServiceImpl implements MovieService {

    private static final Logger log = Logger.getLogger(MovieServiceImpl.class);

    private final MovieDao movieDao;

    public MovieServiceImpl(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public List<Movie> getMovies() {
        log.info("Get movies");
        return movieDao.getMovies()
                .stream()
                .map(movieEntity -> {
                    Movie movie = new Movie();
                    movie.setId(movieEntity.id.intValue());
                    movie.setTitle(movieEntity.getTitle());
                    movie.setYear(movieEntity.getReleaseYear());
                    movie.setDirector(movieEntity.getDirector());
                    return movie;
                })
                .toList();
    }

    @Override
    public Movie getMovie(Integer id) {
        log.infof("Find movie with id = %s", id);
        return movieDao.getMovie(id)
                .map(movieEntity -> {
                    Movie movie = new Movie();
                    movie.setId(movieEntity.id.intValue());
                    movie.setTitle(movieEntity.getTitle());
                    movie.setYear(movieEntity.getReleaseYear());
                    movie.setDirector(movieEntity.getDirector());
                    return movie;
                })
                .orElseThrow(() -> new ApiException(ErrorType.RESOURCE_NOT_FOUND, "Movie not found: " + id));
    }
    @Override
    public void saveMovie(Movie movie) {
        log.infof("Save movie with title = %s", movie.getTitle());
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setTitle(movie.getTitle());
        movieEntity.setReleaseYear(movie.getYear());
        movieEntity.setDirector(movie.getDirector());
        movieDao.saveMovie(movieEntity);
    }

}
