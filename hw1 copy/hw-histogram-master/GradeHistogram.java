
import java.util.Scanner;
import java.io.File;

import java.io.FileNotFoundException;


public class GradeHistogram {
    public static void main(String[] args) {

        String bucketSizeStr = new String();





        if (args.length == 1) {

            //Scanner set-up
            Scanner input = new Scanner(System.in);

            System.out.println("What bucket size would you like?");

            //asssign next line from terminal to userstuff
            bucketSizeStr = input.nextLine();
        } else {
            bucketSizeStr = args[1];

        }




        // String to Int from Input
        int bucketSizeInt = Integer.parseInt(bucketSizeStr);

        // Number of Ranges for Grades
        int bucketNum = (100 / bucketSizeInt) + 1;

        //int[] gradeList = new int[bucketNum];

        String[] gradesArray = new String[bucketNum];



        int[][] gradesRangeArray = new int[bucketNum][2];
        //For loop to make each array index equal to the bucket

        int beginning = 101;

        for (int i = 0; i < bucketNum; i++) {
            //System.out.println(beginning);

            if (beginning == 101) {
                gradesArray[i] = String.valueOf(beginning - 1) + " - "
                    + String.valueOf(beginning - bucketSizeInt) + " | ";
                gradesRangeArray[i][0] = beginning - 1;
                gradesRangeArray[i][1] = beginning - bucketSizeInt;
            }


            if (beginning <= 10 && beginning >= 1) {
                gradesArray[i] = "  " + String.valueOf(beginning - 1) + " -  "
                    + String.valueOf(beginning - bucketSizeInt) + " | ";
                gradesRangeArray[i][0] = beginning - 1;
                gradesRangeArray[i][1] = beginning - bucketSizeInt;

            }
            if (beginning < 101 && beginning > 10) {

                gradesArray[i] =  " " + String.valueOf(beginning - 1)
                    + " - " + String.valueOf(beginning - bucketSizeInt) + " | ";
                gradesRangeArray[i][0] = beginning - 1;
                gradesRangeArray[i][1] = beginning - bucketSizeInt;
            }


            if (beginning >= 10 && ((beginning - bucketSizeInt) <= 10)) {
                gradesArray[i] = " " + String.valueOf(beginning - 1) + " -  "
                    + String.valueOf(beginning - bucketSizeInt) + " | ";
                gradesRangeArray[i][0] = beginning - 1;
                gradesRangeArray[i][1] = beginning - bucketSizeInt;
            }


            if (beginning == 1) {
                gradesArray[i] = "  0 -  0" + " | ";
                gradesRangeArray[i][0] = 0;
                gradesRangeArray[i][1] = 0;

            }

            if (beginning - bucketSizeInt <= 0 && beginning != 1)  {
                gradesArray[i] = "  " + String.valueOf(beginning - 1)
                    + " -  0" + " | ";
                gradesRangeArray[i][0] = 0;
                gradesRangeArray[i][1] = 0;
            }





            beginning = beginning - bucketSizeInt;


        }




        Scanner gradeFile = null;
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
        }
        for (int i = 0; i < gradesArray.length; i++) {
            System.out.println(gradesArray[i]);
        }


    }
}
