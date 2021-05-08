package pl.pjatk.movieService.movie.service;

import org.springframework.stereotype.Service;
import pl.pjatk.movieService.movie.model.Movie;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    private List<Movie> mList = new ArrayList<Movie>();
    public MovieService() {
        mList.add(new Movie((long) 1, "asd", "asd", 10));
    }
    public List<Movie> getMovies() {
        return mList;
    }
}
