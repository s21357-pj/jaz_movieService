package pl.pjatk.movieService.movie.model;

public class Movie {

    private Long id;
    private String name;
    private String category;
    private Integer imdb_rate;

    public Movie(Long id, String name, String category, Integer imdb_rate) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.imdb_rate = imdb_rate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getImdb_rate() {
        return imdb_rate;
    }

    public void setImdb_rate(Integer imdb_rate) {
        this.imdb_rate = imdb_rate;
    }

}
