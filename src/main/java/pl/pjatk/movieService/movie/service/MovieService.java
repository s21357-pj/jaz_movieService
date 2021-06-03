package pl.pjatk.movieService.movie.service;


import org.springframework.stereotype.Service;
import pl.pjatk.movieService.movie.model.Movie;
import pl.pjatk.movieService.movie.model.MovieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }
    public Movie addMovies(Movie m) {
        movieRepository.save(m);
        return m;
    }
    public Optional<Movie> getMovies(Long id) {
        return movieRepository.findById(id);
    }
    public Optional<Movie> updateMovies(Long id, Movie m) {
        Movie t = new Movie();
        t.setCategory(m.getCategory());
        t.setName(m.getName());
        t.setImdb_rate(m.getImdb_rate());
        t.setId(id);
        movieRepository.save(t);
        return movieRepository.findById(id);
    }
    public void deleteMovies(Long id) {
        movieRepository.deleteById(id);
    }
    public void setTrueAvailable(Long id) {
       Movie m =  movieRepository.findById(id).get();
       m.setAvailable(true);
       movieRepository.save(m);
    }
}
