

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.util.HashMap;
/**
 * Represents a Election
 * @author Rachel Golding
 * @version 1.0 Dec 4 2015
 */

public class Tester {
/**
 * Tests Code
 * @param args three files of voters/districts
 * @throws Exception NoElementFound Exception
 */

    public static void main(String[] args) throws Exception {
        String votersFile = args[2];
        String localFile = args[1];
        String compositeFile = args[0];

        ArrayList<String> existingNames = new ArrayList<String>();
        ArrayList<District> existingDistricts = new ArrayList<District>();
        ArrayList<String> allNames = new ArrayList<String>();


        ArrayList<Voter> allVoters = new ArrayList<Voter>();
        Scanner votersScanner = new Scanner(new File(votersFile));
        votersScanner.useDelimiter(":|,|\n");
        while (votersScanner.hasNext()) {
            allVoters.add(new Voter(votersScanner.next(), votersScanner.next(),
                votersScanner.next(), votersScanner.next()));
        }


        ArrayList<LocalDistrict> locDists = new ArrayList<LocalDistrict>();
        Scanner locDistScanner = new Scanner(new File(localFile));
        locDistScanner.useDelimiter(":|\n");
        while (locDistScanner.hasNext()) {
            String curName = locDistScanner.next();
            String curVoters = locDistScanner.next();
            ArrayList<Voter> theseVoters = new ArrayList<Voter>();
            String[] arrCurVoters = curVoters.split(",");
            for (int i = 0; i < arrCurVoters.length; i++) {
                for (Voter curVoter : allVoters) {
                    arrCurVoters[i] = arrCurVoters[i].trim();
                    if (curVoter.getName().equals(arrCurVoters[i])) {
                        theseVoters.add(allVoters.get(allVoters.indexOf(
                            curVoter)));
                    }
                }
            }
            existingNames.add(curName);
            allNames.add(curName);
            LocalDistrict newDist = new LocalDistrict(curName, theseVoters);
            locDists.add(newDist);
            existingDistricts.add((District) newDist);
        }


        //find main districts
        Scanner compScanner = new Scanner(new File(compositeFile));
        compScanner.useDelimiter("\n|:");
        String[] mainDistNames = compScanner.next().split(",");
        HashMap<String, String[]> allDistsMap = new HashMap<String, String[]>();
        //find compositeDistricts
        while (compScanner.hasNext()) {
            String curCompDist = compScanner.next();
            String[] curSubDists = compScanner.next().split(",");
            allDistsMap.put(curCompDist, curSubDists);
            allNames.add(curCompDist);
        }

        //Adds the districts
        while (existingNames.size() < allNames.size()) {
            for (String thisName : allDistsMap.keySet()) {
                //System.out.println(thisName);
                boolean allSubExists = true;
                boolean alreadyExists = false;
                for (String thisExistingName : existingNames) {
                    thisExistingName = thisExistingName.trim();
                    if (thisName.equals(thisExistingName)) {
                        alreadyExists = true;
                    }
                }
                if (!alreadyExists) {
                    for (int i = 0; i < allDistsMap.get(thisName).length; i++) {
                        if (!existingNames.contains(allDistsMap.get(thisName)[i]
                            .trim())) {
                            allSubExists = false;
                        }
                    }
                    if (allSubExists) {
                        ArrayList<District> containedDistricts =
                            new ArrayList<District>();
                        for (int i = 0; i < allDistsMap.get(thisName).length;
                            i++) {
                            for (District thisDist : existingDistricts) {
                                if (allDistsMap.get(thisName)[i].trim().equals(
                                    thisDist.getName())) {
                                    containedDistricts.add(thisDist);
                                }
                            }
                        }
                        District toAdd = (District) new CompositeDistrict(
                            thisName, containedDistricts);
                        //System.out.println(thisName);
                        existingDistricts.add(toAdd);
                        existingNames.add(thisName);
                    }
                }
            }
        }

        //creates arraylist with main districts
        ArrayList<District> mainDistricts = new ArrayList<District>();
        for (District thisDist : existingDistricts) {
            for (String thisMainName : mainDistNames) {
                if (thisDist.getName().trim().equals(thisMainName.trim())) {
                    mainDistricts.add(thisDist);
                    //System.out.println(thisDist.getName());
                }
            }
        }
        //finds candidates scores
        int totalVotes = 0;
        HashMap<String, Integer> candidates = new HashMap<String, Integer>();
        for (District thisDist : mainDistricts) {
            totalVotes += thisDist.getNumVoters();
            if (candidates.containsKey(thisDist.getWinner())) {
                candidates.put(thisDist.getWinner(), candidates.get(
                    thisDist.getWinner()) + thisDist.getNumVoters());
            } else {
                candidates.put(thisDist.getWinner(), thisDist.getNumVoters());
            }

        }
        //finds the winner
        int maxVotes = 0;
        String maxCand = "";
        for (String thisCand : candidates.keySet()) {
            if (candidates.get(thisCand) > maxVotes) {
                maxVotes = candidates.get(thisCand);
                maxCand = thisCand;
            }
        }
        System.out.println("Your winner is " + maxCand
            + " and they won with " + totalVotes + "votes");


        //calls the mergesort method
        LocalDistrict[] locDistsArr = locDists.toArray(new LocalDistrict[
            locDists.size()]);

        LocalDistrict[] localDistricts = MergeSort.mergeSort(locDistsArr);
        System.out.println("\nLocal Districts sorted by size.");
        for (int i = 0; i < localDistricts.length; i++) {
            System.out.println("\t" + localDistricts[i].getName() + " of size "
                + localDistricts[i].getNumVoters());
        }
    }
}