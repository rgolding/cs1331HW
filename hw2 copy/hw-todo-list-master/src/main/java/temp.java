public class temp{
	public static void main(String[] args) {
		Goal goal1 = new Goal(tasks1, "Housework")
		Task[] tasks1; 
		

		Task task1 = new Task("Clean Room", false, "5/5/5", "low");
		System.out.println(task1);

	}
}
	/*public Task[] loadTask() {

	}
	public Goal[] loadGoal() {
		Goal[] goals;
		Scanner fileScanner = null;

		try {
			fileScanner = new Scanner(new File(tshields3.csv));
			goals = fileScanner.nextLine();
			for (int i = 0; i < )

		}
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
}*/