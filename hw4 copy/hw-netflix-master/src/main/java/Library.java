import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
//import java.util.List;
//import java.util.Iterator;
import java.util.HashSet;
public class Library {
    private ArrayList<Movie> movies = new ArrayList();
    public Library(ArrayList<Movie> m) {
        movies = m;

    }
    public ArrayList<Movie> arrayListAlphabetically() {
        ArrayList<Movie> newSet = new ArrayList<Movie>(movies);

        Collections.sort(newSet, new Comparator<Movie>() {
            public int compare(Movie a, Movie b) {
                return a.getName().compareTo(b.getName());
            }
        });
        return newSet;
    }


    public ArrayList<Movie> arrayListAlphabetically(ArrayList<Movie> list) {

        Collections.sort(list, new Comparator<Movie>() {
            public int compare(Movie a, Movie b) {
                return a.getName().compareTo(b.getName());
            }
        });
        return list;
    }


    public ArrayList<Movie> moviesWithGenre(Genre g) {
        //Iterator<Movie>  it = movies.Iterator();

        ArrayList<Movie> newSet = new ArrayList<Movie>(movies);
        for (Movie m : newSet) {
            if (!m.getGenre().contains(g)) {
                newSet.remove(m);
            }
        }
        return newSet;



    }
    public ArrayList<Movie> arrayListByYearRange(int s, int e) {
        ArrayList<Movie> newSet = new ArrayList<Movie>(movies);


        for (Movie m : newSet) {
            if (!(m.getYear() >= s && m.getYear() <= e)) {
                newSet.remove(m);
            }
        }
        return newSet;

    }
    public ArrayList<Movie> arrayListByLowestRating() {
        ArrayList<Movie> newSet = new ArrayList<Movie>(movies);

        Collections.sort(newSet, new Comparator<Movie>() {
            public int compare(Movie a, Movie b) {
                if (a.getRating() < b.getRating()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        return newSet;
    }
    public ArrayList<Movie> arrayListByHighestRating() {
        ArrayList<Movie> newSet = new ArrayList<Movie>(movies);

        Collections.sort(newSet, new Comparator<Movie>() {
            public int compare(Movie a, Movie b) {
                if (a.getRating() > b.getRating()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        return newSet;
    }
    public ArrayList<Movie> arrayListByHighestRating(HashSet<Movie> list) {
        ArrayList<Movie> newSet = new ArrayList<Movie>(list);

        Collections.sort(newSet, new Comparator<Movie>() {
            public int compare(Movie a, Movie b) {
                if (a.getRating() > b.getRating()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        return newSet;
    }


}

