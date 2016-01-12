
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents a Local District
 * @author Rachel Golding
 * @version 1.0 Dec 4 2015
 */
public class LocalDistrict extends District {

//    private String name;
    private ArrayList<Voter> voters;
    private Map<String, Integer> cans = new HashMap<>();

/**
 * Contructor for Local District
 * @param name  String of name
 * @param voters ArrayList of voters
 */
    public LocalDistrict(String name, ArrayList<Voter> voters) {
        super(name);
        this.voters = voters;

    }
/**
 * Gets Number of Voters of District
 * @return Size of voters arraylist
 */
    public int getNumVoters() {
        return voters.size();
    }

//iterate through voters

/**
 * Gets Winner of District
 * @return winner String of winner
 */

    public String getWinner() {
        HashMap<String, Integer> map = new HashMap<>();
        for (Voter v : voters) {
            String[] votes = v.getVotes();
            for (int i = 0; i < 3; i++) {
                if (map.containsKey(votes[i])) {
                    int oldVotes = map.get(votes[i]);
                    int newVotes = oldVotes + (3 - i);
                    map.put(votes[i], newVotes);

                } else {
                    map.put(votes[i], (3 - i));
                }
            }
        }
        String winner = null;
        for (String c : map.keySet()) {
            if (winner == null) {
                winner = c;

            } else if (map.get(c) > map.get(winner)) {
                winner = c;
            }
        }


        return winner;
    }
    /*


    public void tallyVotes() {

        for (Voter voter : voters) {
            countVote(3, voter.firstCan());
            countVote(2, voter.secCan());
            countVote(1, voter.thirdCan());
        }
    }
    public String getWinner() {
        String winner = null;
        for (String can : cans.keySet()) {
            if (winner == null) {
                winner = can;
            } else {
                int value = cans.get(can);
                if (value > cans.get(winner)) {
                    winner = can;
                }
            }

        }
        return winner;



    }

    private void countVote(int val, String String) {
        if (!cans.containsKey(String)) {
            cans.put(String, val);
        } else {
            cans.put(String, val + cans.get(String));
        }
    }
    */

}