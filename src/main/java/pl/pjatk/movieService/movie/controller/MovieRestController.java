package pl.pjatk.movieService.movie.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.movieService.movie.model.Movie;
import pl.pjatk.movieService.movie.service.MovieService;

import java.util.List;
import java.util.Optional;

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

    @PostMapping("/movies")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie v) {
        return new ResponseEntity<Movie>(movieService.addMovies(v), HttpStatus.OK);
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Optional<Movie>> addMovie(@PathVariable Long id) {
        return new ResponseEntity<Optional<Movie>>(movieService.getMovies(id), HttpStatus.OK);
    }
    @PutMapping("/movies/{id}")
    public ResponseEntity<Optional<Movie>> addMovie(@RequestBody Movie v, @PathVariable Long id) {
        return new ResponseEntity<Optional<Movie>>(movieService.updateMovies(id, v), HttpStatus.OK);
    }
    @PutMapping("/movies/setTrueAvailable/{id}")
    public ResponseEntity<Void> sTrue(@PathVariable Long id) {
        movieService.setTrueAvailable(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/movies/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        movieService.deleteMovies(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
