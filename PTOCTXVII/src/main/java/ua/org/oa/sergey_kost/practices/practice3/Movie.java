package ua.org.oa.sergey_kost.practices.practice3;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Movie extends Entity<Integer> {

    private String title;
    private String genre;
    private String country;
    private String description;

    Movie(String title, String genre, String country, String description) {
        this.title = title;
        this.genre = genre;
        this.country = country;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", country='" + country + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Movie movie = (Movie) o;

        if (title != null ? !title.equals(movie.title) : movie.title != null) return false;
        if (genre != null ? !genre.equals(movie.genre) : movie.genre != null) return false;
        if (country != null ? !country.equals(movie.country) : movie.country != null) return false;
        return description.equals(movie.description);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + description.hashCode();
        return result;
    }
}
