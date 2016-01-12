public class User{


    private String name;
    private Goal[] goals;

    public User(String name, Goal[] goals) {
        this.name = name;
        this.goals = goals;
    }

    public String getName() {
        return name;
    }

    public Goal[] getGoals() {
        return goals;

    }

    public void addGoal(Goal newGoal) {
        int i = 0;
        while (i < goals.length){
            if (goals[i] == null) {
                goals[i] = newGoal;
                break;
            }
        }
    
    }





    public String toString() {
        goalsStr = "";
        for (Goal g : goals) {
            goalsStr = goalsStr + "\n" + g.toString();
        }
        return ("Goals:" + "\n" + goalsStr);
    }
}