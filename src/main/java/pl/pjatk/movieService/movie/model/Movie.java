package pl.pjatk.movieService.movie.model;

import java.util.concurrent.atomic.AtomicLong;

public class Movie {

    private static final AtomicLong count = new AtomicLong(0);
    private Long id;
    private String name;
    private Category category;
    private Integer imdb_rate;

    public enum Category {
        ANIMATED,
        COMEDY,
        FANTASY,
        HISTORICAL,
        HORROR,
        MUSICAL

    }

    public Movie(String name, Category category, Integer imdb_rate) {
        this.id = count.incrementAndGet();
        this.name = name;
        this.category = category;
        this.imdb_rate = imdb_rate;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getImdb_rate() {
        return imdb_rate;
    }

    public void setImdb_rate(Integer imdb_rate) {
        this.imdb_rate = imdb_rate;
    }

}
