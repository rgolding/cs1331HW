/**
 * Represents a District
 * @author Rachel Golding
 * @version 1.0 Dec 4 2015
 */

public abstract class District {


    private String name;

/**
 * Contructor for District
 * @param name  String of name
 */
    public District(String name) {
        this.name = name;
    }

/**
 * Getter for Name
 * @return name  String of name
 */
    public String getName() {
        return name;
    }
/**
 * Gets Winner of District
 * @return String returns winner
 */
    public abstract String getWinner();
/**
 * Gets number of Voters of District
 * @return int number of voters
 */
    public abstract int getNumVoters();


}