
import java.util.Scanner;
import java.io.File;

import java.io.FileNotFoundException;


public class fileScanner {

    public static void main(String[] args) {

        System.out.println(args[0]);

        Scanner goalsFile = null;

        try {

            goalsFile = new Scanner(new File(args[0]));
            while(goalsFile.hasNext()) {
                String line = goalsFile.nextLine();

                String[] aList = line.split(",");
                String goalStr = aList[0];



            }
            //System.out.println(aList);
            //System.out.println(line);
            for (int i = 0; i < goalsArray.length; i++) {
                System.out.println(goalsArray[i]);
            }

        } catch (FileNotFoundException e) {
            System.out.println("HI IT IS NOT FOUND!!!!!!");
        } finally {
            if (goalsArray != null) {
                goalsArray.close();
            }
        }
    }
}



/*        Scanner gradeFile = null;
        try {
            gradeFile = new Scanner(new File(args[0]));
            while (gradeFile.hasNext()) {
                String line = gradeFile.nextLine();
                String[] aList = line.split(",");
                String gradeStr = aList[1];


                // Integer of Grade!!!!!!
                int gradeInt = Integer.parseInt(
                    gradeStr.replaceAll("\\s+" , ""));

                //Immed put into array

                for (int i = 0; i < gradesRangeArray.length; i++) {
                    int[] currentGradeRange = gradesRangeArray[i];
                    if (currentGradeRange[0] >= gradeInt
                        && currentGradeRange[1] <= gradeInt) {
                        gradesArray[i] = gradesArray[i] + "[]";
                    }
                }


            }
        } catch (FileNotFoundException e) {
            System.out.println("HI IT IS NOT FOUND!!!!!!");
        } finally {
            if (gradeFile != null) {
                gradeFile.close();
            }
        }*/