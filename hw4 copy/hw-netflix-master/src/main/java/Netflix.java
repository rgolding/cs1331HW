import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.HashSet;
import java.util.HashMap;

/**
 * Your Netflix journey begins here!
 *
 * @author Jayanth
 * @author Srijan
 * @author PUT YOUR NAME HERE
 * @version 1.0
 */
public class Netflix {

    private static Scanner in;
    private static PopulateNetflix popPop;
    private static Random rand;
    private static Library library;
    private static List<Movie> list;


    /**
     * Main method for Netflix. This produces the high-end login screen
     * for our Netflix service that took a team of experienced
     * UI designers to create.
     *
     * @param args command-line arguments for the program.
     */
    public static void main(String[] args) throws Exception {
        in = new Scanner(System.in);
        popPop = new PopulateNetflix();
        library = new Library(popPop.getNetflixPopulation());
        // TODO: Change the variable below to be a properly type-parameterized
        // map from roommate names to a list of movies. See the instructions
        // for which roommates to add and what their watchlists should be
        Map<String, List<Movie>> userWatchLists = new HashMap<String, List<Movie>>();
        userWatchLists.put("Taylor", library.arrayListAlphabetically(library.moviesWithGenre(Genre.COMEDY)));


        ArrayList<Movie> georgeList = library.moviesWithGenre(Genre.ACTION);
        ArrayList<Movie> georgeList2 = library.moviesWithGenre(Genre.ADVENTURE);
        georgeList.addAll(georgeList2);
        HashSet<Movie> george = new HashSet<Movie>(georgeList);
        userWatchLists.put("George", new ArrayList<Movie>(library.arrayListByHighestRating(george)));

        userWatchLists.put("Sarah", library.arrayListByYearRange(1980, 1999));


        boolean running = true;
        System.out.println("Welcome to your very own Netflix service!");
        while (running) {
            System.out.println("\nNow, who's watching tonight? [q to exit]");

            String response = in.nextLine();
            if (response.equals("q")) {
                System.out.println("Thanks for watching!");
                running = false;
            } else if (userWatchLists.containsKey(response)) {


                List<Movie> watchList = userWatchLists.get(response);

                int numMovies = -1;
                while (numMovies < 1) {
                    System.out.println("How many movies would you like"
                        + " to watch? (1 - 10)");
                    try {
                        numMovies = Integer.parseInt(in.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input, please try again");
                    }
                }

                System.out.println("\nHere you go!\n");

                if (numMovies > watchList.size()) {
                    numMovies = watchList.size();
                }
                for (Movie m : watchList.subList(0, numMovies)) {
                    System.out.println(m);
                }
            } else {
                System.out.println("\nNetflix does not "
                    + "recognize that input\n");
            }
        }
    }
}
