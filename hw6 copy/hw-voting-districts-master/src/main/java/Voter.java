
/**
 * Represents a Voter
 * @author Rachel Golding
 * @version 1.0 Dec 4 2015
 */
public class Voter {


    private String vote1;
    private String vote2;
    private String vote3;
    private String name;


/**
 * Contructor for Local District
 * @param name  String of name
 * @param vote1 string of first candidate
 * @param vote2 string of second candidate
 * @param vote3 string of third candidate
 */
    public Voter(String name, String vote1, String vote2, String vote3) {
        this.name = name.trim();
        this.vote3 = vote3.trim();
        this.vote1 = vote1.trim();
        this.vote2 = vote2.trim();
    }

/**
 * Gets Name of Voter
 * @return name String of Name
 */
    public String getName() {
        return name;
    }
/**
 * Gets First Candidate Choice
 * @return vote1 String of Name of vote1
 */
    public String firstCan() {

        return vote1;
    }
/**
 * Gets Second Candidate Choice
 * @return vote2 String of Name of vote2
 */

    public String secCan() {

        return vote2;
    }
/**
 * Gets Third Candidate Choice
 * @return vote3 String of Name of vote3
 */
    public String thirdCan() {

        return vote3;
    }
/**
 * Gets Array of Candidates
 * @return allVotes Array of votes
 */
    public String[] getVotes() {

        String[] allVotes = {vote1, vote2, vote3};
        return allVotes;

    }




}