import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 * Represents a Composite District
 * @author Rachel Golding
 * @version 1.0 Dec 4 2015
 */
public class CompositeDistrict extends District {

    private District locals;
//  private String name;
    private ArrayList<District> dis;
    private Map<String, Integer> cans = new HashMap<>();

/**
 * Contructor for Local District
 * @param name  String of name
 * @param dis ArrayList of districts
 */
    public CompositeDistrict(String name, ArrayList<District> dis) {
        super(name);
        this.dis = dis;
        tallyVotes();
    }

/**
 * Gets Number of Districts
 * @return Size of dis arraylist
 */
    public int getNumDis() {
        return dis.size();
    }
/**
 * Gets Number of Voters of District
 * @return voters Size of voters arraylist
 */
    public int getNumVoters() {
        int voters = 0;
        for (District d : dis) {
            voters = d.getNumVoters();
        }
        return voters;
    }
/*
    public String getWinner() {
        HashMap<String, Integer> map = new HashMap<>();
        for (District d : dis) {
            String[] districts = d.getVotes();
            for (int i = 0; i < 3; i++) {
                if (map.containsKey(votes[i])) {
                    int oldVotes = map.get(votes[i]);
                    int newVotes = oldVotes + (3 - i);
                    map.put(votes[i], newVotes);

                } else {
                    map.put(votes[i], (3-i));
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
    */

/**
 * Gets number of votes from each district
 */
    public void tallyVotes() {

        for (District d : dis) {
            int voters = d.getNumVoters();
            String c = d.getWinner();
            if (!cans.containsKey(c)) {
                cans.put(c, voters);
            } else {
                cans.put(c, voters + cans.get(c));

            }

        }
    }
/**
 * Gets Winner of District
 * @return winner String of winner
 */
    public String getWinner() {
        String winner = null;
        //System.out.println(winner);
        //System.out.println(cans.keySet())
        for (String can : cans.keySet()) {
            //System.out.println(can);
            if (winner == null) {
                winner = can;
                //System.out.println(can);
            } else {
                int value = cans.get(can);
                if (value > cans.get(winner)) {
                    winner = can;
                    //System.out.println(can);
                }
            }

        }

        return winner;




    }





}