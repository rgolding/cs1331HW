
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class TodoList {


    public static void main(String[] args) {
        User[] userArrayObj = fileToUser();
    }

    public static User[] fileToUser() {

     
        User[] userArrayObj;
        Scanner fileScanner = null;

        try {
            fileScanner = new Scanner(new File(users.csv);
            String line = fileScanner.nextLine();
            String[] userArrayStr = line.split(", ");
            userArrayObj = new User[userArrayStr.length];
            for (int i = 0, i < userArrayStr.length, i++) {
                userArrayObj[i] = new User(userArrayStr[i], 
                    loadFile(userArrayStr[i]); 

            }


        } catch (FileNotFoundException e) {
            System.out.println("HI IT IS NOT FOUND!!!!!!");

        } finally {
            if (fileScanner != null) {
                fileScanner.close();

            }
        }

        return userArrayObj;
    }


    public Goal[] loadFile(String name) {
        Goal[] goals;
        for (User x : userArrayObj) {
            File file = new File(x.getName() + ".csv")
            if (!file.createNewFile()) {
                //returns true if new file was created--> file will be empty
                while (file.hasNext()) {
                    String[] line = line.split(", ");
                    for (String s : line) {
                        if (!s.equals(line[0])) {

                        }
                    }
                }
            }
        }
    }
    public Task[] loadTask()

}




/*
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


