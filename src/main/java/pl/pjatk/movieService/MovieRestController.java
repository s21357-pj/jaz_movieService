package pl.pjatk.movieService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.movieService.movie.model.Movie;
import pl.pjatk.movieService.movie.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/")
public class MovieRestController {
    private final MovieService movieService;
    public MovieRestController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getMovies() {
        return new ResponseEntity<>(movieService.getMovies(), HttpStatus.OK);
    }
}
