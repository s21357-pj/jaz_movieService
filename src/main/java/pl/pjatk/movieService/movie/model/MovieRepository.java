package pl.pjatk.movieService.movie.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query("select m from Movie m where m.id = ?1")
    Optional<Movie> findById(Long id);

    @Query("select m from Movie m")
    List<Movie> findAll();

    @Transactional
    @Modifying
    @Query("delete from Movie m where m.id = ?1")
    void deleteById(Long id);

}
