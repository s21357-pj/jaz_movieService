package pl.pjatk.movieService.movie.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.pjatk.movieService.movie.model.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieService {
    private List<Movie> mList = new ArrayList<Movie>();
    public MovieService() {
        mList.add(new Movie("asd", Movie.Category.ANIMATED, 10));
        mList.add(new Movie("test1", Movie.Category.ANIMATED, 8));
        mList.add(new Movie("test2", Movie.Category.ANIMATED, 8));
    }
    public List<Movie> getMovies() {
        return mList;
    }
    public Movie addMovies(Movie m) {
        mList.add(m);
        return m;
    }
    public Optional<Movie> getMovies(Long id) {
        Optional<Movie> result = mList.stream().filter(m -> m.getId() == id).findFirst();
        if(result.isPresent()) {
            return result;
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity not found"
        );
    }
    public Optional<Movie> updateMovies(Long id, Movie m) {
        Optional<Movie> result = mList.stream().filter(x -> x.getId() == id).findFirst();
        if(result.isPresent()) {
            result.get().setCategory(m.getCategory());
            result.get().setName(m.getName());
            result.get().setImdb_rate(m.getImdb_rate());
            return result;
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity not found"
        );
    }
    public void deleteMovies(Long id) {
        if(!mList.removeIf(e -> e.getId() == id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }
    }
}
