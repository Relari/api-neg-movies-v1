package pe.com.relari.dao.impl;

import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import org.jboss.logging.Logger;
import pe.com.relari.dao.MovieDao;
import pe.com.relari.dao.repository.MovieEntity;

import java.util.List;
import java.util.Optional;

@Singleton
public class MovieDaoImpl implements MovieDao {

    private static final Logger log = Logger.getLogger(MovieDaoImpl.class);

    @Override
    public List<MovieEntity> getMovies() {
        log.info("Get movies");
        return MovieEntity.listAll();
    }

    @Override
    public Optional<MovieEntity> getMovie(Integer id) {
        return Optional.ofNullable(MovieEntity.findById(id));
    }

    @Transactional
    @Override
    public void saveMovie(MovieEntity movie) {
        MovieEntity.persist(movie);
    }

}
