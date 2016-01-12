import java.util.HashSet;
public class Movie {

    private String name;
    private double rating;
    private int year;
    private HashSet<Genre> genres;


    public Movie(String name, double rating, int year, HashSet<Genre> genres) {
        this.name = name;
        this.rating = rating;
        this.year = year;
        this.genres = genres;



    }
    public String getName() {
        return name;
    }
    public double getRating() {
        return rating;
    }
    public int getYear() {
        return year;
    }
    public HashSet<Genre> getGenre() {
        return genres;
    }
    public String toString() {
        return ("M: " + name + rating + year);
    }
    

}